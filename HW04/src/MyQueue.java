import javax.xml.soap.Node;
import java.util.*;

/** KWLinkedList.java
 * Created by yacikgoz on 22.03.2017.
 */
public class MyQueue<E> extends KWLinkedList<E>{
    int size = 0;

    /**
     * add element to queue
     * @param e the element to add
     * @return true
     */
    public boolean offer(E e) {
        addFirst(e);
        ++size;
        return true;
    }

    /**remove metod
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public E remove() {
        if(size==0)
            throw new NoSuchElementException();
        else{
            E obj = getLast();
            tail = tail.prev;
            --size;
            return obj;
        }
    }

    /**
     * isEmpty metod
     * @return true if stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return (size==0);
    }

    /**
     * get size
     * @return size
     */
    public int size(){
        return size;
    }

    /**
     * poll metod
     * return element
     */
    public E poll() {
        if(size==0)
            return null;
        else {
            return remove();
        }
    }

    /**
     * element metod
     * @return element
     */
    public E element() {
        if(size==0)
            throw new NoSuchElementException();
        else
            return getFirst();

    }

    /**
     * peek metod
     * @return first element
     */
    public E peek() {
        if(size==0)
            return null;
        else
            return getFirst();
    }

    /**
     * reverse the queue
     */
    public void reverse(){
        ListIterator listIter = this.listIterator(size);
        ListIterator listIter2 = this.listIterator(0);
        int i=0;
        while (i<(size/2)){
            Object a = listIter.previous();
            Object b = listIter2.next();
            listIter2.set(a);
            listIter.set(b);
            ++i;
        }
    }

    /**
     * tostring
     * @return string
     */
    @Override
    public String toString() {
        Node<E> current = head;
        String s = "[";
        for(int i = 0; i<size; ++i){
            if(current!=null) {
                s += current.toString();
                if (i < size - 1)
                    s += ", ";
                current = current.next;
            }
        }
        return s + "]";
    }
}
