import java.io.*;
import java.util.ArrayList;

/**
 *
 * Created by yacikgoz on 20.02.2017.
 */
public class User {

    private String name;
    private String userName;
    private String password;
    private int id;
    protected ArrayList<Book> bookList;
    protected ArrayList<User> userList;



    public User(String name, String userName, String password){

        if(name !=null || userName!=null || password !=null){
            setName(name);
            setPassword(password);
            setUserName(userName);
        }
    }
    public User(){
        setName("unknown");
        setPassword("unknown");
        setUserName("unknown");
        setId(-1);
    }
    protected String getUserName() { return userName; }
    protected void setUserName(String userName) {
        this.userName = userName;
    }
    protected String getPassword() {
        return password;
    }
    protected void setPassword(String password) {
        this.password = password;
    }
    protected String getName() {
        return name;
    }
    protected void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return getName() + ";" + getId() + ";" + getUserName() + ";" + getPassword();
    }


    protected ArrayList readUserFile() {
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
    protected void writeBooks(ArrayList <Book> list) throws IOException {
        String booksFile = "src/data/Books.csv";
        PrintWriter writer = new PrintWriter(new FileWriter(booksFile));

        for(int i=0; i<list.size(); ++i){
            list.get(i).setId(i);
            writer.println(list.get(i).toString());
        }
        writer.close();
    }

    protected void writeUsers(ArrayList <User> list) throws IOException {
        String usersFile = "src/data/Users.csv";
        PrintWriter writer = new PrintWriter(new FileWriter(usersFile));
        for(int i=0; i<list.size(); ++i){
            list.get(i).setId(i);
            writer.println(list.get(i).toString());
        }
        writer.close();
    }
    protected ArrayList readBookFile(int userID) {
        String fileName;
        if(userID == -1)
            fileName = "src/data/Books.csv";
        else
            fileName = "src/data/" + userID + "_books.csv";
        ArrayList <Book> list = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            int id = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String [] temp = line.split(";");
                Book tempBook = new Book(temp[0], temp[1]);
                tempBook.setId(id);
                ++id;
                list.add(tempBook);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    protected Book checkBookId(int id, ArrayList<Book> list){
        for(int i=0; i<list.size(); ++i){
            System.out.println("idnum: " + list.get(i).getId());
            if(list.get(i).getId()==id){
                System.out.println("delete: " + list.get(i).toString());
                return list.get(i);
            }
        }
        return null;
    }
    protected int getBookId(Book book, ArrayList<Book> list){
        for(int i=0; i<list.size(); ++i){
            //  System.out.println("idnum: " + bookList.get(i).getId());
            if(list.get(i).toString().equals(book.toString())){
                // System.out.println("delete: " + bookList.get(i).toString());
                return i;
            }
        }
        return -1;
    }
}
