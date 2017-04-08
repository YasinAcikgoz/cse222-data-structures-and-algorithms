package Part2;

import Part1.BinaryTree;

import java.io.*;
import java.util.Iterator;

/**
 * Main class
 * Created by yacikgoz on 8.04.2017.
 */
public class Main {
    /**
     * main class
     * @param args main arguments
     */
    public static void main(String[] args){
        FamilyTree familyTree = readFile();

        Iterator<Person> familyTreeIterator = familyTree.iterator();

        while (familyTreeIterator.hasNext())
            System.out.println(familyTreeIterator.next().getName());
    }

    /**
     * family.txt dosyasini tree'ye ekler
     * @return tree
     */
    public static FamilyTree readFile(){
        String usersFile = "src/Part2/family.txt";
        FamilyTree tree=null;
        try {
            File file = new File(usersFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // root person'ı oku
            String line = bufferedReader.readLine();
            tree = new FamilyTree(line);

            while ((line = bufferedReader.readLine()) != null) {
                String [] temp = line.split(",");
                if(!tree.add(temp[0], temp[1], temp[2]))
                    System.out.println(temp[0] + " family tree'ye eklenemedi.");
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tree;
    }
}
