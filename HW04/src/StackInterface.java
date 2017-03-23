/**
 * StackInterface.java
 * Created by yacikgoz on 21.03.2017.
 */
public interface StackInterface<E> {

    E push(E obj);
    E pop();
    boolean isEmpty();
    int size();
}
