import java.util.*;

/**
 * Single Linked List implementation
 * Created by yacikgoz on 10.03.2017.
 */
public class SingleLinkedList <E> extends AbstractList<E>{
    private Node<E> head = null;
    private int size;

    private static class Node<E>{
        E data;
        Node<E> next;
        private Node(E item){
            data = item;
            next = null;
        }
        private Node(E item, Node<E> nodeRef){
            data = item;
            next = nodeRef;
        }
    }

    private class SingleLinkedListIterator implements Iterator<E> {
        private Node<E> nextNode;

        public SingleLinkedListIterator() {
            nextNode = head;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E res = nextNode.data;
            nextNode = nextNode.next;
            return res;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    private void addAfter(Node<E> node, E item){
        node.next = new Node<E>(item, node.next);
        ++size;
    }
    public void addFirst(E item){
        head = new Node<E>(item, head);
        ++size;
    }

    private Node<E> getNode(int index){
        Node<E> node = head;
        for(int i=0; i<index && node!=null; ++i){
            node = node.next;
        }
        return node;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    @Override
    public E set(int index, E element) {
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = getNode(index);
        E data = node.data;
        node.data = element;
        return data;
    }

    @Override
    public void add(int index, E element) {
        if(index<0 && index>=size){
            throw new IndexOutOfBoundsException();
        } else if(index == 0){
            addFirst(element);
        } else{
            Node<E> node = getNode(index);
            addAfter(node, element);
        }
    }
    @Override
    public boolean add(E e) {
        add(size, e);
        return true;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new SingleLinkedListIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] r = new Object[size()];
        Iterator<E> it = iterator();
        for (int i = 0; i < r.length; i++) {
            if (! it.hasNext()) // fewer elements than expected
                return Arrays.copyOf(r, i);
            r[i] = it.next();
        }
        return r;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
