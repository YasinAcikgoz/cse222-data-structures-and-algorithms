import java.util.EmptyStackException;

/**
 * StackC.java
 * Created by yacikgoz on 22.03.2017.
 */
public class StackC<E> implements StackInterface<E> {

    private Node< E > head;

    /** A reference to the end of the list. */
    private Node< E > tail;

    /** The size of the list. */
    private int size;

    public StackC(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * inner node class
     * @param <E> generic type
     */
    private static class Node < E > {
        /** The data value. */
        private E data;

        /** The link to the next node. */
        private Node< E > next = null;

        /** The link to the previous node. */
        private Node< E > prev = null;

        /** Construct a node with the given data value.
         @param dataItem The data value
         */
        private Node(E dataItem) {
            data = dataItem;
        }
        /**
         * toString metod
         * @return string
         */
        @Override
        public String toString() {
            String s = "";
            if(data!=null)
                s = "" + data.toString();
            return s;
        }
    }
    /**
     * adds element top of the stack
     * @param obj element
     * @return element
     */
    @Override
    public E push(E obj) {
        if (head == null) { // Add to an isEmpty list.
            head = new Node<>(obj);
            tail = head;
            head.data = obj;
            ++size;
            return head.data;
        } else {
            Node< E > newNode = new Node<>(obj);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            ++size;
            return newNode.data;
        }
    }
    /**
     * deletes the element top of the stack
     * @return deleted element
     */
    @Override
    public E pop() {
        if(size()>0){
            E obj = tail.data;
            tail=tail.prev;
            --size;
            return obj;
        } else
            throw new EmptyStackException();
    }
    /**
     * isEmpty metod
     * @return true if stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * size metod
     * @return size of the stack
     */
    @Override
    public int size() {
        return size;
    }
    /**
     * toString metod
     * @return string
     */
    @Override
    public String toString() {
        Node <E> current = head;
        String s = "[";
        for(int i = 0; i<size(); ++i){
            s += current.toString();
            if(i<size()-1)
                s += ", ";
            current = current.next;
        }
        return s + "]";
    }
}
