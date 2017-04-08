package Part1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class for a binary search tree that stores type E objects.
 * Created by yacikgoz on 6.04.2017.
 */
public class BinarySearchTree <E extends Comparable <E>> extends BinaryTree<E> {
    /**
     * Binary Tree preorder iterator
     * @return preorder iterator
     */
    @Override
    public Iterator<E> iterator(){
        return new LevelOrderIterator<>();
    }

    /**
     * level order iterator class
     * @param <E> generic
     */
    private class LevelOrderIterator<E> implements Iterator<E>{
        private Queue<Node<E>> nodes = new LinkedList<>();
        private Queue<Node<E>> tempQueue = new LinkedList<>();

        /**
         * no parameter constructor
         */
        public LevelOrderIterator(){
            levelOrderTraverse(root);
        }

        /**
         * level order traverse metodu
         * binary search tree elemenlarını level order olarak queue'ya ekler
         * @param root root node
         */
        void levelOrderTraverse (Node root){
            tempQueue.offer(root);
            while (!tempQueue.isEmpty()){
                Node tempNode = tempQueue.poll();
                if (tempNode.left != null)
                    tempQueue.offer(tempNode.left);
                if (tempNode.right != null)
                    tempQueue.offer(tempNode.right);
                nodes.offer(tempNode);
            }
        }

        /**
         * hasNext
         * @return eleman varsa true, yoksa false
         */
        @Override
        public boolean hasNext() {
            return !nodes.isEmpty();
        }
        /**
         * next
         * @return next element
         */
        @Override
        public E next() {
            Node<E> node = nodes.poll();
            return  node.data;
        }
    }
}
