import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/****************************************
 *                                      *
 *                                      *
 * Created by yacikgoz on 22.02.2017.   *
 *                                      *
 *                                      *
 ***************************************/
public class Main {


    public static void main(String [] args){
        final String booksFile = "src/data/Books.csv";
        final String usersFile = "src/data/Users.csv";

      //  readFile(usersFile);
        LibraryStaff libraryStaff = new LibraryStaff();
        Book book = new Book("fafa", "adas", "afasa");
        libraryStaff.addBook(book);
    }

}
