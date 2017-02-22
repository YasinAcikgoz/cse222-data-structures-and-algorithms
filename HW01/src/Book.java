/**
 *
 * Created by yacikgoz on 22.02.2017.
 */
public class Book implements IBook {
    private String name;
    private String author;
    private String ISBN; // International Standard Book Number

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Book(String name, String author, String isbn){
        this.name = name;
        this.author = author;
        this.ISBN = isbn;

    }

    @Override
    public void addBook(Book book) {

    }

    @Override
    public void removeBook(Book book) {

    }

    @Override
    public void updateBook(Book book) {

    }

    @Override
    public void barrowBook(Book book) {

    }

    @Override
    public void returnBook(Book book) {

    }

    @Override
    public String toString() {
        return "name: " + getName() + " author: " + getAuthor() + " ISBN: " + getISBN();

    }
}
