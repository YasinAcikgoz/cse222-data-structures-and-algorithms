import java.io.IOException;
import java.util.ArrayList;

/**
 *
 *
 * Created by yacikgoz on 22.02.2017.
 */
public interface IBook {
    ArrayList <Book> addBook() throws IOException;
    ArrayList <Book>  removeBook(Book book) throws IOException;
    void updateBook(Book book);
    void barrowBook(Book book);
    void returnBook(Book book);

}
