import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/****************************************
 *                                      *
 *                                      *
 * Created by yacikgoz on 22.02.2017.   *
 *                                      *
 *                                      *
 ***************************************/
public class Library {
    private static ArrayList <User> users;
    private static ArrayList <Book> books;
    private static int userID;

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
              /*  System.out.println("-------LOGIN SCREEN------");
                System.out.print("Enter your username > ");
                username = scanInput.nextLine();
                System.out.print("Enter your password > ");
                password = scanInput.nextLine();*/
               // username = "admin";
               // password = "123456";
                username = "yacikgoz";
                password = "1111";
               // System.out.println("username: " + username + " password: " + password);
                userID = checkUser(username, password);
                if(userID >=0){
                    System.out.println(users.get(userID).printUser());
                    if(users.get(userID).getType().equals("staff")){
                        user = new LibraryStaff(users.get(userID).getName(), users.get(userID).getUserName(), users.get(userID).getPassword());
                    } else if (users.get(userID).getType().equals("user")){
                        user = new LibraryUser(users.get(userID).getName(), users.get(userID).getUserName(), users.get(userID).getPassword());
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
            //    System.out.println("command = " + command);
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
                    System.out.println("add book");

                } else if(command.equals("db")){
                    System.out.println("delete book");
                    System.out.print("Enter Book ID > ");
                    String sid = scanInput.nextLine();
                    int id = Integer.parseInt(sid);
                    books = ((LibraryStaff) user).deleteBook(id);
                } else if(command.equals("au")){
                    String name, username, password, type;
                    while(true){
                        System.out.print("Enter Name > ");
                        name = scanInput.nextLine();
                        if(name.length()>=4)
                            break;
                        else
                            System.out.println("The name must be at least 2 digits.");
                    }
                    while(true){
                        System.out.print("Enter Username > ");
                        username = scanInput.nextLine();
                        if(name.length()>=4)
                            break;
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
                    int id = Integer.parseInt(sid);
                    users = ((LibraryStaff) user).deleteUser(id);
                    if(users.isEmpty()){
                        System.out.println("User database is empty. Program terminated.");
                        System.exit(0);
                    }

                } else {
                    System.out.println("Enter current command.");
                }
            } else if( user instanceof LibraryUser){
                ArrayList <Book> myBooks = new ArrayList<>();
                myBooks = AbstractUser.readBookFile(user.getId());
                Scanner scanInput = new Scanner(System.in);
                command = user.promptMenu();
                if(command.equals("q"))
                    System.exit(0);
                else if(command.equals("bb")){
                    printBooks(books);
                    System.out.print("Enter book ID to barrow > ");
                    String sid = scanInput.nextLine();
                    int id = Integer.parseInt(sid);
                    ((LibraryUser) user).barrowBook(id, userID);
                   /* if(myBooks!=null)
                        printBooks(myBooks);*/
                }
                else if(command.equals("rb")){
                    System.out.print("Enter book ID to return > ");
                    String sid = scanInput.nextLine();
                    int id = Integer.parseInt(sid);
                    ((LibraryUser) user).returnBook(id, userID);
                }
                else if(command.equals("lmb")){
                    myBooks = AbstractUser.readBookFile(userID);
                    if(myBooks!=null)
                    System.out.println(myBooks.toString());
                    /*if(myBooks!=null)
                        printBooks(myBooks);
                */}
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
    public static void printBooks(ArrayList <Book> books){
        if(!books.isEmpty()){
            System.out.println("------------------------------\n");
            for(int i = 0; i<books.size(); ++i)
                System.out.println(books.get(i).printBook());
            System.out.println("------------------------------\n");
        } else {
            System.out.println("There isn't any book on database.");
        }
    }
    public static void printUsers(){
        System.out.println("------------------------------\n");
        for(int i = 0; i<users.size(); ++i)
            System.out.println(users.get(i).printUser());
        System.out.println("------------------------------\n");
    }
    public static int checkUser(String username, String password){
        for(int i = 0; i < users.size(); ++i){
            if(users.get(i).getUserName().equals(username) && users.get(i).getPassword().equals(password) ){
                return i;
            }
        }
        return -1;
    }
}
