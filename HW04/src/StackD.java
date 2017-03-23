import java.util.*;

/**
 * StackD.java
 * Created by yacikgoz on 22.03.2017.
 */
public class StackD<E> implements StackInterface<E> {
    private Queue<E> stackQueue;

    /**
     * constructor
     */
    public StackD(){
        stackQueue = new LinkedList<>();
    }

    /**
     * adds element top of the stack
     * @param obj element
     * @return element
     */
    @Override
    public E push(E obj) {
        stackQueue.add(obj);
        return obj;
    }

    /**
     * deletes the element top of the stack
     * @return deleted element
     */
    @Override
    public E pop() {
        if(stackQueue.isEmpty())
            throw new EmptyStackException();
        for(int i=0; i<size()-1; ++i)
            stackQueue.add(stackQueue.poll());

        return stackQueue.poll();
    }

    /**
     * isEmpty metod
     * @return true if stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return stackQueue.isEmpty();
    }

    /**
     * size metod
     * @return size of the stack
     */
    @Override
    public int size() {
        return stackQueue.size();
    }

    /**
     * toString metod
     * @return string
     */
    @Override
    public String toString() {
        return stackQueue.toString();
    }
}
