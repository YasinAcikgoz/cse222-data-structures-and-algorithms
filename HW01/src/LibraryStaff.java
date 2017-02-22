import java.io.*;
import java.util.ArrayList;

/**
 *
 * Created by yacikgoz on 20.02.2017.
 */
public class LibraryStaff extends User{
    public ArrayList<Book> addBookToDB(Book book) throws IOException {
        if(book != null)
            return book.addBook();
        else
            return null;
    }

}
