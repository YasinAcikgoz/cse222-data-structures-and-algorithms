import java.io.*;
import java.util.ArrayList;

/**
 *
 * Created by yacikgoz on 20.02.2017.
 */
public class LibraryStaff extends User implements IBook, IUser{
    private final int staffMode=-1;

    public LibraryStaff(){
        super();
    }
    public LibraryStaff(String name, String userName, String password){
        super(name, userName, password);
    }

    @Override
    public ArrayList <Book>  addBook(Book book) throws IOException {
        bookList = readBookFile(staffMode);
        book.setAvailability(true);
        book.setId(bookList.size()+1);
        System.out.println("book : " + book.toString());
        bookList.add(book);
        writeBooks(bookList);
        return bookList;
    }

    @Override
    public ArrayList <Book> removeBook(int id) throws IOException {

        bookList = readBookFile(staffMode);
        System.out.println("id: " + id + " bookList " + bookList.toString());
        Book book = checkBookId(id, bookList);

        if(book==null){
            System.out.println("Böyle bir kitap yok...");
        } else if(book.getAvailability()) {
            System.out.println("Seçilen kitap silinemez.");
        } else{
            System.out.println("id: " + id + " deleted: " + book.toString());
            bookList.remove(book);
            writeBooks(bookList);
        }
        return bookList;
    }

    @Override
    public ArrayList <Book> updateBook(Book oldBook, Book newBook) throws IOException {
     /*   ArrayList<Book> bookList;
        bookList = readBookFile();
        System.out.println(bookList.toString());
        int id = getBookId(oldBook, bookList);
       // System.out.println("-------id: " + id );
        if(id!=-1){
            bookList.remove(oldBook);
         //   System.out.println("remove: " + bookList.toString());
            newBook.setId(id);
            bookList.add(newBook);
         //   System.out.println("add: " + bookList.toString());
            writeBooks(bookList);
            return bookList;
        }else{
            System.out.println("degistirilecek kitap yok");
            return null;
        }*/
     return  null;
    }

    @Override
    public ArrayList<Book>  barrowBook(int id) {
        try {
            throw  new NoSuchMethodException("method yok");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ArrayList<Book>  returnBook(int id) {

        return null;
    }

    @Override
    public ArrayList<User> addUser(User user) throws IOException {
        userList = readUserFile();
        user.setId(userList.size()+1);
        if(checkUser(user)){
            System.out.println("user : " + user.toString());
            userList.add(user);
            writeUsers(userList);
        } else{
            System.out.println("eklenmek istenen user zaten var.");
        }

        return userList;
    }

    @Override
    public ArrayList<User> deleteUser(User user) throws IOException {

        return userList;
    }
    private boolean checkUser(User user){
        for(int i=0 ; i<userList.size(); ++i){
            if(userList.get(i).getUserName().equals(user.getUserName()) || userList.get(i).getId() == user.getId()){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    void promptMenu() {
        System.out.println("LibraryStaff.promptMenu");
    }
}
