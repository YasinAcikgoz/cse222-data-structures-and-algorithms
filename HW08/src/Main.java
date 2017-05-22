/**
 *
 * Created by yacikgoz on 11.05.2017.
 */
public class Main {

    public static void main(String []args){
        AVLTree<Integer> avlTree = new AVLTree<>();

        avlTree.add(5);
        avlTree.add(9);
        avlTree.add(7);
        avlTree.add(3);
        avlTree.add(2);
        avlTree.delete(3);

        System.out.println(avlTree.toString());


    }
}
