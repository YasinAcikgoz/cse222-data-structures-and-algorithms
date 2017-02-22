/**
 *
 *
 * Created by yacikgoz on 22.02.2017.
 */
public interface IBook {
    void addBook(Book book);
    void removeBook(Book book);
    void updateBook(Book book);
    void barrowBook(Book book);
    void returnBook(Book book);

}
