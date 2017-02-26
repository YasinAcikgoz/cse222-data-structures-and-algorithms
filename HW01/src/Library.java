import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Library islemlerinin yapildigi main'in de bulundugu sinif
 *
 */
public class Library {

    private static ArrayList <User> users;
    private static ArrayList <Book> books;
    private static int userID, userIndex;

    /**
     * Library islemlerinin gerceklestirilecegi main fonksiyonu
     * @param args arguments
     * @throws IOException exception
     */
    public static void main(String [] args) throws IOException {
        User user = null;
        books = null;
        String command;

        users = AbstractUser.readUserFile();
        books = AbstractUser.readBookFile(-1);
        if(users.isEmpty()){
            System.out.println("User database is empty.");
        } else{
            String username, password;
            while (true){
                Scanner scanInput = new Scanner(System.in);
                System.out.println("-------LOGIN SCREEN------");
                System.out.print("Enter your username > ");
                username = scanInput.nextLine();
                System.out.print("Enter your password > ");
                password = scanInput.nextLine();
                /*username = "admin";
                password = "123456";*/
               /* username = "yacikgoz";
                password = "1111";*/
               // System.out.println("username: " + username + " password: " + password);
                userID = checkUser(username, password);
                userIndex = getUserIndex(username, password);
                if(userID >=0){
                    if(users.get(userIndex).getType().equals("staff")){
                        user = new LibraryStaff(users.get(userIndex).getName(), users.get(userIndex).getUserName(), users.get(userIndex).getPassword());
                    } else if (users.get(userIndex).getType().equals("user")){
                        user = new LibraryUser(users.get(userIndex).getName(), users.get(userIndex).getUserName(), users.get(userIndex).getPassword());
                    }
                    break;
                } else{
                    System.out.println("Your username or password is wrong. Please try again.");
                }
            }
        }
          while(true){
            if(user instanceof LibraryStaff){
                command = user.promptMenu();
                Scanner scanInput = new Scanner(System.in);
                if(command.equals("q"))
                    System.exit(0);
                else if(command.equals("lu")){
                    printUsers();
                } else if(command.equals("lb")){
                    printBooks(books);
                } else if(command.equals("ab")){
                    System.out.print("Enter Book Name > ");
                    String name = scanInput.nextLine();
                    System.out.print("Enter Author Name > ");
                    String author = scanInput.nextLine();
                    Book book = new Book(name, author, true);
                    books = ((LibraryStaff) user).addBook(book);

                } else if(command.equals("db")){
                    printBooks(books);
                    System.out.print("Enter Book ID > ");
                    String sid = scanInput.nextLine();
                    if(sid.matches("\\d+")){
                        int id = Integer.parseInt(sid);
                        books = ((LibraryStaff) user).deleteBook(id);
                    } else
                        System.out.println("ID is not valid.");
                } else if(command.equals("au")){
                    String name, username, password, type;
                    while(true){
                        System.out.print("Enter Name > ");
                        name = scanInput.nextLine();
                        if(name.length()>=2)
                            break;
                        else
                            System.out.println("The name must be at least 2 digits.");
                    }
                    while(true){
                        System.out.print("Enter Username > ");
                        username = scanInput.nextLine();
                        if(name.length()>=4 && checkUser(username))
                            break;
                        else if(!checkUser(username))
                            System.out.println("This username already exists.");
                        else
                            System.out.println("The username must be at least 4 digits");
                    }
                    while(true){
                        System.out.print("Enter Password > ");
                        password = scanInput.nextLine();
                        if(name.length()>=4)
                            break;
                        else
                            System.out.println("The password must be at least 4 digits");
                    }
                    while(true){
                        System.out.print("Enter User Type (staff/s or user/u) > ");
                        type = scanInput.nextLine();
                        if(type.equals("staff") || type.equals("s") || type.equals("user") || type.equals("u")){
                            break;
                        } else
                            System.out.println("Wrong user type!!!");
                    }
                    User userToAdd = null;
                    if(type.equals("staff") || type.equals("s")){
                        userToAdd = new LibraryStaff(name,username,password);
                    } else if(type.equals("user") || type.equals("u")){
                        userToAdd = new LibraryUser(name, username, password);
                    }
                    users = ((LibraryStaff) user).addUser(userToAdd);

                } else if(command.equals("du")){
                    System.out.print("Enter user ID to delete > ");
                    String sid = scanInput.nextLine();
                    if(sid.matches("\\d+")){
                        int id = Integer.parseInt(sid);
                        if(id==userID)
                            System.out.println("The staff can not delete yourself from the database.");
                        else
                            users = ((LibraryStaff) user).deleteUser(id);
                    } else
                        System.out.println("ID is not valid.");
                    if(users.isEmpty()){
                        System.out.println("User database is empty. Program terminated.");
                        System.exit(0);
                    }
                } else {
                    System.out.println("Enter current command.");
                }
            } else if( user instanceof LibraryUser){
                ArrayList <Book> myBooks;
                Scanner scanInput = new Scanner(System.in);
                command = user.promptMenu();
                if(command.equals("q"))
                    System.exit(0);
                else if(command.equals("bb")){
                    printBooks(books);
                    System.out.print("Enter book ID to barrow > ");
                    String sid = scanInput.nextLine();
                    if(sid.matches("\\d+")){
                        int id = Integer.parseInt(sid);
                        books = ((LibraryUser) user).borrowBook(id, userID);
                    } else
                        System.out.println("ID is not valid.");
                }
                else if(command.equals("rb")){
                    myBooks = AbstractUser.readBookFile(userID);
                    if(myBooks!=null){
                        if(listUserBooks(myBooks)){
                            System.out.print("Enter book ID to return > ");
                            String sid = scanInput.nextLine();
                            if(sid.matches("\\d+")){
                                int id = Integer.parseInt(sid);
                                books = ((LibraryUser) user).returnBook(id, userID);
                            } else
                                System.out.println("ID is not valid.");
                        }
                    }
                    else
                        System.out.println("You don't have any book to return");
                }
                else if(command.equals("lmb")){
                    myBooks = AbstractUser.readBookFile(userID);
                    if(myBooks!=null)
                        listUserBooks(myBooks);
                    else
                        System.out.println("You don't have any book to list.");
                }
                else if(command.equals("lab")){
                    listAvailableBooks(books);
                }
                else if(command.equals("lb")){
                    printBooks(books);
                }
                else {
                    System.out.println("Enter current command.");
                }
            } else if(user == null){
                break;
            }
        }
    }

