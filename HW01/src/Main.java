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
        User user;
        final String booksFile = "src/data/Books.csv";
        final String usersFile = "src/data/Users.csv";

        ArrayList <Book> books;

        user = new LibraryStaff("yasin", "yacikgoz", "123456");
        LibraryStaff libraryStaff = new LibraryStaff("yasin", "yacikgoz", "123456");
/*    if(user instanceof LibraryStaff){
            System.out.println("STAFF");
        } else if( user instanceof LibraryUser){
            System.out.println("USER");
        }*/

        //  readFile(usersFile);

      /*  LibraryStaff libraryStaff = new LibraryStaff();
        LibraryUser libraryUser = new LibraryUser("yasin açıkgöz", "yacikgoz1", "123456");

        Book book = new Book("absolute c++", "savitch");
        Book book1 = new Book("data structures", "koffman");
        System.out.println("user: " + libraryUser.toString());
        libraryStaff.addUser(libraryUser);*/

       // libraryStaff.addBook(book);
       // books = libraryStaff.addBook(book1);
    //    books = libraryUser.barrowBook(2);
    //    printBooks(books);
        //   libraryStaff.removeBook(2);

        //libraryStaff.barrowBook(book);
        //  libraryStaff.barrowBook(book);
    }
    public static void printBooks(ArrayList <Book> books){
        System.out.println("------------------------------\n");
        for(int i = 0; i<books.size(); ++i)
            System.out.println(books.get(i).toString());
        System.out.println("------------------------------\n");
    }

}
