package Part2;

/**
 * Person class
 * Created by yacikgoz on 8.04.2017.
 */
public class Person implements Comparable<Person> {

    private String name;
    private String parentName;
    private String nickName;

    /**
     * 3 parameter constructor
     * @param name name
     * @param parentName parent name
     * @param nickName nick name
     */
    public Person(String name, String parentName, String nickName) {
        this.name = name;
        this.nickName = nickName;
        this.parentName = parentName;
    }

    /**
     * get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * get nick name
     * @return nickname
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * get parent name
     * @return parent name
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * check parent
     * @param person object
     * @return true if name and person object's parent name, false otherwise
     */
    public boolean checkParent(Person person){
        return getName().equals(person.getParentName());
    }

    /**
     * toString metod
     * @return tostring
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("name: "+ getName() + " ");
        sb.append("nickName: "+ getNickName()+ " ");
        sb.append("parentName: "+ getParentName());
        return sb.toString();
    }

    /**
     * compareTo
     * @param o person object
     * @return 0
     */
    @Override
    public int compareTo(Person o) {
        return 0;
    }

    /**
     * equals metod
     * @param obj object reference
     * @return true if objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        Person o = (Person)obj;
        if(o==null)
            return false;
        else
        return o.getName().equals(getName())
                && o.getNickName().equals(getNickName())
                && o.getParentName().equals(getParentName());
    }
}