    /**
     * veri tabanindaki kitaplari ekrana basan fonksiyon
     * @param books kitap listesi
     */
    public static boolean printBooks(ArrayList <Book> books){
        if(books!=null){
            System.out.println("----------ALL BOOKS------------\n");
            for(int i = 0; i<books.size(); ++i) {
                System.out.println(books.get(i).printBook());
                System.out.println("------------------------------\n");
            }
            return true;
        } else {
            System.out.println("There isn't any book on database.");
            return false;
        }
    }

    /**
     * veri tabanindaki kullanicilari ekrana basan fonksiyon
     */
    public static void printUsers(){
        System.out.println("-------------USERS------------");
        for(int i = 0; i<users.size(); ++i){
            System.out.println(users.get(i).printUser());
            System.out.println("------------------------------");
        }
    }

    /**
     * kullanici tarafindan girilen kullanici adi ve parolanin veri tabaninda
     * olup olmadigini kontrol eden fonksiyon
     * @param username kullanici adi
     * @param password sifre
     * @return kullanici adi ve sifre dogruysa user id, degilse -1
     */
    public static int checkUser(String username, String password){
        for(int i = 0; i < users.size(); ++i){
            if(users.get(i).getUserName().equals(username) && users.get(i).getPassword().equals(password) ){
                return users.get(i).getId();
            }
        }
        return -1;
    }
    public static int getUserIndex(String username, String password){
        for(int i = 0; i < users.size(); ++i){
            if(users.get(i).getUserName().equals(username) && users.get(i).getPassword().equals(password) ){
                return i;
            }
        }
        return -1;
    }
    public static boolean listUserBooks(ArrayList <Book> books){
        if(books!=null){
            System.out.println("-----------YOUR BOOKS------------");
            for(int i = 0; i<books.size(); ++i){
                System.out.println("Name: " + books.get(i).getName()+ "\nAuthor: " + books.get(i).getAuthor()+ "\nID: " + books.get(i).getId());
                System.out.println("------------------------------");
            }
            return true;
        } else {
            System.out.println("There isn't any book on database.");
            return false;
        }
    }

    public static boolean listAvailableBooks(ArrayList <Book> books){
        if(books != null){
            System.out.println("---------AVAILABLE BOOKS---------");
            for(int i = 0; i<books.size(); ++i){
                if(books.get(i).getAvailability()){
                    System.out.println("Name: " + books.get(i).getName()+ "\nAuthor: " + books.get(i).getAuthor() + "\nID: " + books.get(i).getId());
                    System.out.println("------------------------------");
                }
            }
            return true;
        } else {
            System.out.println("There isn't any book on database.");
            return false;
        }
    }
    private static boolean checkUser(String username){
        for(int i=0 ; i< users.size(); ++i){
            if(users.get(i).getUserName().equals(username)){
                return false;
            }
        }
        return true;
    }
}
