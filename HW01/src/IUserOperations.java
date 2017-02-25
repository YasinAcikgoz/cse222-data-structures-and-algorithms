import java.io.IOException;
import java.util.ArrayList;

/**
 * user operations interface
 * Created by yacikgoz on 24.02.2017.
 */
public interface IUserOperations {
    /**
     * user veri tabanina kullanici ekleyen method.
     * @param user eklenecek user
     * @return user list
     * @throws IOException exception
     */
    ArrayList <User> addUser(User user) throws IOException;
    /**
     * user veri tabanindan kullanici silen method.
     * @param id silinecek user id'si
     * @return user list
     * @throws IOException exception
     */
    ArrayList <User> deleteUser(int id) throws IOException;
}
