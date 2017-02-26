import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * AbstractUser sinifindan extend olan User sinifi
 *
 */
public class User extends AbstractUser{
    private String type;
    protected ArrayList<Book> bookList;
    protected ArrayList<User> userList;

    /**
     * get user name
     * @return kullanici adi
     */
    protected String getUserName() { return userName; }
    /**
     * set user name
     * @param userName kullanici adi
     */
    protected void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * get password
     * @return kullanici parolasi
     */
    protected String getPassword() {
        return password;
    }
    /**
     * set password
     * @param password kullanici parolasi
     */
    protected void setPassword(String password) {
        this.password = password;
    }
    /**
     * get name
     * @return kullanici ismi
     */
    protected String getName() {
        return name;
    }
    /**
     * set name
     * @param name kullanici ismi
     */
    protected void setName(String name) {
        this.name = name;
    }
    /**
     * get id
     * @return kullanici id'si
     */
    protected int getId() {
        return id;
    }
    /**
     * set id
     * @param id kullanici id'si
     */
    protected void setId(int id) {
        this.id = id;
    }
    /**
     * get type
     * @return kullanici tipi
     */
    protected String getType() {
        return type;
    }

    /**
     * set type
     * @param type kullanici tipi
     */
    public void setType(String type) {
        this.type = type;
    }
    protected User(String name, String userName, String password, String type, int id){
        if(name !=null || userName!=null || password !=null || id>=0){
            setName(name);
            setPassword(password);
            setUserName(userName);
            setType(type);
            setId(id);
        }
    }
    protected User(String name, String userName, String password){
        if(name !=null || userName!=null || password !=null){
            setName(name);
            setPassword(password);
            setUserName(userName);
        }
    }
    protected User(){
        setName("unknown");
        setPassword("unknown");
        setUserName("unknown");
        setId(-1);
    }

    /**
     * Kullaniciya yapabilecegi islemleri gösteren ve komut alan metod
     * @return seçilen komut
     */
    @Override
    protected String promptMenu() {
        return " lb -> list books\n" +  "  q -> quit\n";
    }

    /**
     * toString metodu
     * @return kullanici bilgisi
     */
    @Override
    public String toString() {
        return getName() + ";" + getUserName() + ";" + getPassword() + ";" + getType() + ";" + getId();
    }

    /**
     * kullanici bilgilerini ekrana basan fonksiyon
     * @return kullanici bilgisi
     */
    public String printUser(){ return "Name: " + getName() +  "\tID: " + getId() + "\tUsername: " + getUserName() + "\tPassword: " + getPassword() + "\tUserType: " + getType(); }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.toString(), obj.toString());
    }
}
