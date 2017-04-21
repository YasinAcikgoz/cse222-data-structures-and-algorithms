package Part3;
import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/** Class for a binary tree that stores type E objects.
*   @author Koffman and Wolfgang
* */

public class BinaryTree< E extends Comparable<E>>{
    private boolean addReturn;

    /**
     * Binary Tree preorder iterator
     * @return preorder iterator
     */
    public Iterator<E> iterator() {
        return new PreOrderIterator<>();
    }

    /**
     * PreOrderIterator class
     * @param <E> generic
     */
    private class PreOrderIterator<E> implements Iterator<E> {

        /**
         * preorder iterator nodes
         */
        private Queue<Node<E>> nodes = new LinkedList<>();

        /**
         * no parameter constructor
         */
        public PreOrderIterator() {
            preOrderTraverse(root);
        }

        /**
         * hasNext
         * @return eleman varsa true, yoksa false
         */
        @Override
        public boolean hasNext(){return !nodes.isEmpty(); }

        /**
         * next
         * @return next element
         */
        @Override
        public E next() {
            Node<E> node = nodes.poll();
            return  node.data;
        }

        /**
         * preorder traverse metodu
         * tree elemanlarini recursive olarak preorder sekilde queue'ya ekler
         * @param rootNode root
         */
        private void preOrderTraverse(Node rootNode){
            if(rootNode!=null){
                nodes.offer(rootNode);
                preOrderTraverse(rootNode.left);
                preOrderTraverse(rootNode.right);
            }
        }
    }

    /**
     * Class to encapsulate a tree node.
     */
    protected class Node<E>
            implements Serializable {
        // Data Fields
        /**
         * The information stored in this node.
         */
        protected E data;


        /**

         * Reference to the left child.
         */
        protected Node<E> left;

        /**
         * Reference to the right child.
         */
        protected Node<E> right;

        // Constructors

        /**
         * Construct a node with given data and no children.
         *
         * @param data The data to store in this node
         */
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        // Methods

        /**
         * getleft
         * @return left node of Node
         */
        public Node<E> getLeft() {
            return left;
        }

        /**
         * getright
         * @return right node of Node
         */
        public Node<E> getRight() {
            return right;
        }

        /**
         * setleft
         * @param left set parameter
         */
        public void setLeft(Node<E> left) {
            this.left = left;
        }
        /**
         * setright
         * @param right set parameter
         */
        public void setRight(Node<E> right) {
            this.right = right;
        }

        /**
         * Return a string representation of the node.
         *
         * @return A string representation of the data fields
         */
        public String toString() {
            return data.toString();
        }

        public E getData(){ return this.data; }
    }

    /**
     * BinaryTree public add metod
     * @param item eklenecek eleman
     * @return boolean
     */
    public boolean add(E item) {
        root = add(root, item);
        return addReturn;
    }

    // Data Field
    /**
     * The root of the binary tree
     */
    public Node<E> root;

    /**
     * no param constructor
     */
    public BinaryTree(){
        root = null;
    }

    /**
     * Binary tree'ye eleman recursive olarak ekleyen metod
     * @param localRoot local root
     * @param item eklenecek eleman
     * @return eleman eklendiyse true, ayni eleman varsa false
     */
    private Node<E> add(Node<E> localRoot, E item) {
        if (localRoot == null) {
            addReturn = true;
            return new Node<E>(item);
        } else if (item.compareTo(localRoot.data) == 0) {
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } else {
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }
}