import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * StackA.java
 * Created by yacikgoz on 21.03.2017.
 */
public class StackA<E> extends ArrayList<E> implements StackInterface<E> {
    /**
     * constructor
     */
    public StackA(){
        super();
    }
    /**
     * adds element top of the stack
     * @param obj element
     * @return element
     */
    @Override
    public E push(E obj) {
        super.add(obj);
        return obj;
    }

    /**
     * deletes the element top of the stack
     * @return deleted element
     */
    @Override
    public E pop() {
        if(isEmpty())
            throw new EmptyStackException();
        else{
            return super.remove(size()-1);
        }
    }
    /**
     * isEmpty metod
     * @return true if stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }
    /**
     * toString metod
     * @return string
     */
    @Override
    public String toString() {
        return super.toString();
    }
      /**
     * size metod
     * @return size of the stack
     */
    @Override
    public int size() {
        return super.size();
    }
}
