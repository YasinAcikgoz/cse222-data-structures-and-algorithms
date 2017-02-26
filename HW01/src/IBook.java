import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * book interface
 *
 */
public interface IBook {
    /**
     * veri tabanina kitap ekleyen method
     * @param book veri tabanina eklenecek kitap objesi
     * @return kitap listesi
     * @throws IOException exception
     */
    ArrayList <Book> addBook(Book book) throws IOException;
    /**
     * veri tabanindan kitap silen method
     * @param id veri tabanindan silinecek kitap objesi
     * @return kitap listesi
     * @throws IOException exception
     */
    ArrayList <Book> deleteBook(int id) throws IOException;

    /**
     * libraryUser'in kitap almasini saglayan method.
     * @param bookID alinacak kitap id'si
     * @param userID user'in id'si
     * @return kitap listesi
     * @throws IOException exception
     */
    ArrayList <Book> borrowBook(int bookID, int userID) throws IOException;

    /**
     * libraryUser'in aldigi kitabi geri vermesini saglayan method
     * @param bookID geri verilecek kitap id'si
     * @param userID user'in id'si
     * @return kitap listesi
     * @throws IOException exception
     */
    ArrayList <Book>  returnBook(int bookID, int userID) throws IOException;

}
