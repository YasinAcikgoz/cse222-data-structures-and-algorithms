import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * Created by yacikgoz on 20.02.2017.
 */
public class LibraryStaff extends User implements IBook{
    final String booksFile = "src/data/Books.csv";
    final String usersFile = "src/data/Users.csv";

    @Override
    public void addBook(Book book) {
        ArrayList<Book> list;
        list = readBookFile();
        for(int i=0; i<list.size(); ++i){
            System.out.println(list.get(i).toString());
        }
        list.add(book);
        
    }

    @Override
    public void removeBook(Book book) {

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void barrowBook(Book book) {

    }

    @Override
    public void returnBook(Book book) {

    }
    public ArrayList readBookFile() {
        ArrayList <Book> list = new ArrayList<>();
        try {
            File file = new File(booksFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String [] temp = line.split(";");
                Book tempBook = new Book(temp[0], temp[1], temp[2]);
                list.add(tempBook);
                System.out.println(tempBook.toString());
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList readUserFile() {
        ArrayList <User> list = new ArrayList<>();
        try {
            File file = new File(usersFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String [] temp = line.split(";");
                User tempUser = new User(temp[0], temp[1], temp[2]);
                list.add(tempUser);
                System.out.println(tempUser.toString());
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
