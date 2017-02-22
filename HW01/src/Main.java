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


    public static void main(String [] args) throws IOException {
        final String booksFile = "src/data/Books.csv";
        final String usersFile = "src/data/Users.csv";

      //  readFile(usersFile);
        LibraryStaff libraryStaff = new LibraryStaff();
        Book book = new Book("fafa", "adas", "afasa");
        ArrayList <Book> books = libraryStaff.addBookToDB(book);
        printBooks(books);

    }
    public static void printBooks(ArrayList <Book> books){
        for(int i = 0; i<books.size(); ++i)
            System.out.println(books.get(i).toString());
    }

}
