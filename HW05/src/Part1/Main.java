package Part1;

import java.io.*;
import java.util.Iterator;

/**
 * main class
 * Created by yacikgoz on 2.04.2017.
 */
public class Main {
    public static void main(String[] args){

        BinaryTree<Integer> BTree = new BinaryTree<>();
        BinarySearchTree<Integer> BSTree = new BinarySearchTree<>();
        readFile(BTree);
        readFile(BSTree);

        Iterator<Integer> BTIter = BTree.iterator();
        Iterator<Integer> BSTIter = BSTree.iterator();

        System.out.println("\npre order traverse");
        while (BTIter.hasNext())
            System.out.print(BTIter.next() +" ");
        System.out.println("\nlevel order traverse");
        while (BSTIter.hasNext())
            System.out.print(BSTIter.next()  +" ");

        System.out.println("result: " + BSTree.min(BSTree.root, 4));


    }

    /**
     * test.txt dosyasini tree'ye ekler
     * @param tree binary tree
     */
    public static void readFile(BinaryTree<Integer> tree ){
        String usersFile = "src/Part1/test.txt";
        try {
            File file = new File(usersFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String [] temp = line.split(" ");
                for(int i=0; i<temp.length; ++i)
                    tree.add(Integer.parseInt(temp[i]));
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
