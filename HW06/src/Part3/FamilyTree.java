package Part3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * FamilyTree class
 * Created by yacikgoz on 8.04.2017.
 */
public class FamilyTree extends BinaryTree<Person> {

    /**
     * add metod
     * @param name name
     * @param parentName parent name
     * @param nickName nick name
     * @return true if add operation is successful
     */
    public boolean add(String name, String parentName, String nickName){
        // person objesi oluştur

        Person newPerson = new Person(name, parentName, nickName);
        //personin olup olmadigini check et
        if(checkPerson(newPerson, root))
            return addToTree(root, newPerson);
        else
            return false;
    }

    /**
     * recursive addToTree metod
     * @param personNode person node
     * @param person person object
     * @return true if add operation is successful
     */
    private boolean addToTree(Node<Person> personNode, Person person) {
        if(personNode == null)
            return false;
        if(personNode.getData().checkParent(person)){
            Node<Person> node = personNode.getLeft();
                if (node != null) {
                    //saga dogru kardesler uzerinde git
                    while (node.getRight() != null)
                        node = node.getRight();
                    // en saga ekle
                    node.setRight(new Node<>(person));
                } else //cocugu ekle
                    personNode.setLeft(new Node<>(person));
                return true;
        }
        // recursive cagri
        return addToTree(personNode.getLeft(), person)|| addToTree(personNode.getRight(), person);
    }

    /**
     * family tree'de parametre olarak verilen
     * person objesinin olup olmadigini kontrol et
     * @param person objesi
     * @param node node referansi
     * @return true person objesi tree'de yoksa, false varsa
     */
    private boolean checkPerson(Person person, Node<Person> node){
        if(node==null)
            return true;
        else if(person.equals(node.getData()))
            return false;

        return checkPerson(person, node.getLeft()) || checkPerson(person, node.getRight());
    }

    /**
     * ilk elemani family tree'ye ekleyen constructor
     * @param rootName root eleman ismi
     */
    public FamilyTree(String rootName){
        super.add(new Person(rootName,"",""));
    }
    /**
     * Binary Tree preorder iterator
     * @return preorder iterator
     */
    @Override
    public Iterator<Person> iterator(){
        return new LevelOrderIterator<>();
    }

    /**
     * level order iterator class
     * @param <E> generic
     */
    private class LevelOrderIterator<E> implements Iterator<E> {
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
