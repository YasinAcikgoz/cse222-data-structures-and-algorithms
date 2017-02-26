import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * User'dan extend olup IBook interface'ini implement eden LibraryUser sinifi
 *
 */

public class LibraryUser extends User implements IBook{
    private final int userMode=-1;

    /**
     * Kullaniciya yapabilecegi islemleri gösteren ve komut alan metod
     * @return seçilen komut
     */
    @Override
    protected String promptMenu() {
        Scanner scanInput = new Scanner(System.in);
        String command;
        String prompt = "------------------------\n" + " bb -> barrow book\n" + " rb -> return book\n" +
                "lmb -> list my books\n" + "lab -> list available books\n" + super.promptMenu() +
                "------------------------\n" + "Please enter a command > ";
        System.out.print(prompt);
        command = scanInput.nextLine();
        return command;
    }

    /**
     * libraryUser constructor
     * @param name kullanicinin adi
     * @param userName kullanici adi
     * @param password kullanici parolasi
     */
    public LibraryUser(String name, String userName, String password){
        super(name, userName, password);
        setType("user");
    }

    /**
     * libraryUser no parameter constructor
     */
    public LibraryUser(){
        super();
    }

    /**
     * veri tabanina kitap ekleyen method
     * @param book veri tabanina eklenecek kitap objesi
     * @return kitap listesi
     * @throws IOException exception
     */
    @Override
    public ArrayList<Book> addBook(Book book) throws IOException {
        return null;
    }
    /**
     * veri tabanindan kitap silen method
     * @param id veri tabanindan silinecek kitap objesi
     * @return kitap listesi
     * @throws IOException exception
     */
    @Override
    public ArrayList<Book> deleteBook(int id) throws IOException {
        return null;
    }
    /**
     * libraryUser'in kitap almasini saglayan method.
     * @param bookID alinacak kitap id'si
     * @param userID user'in id'si
     * @return kitap listesi
     * @throws IOException exception
     */
    @Override
    public ArrayList<Book> borrowBook(int bookID, int userID) throws IOException {
        bookList = readBookFile(userMode);
        ArrayList <Book> myBooks = readBookFile(userID);
        Book book = checkBookId(bookID, bookList);
        if(book==null){
            System.out.println("This book is not in the database.");
        } else if(book.getAvailability()){
            book.setAvailability(false);
            refreshDatabase(true, book, userID, myBooks, bookID);
        } else{
            System.out.println("This book can not borrowed.");
        }
        writeBooks(bookList);
        return bookList;
    }
    /**
     * libraryUser'in aldigi kitabi geri vermesini saglayan method
     * @param bookID geri verilecek kitap id'si
     * @param userID user'in id'si
     * @return kitap listesi
     * @throws IOException exception
     */
    @Override
    public ArrayList<Book>  returnBook(int bookID, int userID) throws IOException {
        bookList = readBookFile(userMode);
        ArrayList <Book> myBooks = readBookFile(userID);

        //
        Book book = getBookFromID(bookID, bookList);
        int index = getBookIndex(myBooks, book);
        if(index>-1){
            if(myBooks.get(index).equals(book)){
                if(!book.getAvailability() && id>=0){
                    refreshDatabase(false, book, userID, myBooks, bookID);
                } else{
                    System.out.println("This book can not return.");
                }
                writeBooks(bookList);
            }
        }
        else
            System.out.println("Wrong book ID!!!");
       /* if(bookID <= bookList.size()){
            if(!bookList.get(bookID).getAvailability() && id>=0){
                refreshDatabase(false, bookList.get(bookID), userID, myBooks, bookID);
            } else{
                System.out.println("This book can not return.");
            }
            writeBooks(bookList);
        } else {
            System.out.println("Wrong book ID!!!");
        }*/
        return bookList;
    }

    /**
     * kullanicinin kitaplarinin bulundugu dosyayi günceller.
     * @param status ekleme veya silme operasyonu
     * @param book eklenecek veya silinecek kitap objesi
     * @param userID kullanici id'si
     * @throws IOException exception
     */
    private void refreshDatabase(boolean status, Book book, int userID, ArrayList <Book> list, int bookID) throws IOException {
        String fileName = "src/data/" +  userID + "_books.csv";
        PrintWriter writer = new PrintWriter(new FileWriter(fileName));
        if(status){
            if(list ==null){
                list = new ArrayList<Book>();
                book.setAvailability(false);
                list.add(book);
            } else{
                book.setAvailability(false);
                list.add(book);
            }
            System.out.println(book.getName() + " book borrowed.");
        }
        else{
            int index = getBookIndex(list,book);
            if(index>-1) {
                bookList.get(getBookIndex(bookList, book)).setAvailability(true);
                list.remove(index);
                System.out.println(book.getName() + " book returned.");
            }
        }

        for(int i=0; i<list.size(); ++i){
            list.get(i).setId(list.get(i).getId());
            writer.println(list.get(i).toString());
        }
        writer.close();
    }
    private int getBookIndex(ArrayList <Book> list, Book book){
        for (int i=0 ;i<list.size(); ++i)
            if(list.get(i).equals(book)){
                return i;
            }
        return -1;
    }
    private Book getBookFromID(int id, ArrayList <Book> list){
        for (int i=0 ;i<list.size(); ++i)
            if(list.get(i).getId() == id){
                return list.get(i);
            }
        return null;
    }


}
