import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * Created by yacikgoz on 24.02.2017.
 */
public interface IUser {
    ArrayList <User> addUser(User user) throws IOException;
    ArrayList <User> deleteUser(User user) throws IOException;
}
