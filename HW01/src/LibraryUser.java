import java.io.*;
import java.util.ArrayList;

/**
 *
 * Created by yacikgoz on 20.02.2017.
 */
public class LibraryUser extends User implements IBook{
    private final int userMode=-1;
    private final int staffMode=-1;

    @Override
    void promptMenu() {

        super.promptMenu();
        System.out.println("LibraryUser.promptMenu");
    }

    public LibraryUser(String name, String userName, String password){

        super(name, userName, password);
    }
    public LibraryUser(){
        super();
    }
    @Override
    public ArrayList<Book> addBook(Book book) throws IOException {
        return null;
    }

    @Override
    public ArrayList<Book> removeBook(int id) throws IOException {
        return null;
    }

    @Override
    public ArrayList<Book> updateBook(Book oldBook, Book newBook) throws IOException {
        return null;
    }

    @Override
    public ArrayList<Book>  barrowBook(int id) throws IOException {
        bookList = readBookFile(userMode);
        System.out.println("index: " + id + " bookList: " + bookList.toString());
        Book book = checkBookId(id, bookList);
        if(book.getAvailability()){
            bookList.get(id).setAvailability(false);
            refreshDatabase(true, bookList.get(id), id);
        } else{

        }
        writeBooks(bookList);
        return bookList;
    }

    @Override
    public ArrayList<Book>  returnBook(int id) throws IOException {
        bookList = readBookFile(userMode);
        System.out.println("index: " + id + " bookList: " + bookList.toString());
        if(!bookList.get(id).getAvailability()){
            bookList.get(id).setAvailability(true);
            refreshDatabase(false, bookList.get(id), id);
        } else{

        }
        writeBooks(bookList);

        return null;
    }
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
        }
        writer.close();
    }
}
