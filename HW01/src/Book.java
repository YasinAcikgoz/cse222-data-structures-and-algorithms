/**
 * Kitap bilgilerinin ve methodlarinin bulundugu sinif
 * Created by yacikgoz on 22.02.2017.
 */

public class Book{
    private String name;
    private String author;
    private int id;
    private boolean availability;

    /**
     * get name class member
     * @return kitap adi
     */
    public String getName() {
        return name;
    }

    /**
     * set name class member
     * @param name kitap adi
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get author class member
     * @return yazar adi
     */
    public String getAuthor() {
        return author;
    }

    /**
     * set author class member
     * @param author yazar adi
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * get id class member
     * @return kitap id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id kitap id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get availability class member
     * @return availability
     */
    public boolean getAvailability() {
        return availability;
    }

    /**
     * set availability class member
     * @param availability kullanilabilirlik
     */
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    /**
     * book constructor
     * @param name kitap ismi
     * @param author yazar ismi
     * @param status kitabin kullanilabilirligi
     */
    public Book(String name, String author, boolean status){
        setName(name);
        setAuthor(author);
        setAvailability(status);
    }

    /**
     * toString metodu
     * @return obje bilgisi
     */
    @Override
    public String toString() {
        return getName() + ";" + getAuthor() + ";" + getId() + ";" + getAvailability();
    }

    /**
     * kitap bilgilerini ekrana basan metod
     * @return kitap objesi stringi
     */
    public String printBook(){
        String temp =  "ID: " + getId() + " Name: " + getName() + " Author: " + getAuthor();
        if(getAvailability()){
            temp += " -> Available";
        } else
            temp += " -> Not Available";
        return temp;
    }
}
