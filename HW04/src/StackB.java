import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * StackB.java
 * Created by yacikgoz on 22.03.2017.
 */
public class StackB<E> implements StackInterface<E> {

    private ArrayList<E> stackList;
    /**
     * constructor
     */
    public StackB(){ stackList = new ArrayList<>(); }
    /**
     * adds element top of the stack
     * @param obj element
     * @return element
     */
    @Override
    public E push(E obj) {
        stackList.add(obj);
        return obj;
    }
    /**
     * deletes the element top of the stack
     * @return deleted element
     */
    @Override
    public E pop() {
        if(stackList.isEmpty())
            throw new EmptyStackException();
        else
            return stackList.remove(stackList.size()-1);
    }
    /**
     * isEmpty metod
     * @return true if stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return stackList.isEmpty();
    }
    /**
     * size metod
     * @return size of the stack
     */
    @Override
    public int size() {
        return stackList.size();
    }
    /**
     * toString metod
     * @return string
     */
    @Override
    public String toString() {
        return stackList.toString();
    }
}
