import java.util.*;

/**
 * Single Linked List implementation
 * Created by yacikgoz on 10.03.2017.
 */
public class SingleLinkedList <E> extends LinkedList{
    private Node<E> head = null;
    private int size;

    /**
     * Node Class
     * @param <E> generic object
     */
    private static class Node<E>{
        E data;
        Node<E> next;
        /**
         * Node constructor
         * @param item node.data
         */
        private Node(E item){
            data = item;
            next = null;
        }

        /**
         * toString metod
         * @return string
         */
        @Override
        public String toString() {
            return data.toString();
        }

    }

    /**
     * SingleLinkedList iterator return eden metod
     * @return iterator
     */
    public Iterator<E> Iterator() {
        SingleLinkedListIterator singleLinkedListIterator = new SingleLinkedListIterator();
        return singleLinkedListIterator;

    }
    /**
     * Head node'u verilen char LinkedList'ini reverse eden metod
     * @param node head node
     * @return node
     */
    public static Node reverseToString(Node node){
        if (node == null || node.next == null)
            return node;

        Node left = reverseToString(node.next);
        /*
        * recursion'dan donerken node ilerideki
        * node ile gerideki node arasindaki
        * baglantiyi ters cevirir
        * */

        node.next.next = node;
        /*
        * gerideki node ile onundeki node
        * arasindaki baglantiyi yok eder
        * */
        node.next = null;
        return left;
    }

    /**
     * SingleLinkedListIterator class
     * implements Iterator
     */
    private class SingleLinkedListIterator implements Iterator<E>{
        private Node<E> nextNode;

        /**
         * constructor
         */
        public SingleLinkedListIterator() {
            nextNode = head;
        }

        /**
         * check has next item is exists
         * @return true if exists, false otherwise
         */
        public boolean hasNext() {
            return nextNode != null;
        }

        /**
         * get SingleLinkedList's next item
         * @return next node's data
         */
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E res = nextNode.data;
            nextNode = nextNode.next;
            return res;
        }

        /**
         * ReuseDeletedNodes class'i icin kullanilan remove metodu
         */
        @Override
        public void remove() {
            nextNode.data = null;
            nextNode = nextNode.next;
        }
    }

    /**
     * get node from index
     * @param index node index
     * @return node
     */
    private Node<E> getNode(int index){
        Node<E> node = head;
        for(int i=0; i<index && node!=null; ++i){
            node = node.next;
        }
        return node;
    }

    /**
     * get linkedlist size
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * get linked list element
     * @param index element index
     * @return generic type
     */
    public E get(int index) {
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    /**
     * add element to linked list
     * @param index index value to element add
     * @param element eklenecek element
     */
    public void add(int index, E element) {
        Node temp = new Node(element);
        Node curr = head;
        if (index == 0){
            temp.next=head;
            this.head = temp;
        } else{
            for(int i = 1; i < index; i++){
                curr = curr.next;
            }
            temp.next = curr.next;
            curr.next = temp;
        }
        this.size++;
    }

    /**
     * linked listin sonuna eleman ekleyen metod.
     * @param e eleman
     * @return true
     */
 /*   public boolean add(E e) {
        add(size, e);
        return true;
    }*/

    /**
     * reverse toString wrapper metod
     */
    public void reverseToString(){
        SingleLinkedList<Object> list = new SingleLinkedList<>();
        Node node;
        list.head = new Node<>('y');
        list.head.next = new Node<>('a');
        list.head.next.next = new Node<>('s');
        list.head.next.next.next = new Node<>('i');
        list.head.next.next.next.next = new Node<>('n');
        list.head.next.next.next.next.next = new Node<>('a');
        list.head.next.next.next.next.next.next = new Node<>('c');
        list.head.next.next.next.next.next.next.next  = new Node<>('i');
        list.head.next.next.next.next.next.next.next.next  = new Node<>('k');
        list.head.next.next.next.next.next.next.next.next.next  = new Node<>('g');
        list.head.next.next.next.next.next.next.next.next.next.next  = new Node<>('o');
        list.head.next.next.next.next.next.next.next.next.next.next.next = new Node<>('z');
        System.out.println("\nCharacter SingleLinkedList before reverseToString() call");
        print(list.head);
        System.out.println("\n");
        node = reverseToString(list.head);
        System.out.println("Character SingleLinkedList after reverseToString() call");
        print(node);

        SingleLinkedList<Object> list2 = new SingleLinkedList<>();
        list2.head = new Node<>("yasin");
        list2.head.next = new Node<>("acikgoz");

        System.out.println("\n\nString SingleLinkedList before reverseToString() call");
        print(list2.head);
        System.out.println("\n");
        node = reverseToString(list2.head);
        System.out.println("String SingleLinkedList after reverseToString() call");
        print(node);
        SingleLinkedList<Object> list3 = new SingleLinkedList<>();
        list3.head = new Node<>(1);
        list3.head.next = new Node<>(9);
        list3.head.next.next = new Node<>(0);
        list3.head.next.next.next = new Node<>(5);
        System.out.println("\n\nInteger SingleLinkedList before reverseToString() call");
        print(list3.head);
        System.out.println("\n");
        node = reverseToString(list3.head);
        System.out.println("Integer SingleLinkedList after reverseToString() call");
        print(node);
        System.out.println("\n");
    }

    /**
     * print nodes
     * @param node head node
     */
    public void print(Node<Object> node) {
        if(node!= null) {
            System.out.print(node.toString());
            print(node.next);
        }
    }

    /**
     * toString override
     * @return string
     */
 /*   @Override
    public String toString() {
        String temp = "[";
        Iterator <E> eIterator = new SingleLinkedListIterator();
        while (eIterator.hasNext()){
            Object object = eIterator.next();
            if(object!=null)
                temp += object.toString() + ", ";
        }
        return temp + "]";
    }*/
}
