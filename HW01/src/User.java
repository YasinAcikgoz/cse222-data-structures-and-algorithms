/**
 *
 * Created by yacikgoz on 20.02.2017.
 */
public class User {

    private String name;
    private String userName;
    private String password;

    public User(String name, String userName, String password){

        if(name !=null || userName!=null || password !=null){
            setName(name);
            setPassword(password);
            setUserName(userName);
        }
    }
    public User(){

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

    @Override
    public String toString() {
        return getName() + ";" + getUserName() + ";" + getPassword();
    }
}
