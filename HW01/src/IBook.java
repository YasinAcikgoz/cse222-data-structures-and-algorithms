import java.io.IOException;
import java.util.ArrayList;

/**
 *
 *
 * Created by yacikgoz on 22.02.2017.
 */
public interface IBook {
    ArrayList <Book> addBook(Book book) throws IOException;
    ArrayList <Book>  removeBook(int id) throws IOException;
    ArrayList <Book>  updateBook(Book oldBook, Book newBook) throws IOException;
    ArrayList <Book>  barrowBook(int id) throws IOException;
    ArrayList <Book>  returnBook(Book book);

}
