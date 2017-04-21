import Part2.*;
import Part3.*;

import java.io.*;
import java.util.Iterator;

/**
 * Main.java
 * Created by Yasin on 9.04.2016.
 */
public class Main {
   public static HuffmanTree.HuffData[] symbols;
    /**
     * Main metodu
     * @param args command line arguments
     */
    public static void main(String args[]){
        HuffmanTree Htree = new HuffmanTree();
        //huffman tree symbol arrayi
        symbols = new HuffmanTree.HuffData[27];
        //freq.txt oku
        readFile();

        // hufffman tree olustur
        Htree.buildTree(symbols);
        System.out.println("__________TEST FOR PART 2__________\n");
        String str1 = "yasin_acikgoz", str2 = "nur_banu_albayrak", str3 = "galatasaray";

        System.out.printf("Message: %s\nEncoded Code:\t\t%s\n", str1, Htree.encode(str1, Htree.huffTree));
        String decodedCode = Htree.decode(Htree.encode(str1, Htree.huffTree));
        System.out.println("Code to Message:\t"+Htree.encode(str1, Htree.huffTree)+"\nDecoded Message: "+ decodedCode + "\n");

        System.out.printf("Message: %s\nEncoded Code:\t\t%s\n", str2, Htree.encode(str2, Htree.huffTree));
        decodedCode = Htree.decode(Htree.encode(str2, Htree.huffTree));
        System.out.println("Code to Message:\t"+Htree.encode(str2, Htree.huffTree)+"\nDecoded Message: "+ decodedCode + "\n");

        System.out.printf("Message: %s\nEncoded Code:\t\t%s\n", str3, Htree.encode(str3, Htree.huffTree));
        decodedCode = Htree.decode(Htree.encode(str3, Htree.huffTree));
        System.out.println("Code to Message:\t"+Htree.encode(str3, Htree.huffTree)+"\nDecoded Message: "+ decodedCode + "\n");

        System.out.println("\n__________TEST FOR PART 3__________\n");
        FamilyTree familyTree = readFamilyFile();

        Iterator<Person> levelOrderIterator = familyTree.iterator();

        while (levelOrderIterator.hasNext())
            System.out.println(levelOrderIterator.next().getName());
    }

    /**
     * reads freq.txt to symbols array
     */
    private static  void readFile(){
        try {
            int i=0;
            File file = new File( "src/Part2/freq.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String [] temp = line.split(" ");
                char c = temp[0].charAt(0);
                int freq = Integer.parseInt(temp[1]);
                symbols[i] = new HuffmanTree.HuffData(freq, c);
                ++i;
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * family.txt dosyasini tree'ye ekler
     * @return tree
     */
    public static FamilyTree readFamilyFile(){
        FamilyTree tree=null;
        try {
            File file = new File("src/Part3/family.txt");
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
