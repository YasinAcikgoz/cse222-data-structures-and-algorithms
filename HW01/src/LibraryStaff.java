import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Created by yacikgoz on 20.02.2017.
 */
public class LibraryStaff extends User implements IBook, IUserOperations {
    private final int staffMode=-1;

    public LibraryStaff(){
        super();
    }
    public LibraryStaff(String name, String userName, String password){
        super(name, userName, password);
        setType("staff");
    }
    /**
     * veri tabanina kitap ekleyen method
     * @param book veri tabanina eklenecek kitap objesi
     * @return kitap listesi
     * @throws IOException exception
     */
    @Override
    public ArrayList <Book>  addBook(Book book) throws IOException {
        bookList = readBookFile(staffMode);
        book.setAvailability(true);
        book.setId(bookList.size()+1);
        bookList.add(book);
        writeBooks(bookList);
        System.out.println(book.printBook() + " added.");
        return bookList;
    }
    /**
     * veri tabanindan kitap silen method
     * @param id veri tabanindan silinecek kitap objesi
     * @return kitap listesi
     * @throws IOException exception
     */
    @Override
    public ArrayList <Book> deleteBook(int id) throws IOException {

        bookList = readBookFile(staffMode);
        Book book = checkBookId(id, bookList);
        if(book==null){
            System.out.println("This book is not in the database.");
        } else if(!book.getAvailability()) {
            System.out.println("This book can not be deleted because it is borrowed.");
        } else{
            bookList.remove(book);
            writeBooks(bookList);
            System.out.println(book.printBook() + " deleted.");
        }
        return bookList;
    }
    /**
     * libraryUser'in kitap almasini saglayan method.
     * @param bookID alinacak kitap id'si
     * @param userID user'in id'si
     * @return kitap listesi
     * @throws IOException exception
     */
    @Override
    public ArrayList<Book> barrowBook(int bookID, int userID) throws IOException {
        return null;
    }
    /**
     * libraryUser'in aldigi kitabi geri vermesini saglayan method
     * @param bookID geri verilecek kitap id'si
     * @param userID user'in id'si
     * @return kitap listesi
     * @throws IOException exception
     */
    @Override
    public ArrayList<Book> returnBook(int bookID, int userID) throws IOException {
        try {
            throw  new NoSuchMethodException("method yok");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * user veri tabanina kullanici ekleyen method.
     * @param user eklenecek user
     * @return user list
     * @throws IOException exception
     */
    @Override
    public ArrayList<User> addUser(User user) throws IOException {
        userList = readUserFile();
        user.setId(userList.size()+1);
        if(checkUser(user)){
            userList.add(user);
            writeUsers(userList);
            System.out.println(user.getName() + " added to database.");
        } else{
            System.out.println("The user you want to add already exists.");
        }

        return userList;
    }
    /**
     * user veri tabanindan kullanici silen method.
     * @param id silinecek user id'si
     * @return user list
     * @throws IOException exception
     */
    @Override
    public ArrayList<User> deleteUser(int id) throws IOException {
        userList = readUserFile();
        User user = null;
        if (userList.size()>id)
            user = userList.get(id);

        if(user!=null){
            userList.remove(user);
            writeUsers(userList);
            System.out.println(user.getName() + " deleted from database.");
        } else{
            System.out.println("The user you want to delete not in database.");
        }
        return userList;
    }

    /**
     * verilen kullanicinin veri tabaninda olup olmadigini kontrol eden metod.
     * @param user kontrol edilecek kullanici objesi
     * @return true user varsa, false yoksa
     */
    private boolean checkUser(User user){
        for(int i=0 ; i<userList.size(); ++i){
            if(userList.get(i).getUserName().equals(user.getUserName()) || userList.get(i).getId() == user.getId()){
                return false;
            }
        }
        return true;
    }

    /**
     * Kullaniciya yapabilecegi islemleri gösteren ve komut alan metod
     * @return seçilen komut
     */
    @Override
    protected String promptMenu() {
        Scanner scanInput = new Scanner(System.in);
        String command;
        String prompt = "------------------------\n" + "au -> add user\n" + "du -> delete user\n" +
                "ab -> add book\n" + "db -> delete book\n"+ "lb -> list books\n" + "lu -> list users\n" + super.promptMenu() +
                "------------------------\n" + "Please enter a command > ";
        System.out.print(prompt);
        command = scanInput.nextLine();
        return command;
    }
}
