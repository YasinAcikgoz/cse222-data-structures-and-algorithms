import java.io.*;
import java.util.ArrayList;

/**
 *
 * Created by yacikgoz on 22.02.2017.
 */
public class Book implements IBook {
    private String name;
    private String author;
    private String ISBN; // International Standard Book Number

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Book(String name, String author, String isbn){
        setName(name);
        setAuthor(author);
        setISBN(isbn);
    }

    @Override
    public ArrayList <Book>  addBook() throws IOException {
        ArrayList<Book> list;
        list = readBookFile();

    ////    for(int i=0; i<list.size(); ++i)
       //     System.out.println(list.get(i).toString());

        list.add(this);
        writeFile(list);
        return list;
    }

    @Override
    public ArrayList <Book> removeBook(Book book) throws IOException {
        ArrayList<Book> list;
        list = readBookFile();
       // for(int i=0; i<list.size(); ++i)
       //     System.out.println(list.get(i).toString());

        list.remove(this);
        writeFile(list);
        return list;
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
        String booksFile = "src/data/Books.csv";
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
//                System.out.println(tempBook.toString());
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList readUserFile() {
        String usersFile = "src/data/Users.csv";
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
    private void writeFile(ArrayList <Book> list) throws IOException {
        String booksFile = "src/data/Books.csv";
        PrintWriter writer = new PrintWriter(new FileWriter(booksFile));

        for(int i=0; i<list.size(); ++i)
            writer.println(list.get(i).toString());
        writer.close();
    }

    @Override
    public String toString() {
        return getName() + ";" + getAuthor() + ";" + getISBN();

    }
}
