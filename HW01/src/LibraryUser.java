import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * library user sinifi
 * Created by yacikgoz on 20.02.2017.
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
        String prompt = "------------------------\n" + "bb -> barrow book\n" + "rb -> return book\n" +
                "lmb -> list my books\n" + "lb -> list available books\n" + super.promptMenu() +
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
    public ArrayList<Book>  barrowBook(int bookID, int userID) throws IOException {
        bookList = readBookFile(userMode);
        System.out.println("index: " + bookID + " bookList: " + bookList.toString());
        Book book = checkBookId(bookID, bookList);
        if(book==null){
            System.out.println("This book is not in the database.");
        } else if(book.getAvailability()){
            bookList.get(bookID).setAvailability(false);
            System.out.println("BOOK: " + bookList.get(bookID).printBook());
            refreshDatabase(true, bookList.get(bookID), userID);
        } else{
            System.out.println("This book can not be borrowed because it is borrowed to another user.");
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
        System.out.println("index: " + bookID + " bookList: " + bookList.toString());
        if(!bookList.get(bookID).getAvailability()){
            bookList.get(bookID).setAvailability(true);
            refreshDatabase(false, bookList.get(bookID), userID);
        } else{

        }
        writeBooks(bookList);

        return null;
    }

    /**
     * kullanicinin kitaplarinin bulundugu dosyayi günceller.
     * @param status ekleme veya silme operasyonu
     * @param book eklenecek veya silinecek kitap objesi
     * @param userID kullanici id'si
     * @throws IOException exception
     */
    private void refreshDatabase(boolean status, Book book, int userID) throws IOException {
        String fileName = "src/data/" +  userID + "_books.csv";
        PrintWriter writer = new PrintWriter(new FileWriter(fileName));
        ArrayList <Book> list = readBookFile(userID);
        if(status)
            list.add(book);
        else
            list.remove(book);

        for(int i=0; i<list.size(); ++i){
            //  System.out.println(bookList.get(i).toString());
            list.get(i).setId(i);
            writer.println(list.get(i).toString());
            System.out.println(list.get(i).toString());
        }
        writer.close();
    }
}
