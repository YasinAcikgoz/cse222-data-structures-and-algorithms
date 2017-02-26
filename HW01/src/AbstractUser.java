import java.io.*;
import java.util.ArrayList;

/**
 *
 * kullaniciya ait metodlarin bulundugu abstract user sinifi
 *
 */
public abstract class AbstractUser {
    protected String name;
    protected String userName;
    protected String password;
    protected int id;
    /**
     * Kullaniciya yapabilecegi islemleri gösteren ve komut alan metod
     * @return seçilen komut
     */
    abstract protected String promptMenu();

    /**
     * get user name
     * @return kullanici adi
     */
    abstract protected String getUserName();

    /**
     * set user name
     * @param userName kullanici adi
     */
    abstract protected void setUserName(String userName);

    /**
     * get password
     * @return kullanici parolasi
     */
    abstract protected String getPassword();

    /**
     * set password
     * @param password kullanici parolasi
     */
    abstract protected void setPassword(String password);

    /**
     * get name
     * @return kullanici ismi
     */
    abstract protected String getName();

    /**
     * set name
     * @param name kullanici ismi
     */
    abstract protected void setName(String name);

    /**
     * get id
     * @return kullanici id'si
     */
    abstract protected int getId();

    /**
     * set id
     * @param id kullanici id'si
     */
    abstract protected void setId(int id);

    /**
     * kitap bilgilerini veri tabanina yazan metod
     * @param list kitap listesi
     * @throws IOException exception
     */
    protected void writeBooks(ArrayList <Book> list) throws IOException {
        try {
            String booksFile = "src/data/Books.csv";
            PrintWriter writer = new PrintWriter(new FileWriter(booksFile));
            for(int i=0; i<list.size(); ++i){
                list.get(i).setId(list.get(i).getId());
                writer.println(list.get(i).toString());
            }
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * user bilgilerini veri tabanina yazan metod
     * @param list user listesi
     * @throws IOException exception
     */
    protected void writeUsers(ArrayList <User> list, boolean status) throws IOException {
        try {
            String usersFile = "src/data/Users.csv";
            PrintWriter writer = new PrintWriter(new FileWriter(usersFile));
            for(int i=0; i<list.size(); ++i)
                writer.println(list.get(i).toString());

            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * users.csv dosyasini okuyan metod
     * @return user listesi
     */
    protected static ArrayList readUserFile() {
        String usersFile = "src/data/Users.csv";
        ArrayList <User> list = new ArrayList<>();
        try {
            File file = new File(usersFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String [] temp = line.split(";");
                User tempUser = new User(temp[0], temp[1], temp[2], temp[3], Integer.parseInt(temp[4]));
                list.add(tempUser);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * books.csv dosyasini okuyan metod
     * @param userID user id
     * @return kitap listesi
     */
    protected static ArrayList readBookFile(int userID) {
        String fileName;
        if(userID == -1)
            fileName = "src/data/Books.csv";
        else
            fileName = "src/data/" + userID + "_books.csv";
        ArrayList <Book> list = new ArrayList<>();

        File f = new File(fileName);
        if(f.exists() && !f.isDirectory()) {
            try {
                File file = new File(fileName);
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                int id = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    String [] temp = line.split(";");
                    Book tempBook = new Book(temp[0], temp[1], Boolean.parseBoolean(temp[3]));
                    tempBook.setId(Integer.parseInt(temp[2]));

                    list.add(tempBook);
                }
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            return null;
        }
        return list;
    }

    /**
     * id'si verilen kitapin veri tabaninda olup olmadigini kontrol eden fonksiyon
     * @param id kitap id'si
     * @param list kitap listesi
     * @return id'si verilen kitapin veri tabaninda varsa kitap objesi, yoksa null
     */
    protected Book checkBookId(int id, ArrayList<Book> list){
        for(int i=0; i<list.size(); ++i){
            if(list.get(i).getId()==id){
                return list.get(i);
            }
        }
        return null;
    }

}
