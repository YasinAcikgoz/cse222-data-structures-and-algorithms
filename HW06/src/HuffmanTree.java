import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to represent and build a Huffman tree.
 * @author Koffman and Wolfgang
 **/
public class HuffmanTree implements Serializable {

    // Nested Classes
    /** A datum in the Huffman tree. */
    public static class HuffData implements Serializable {
        // Data Fields

        /** The weight or probability assigned to this HuffData. */
        private double weight;
        /** The alphabet symbol if this is a leaf. */
        public Character symbol;

        public HuffData(double weight, Character symbol) {
            this.weight = weight;
            this.symbol = symbol;
        }

        public Character getSymbol() {return symbol;}
    }
    // Data Fields
    /** A reference to the completed Huffman tree. */
    protected BinaryTree<HuffData> huffTree;

    /** A Comparator for Huffman trees; nested class. */
    private static class CompareHuffmanTrees
            implements Comparator<BinaryTree<HuffData>> {

        public int compare(BinaryTree<HuffData> treeLeft,
                           BinaryTree<HuffData> treeRight) {
            double wLeft = treeLeft.getData().weight;
            double wRight = treeRight.getData().weight;
            return Double.compare(wLeft, wRight);
        }
    }

    /**
     * Builds the Huffman tree using the given alphabet and weights.
     * @param symbols An array of HuffData objects
     */
    public void buildTree(HuffData[] symbols) {
        Queue<BinaryTree<HuffData>> theQueue =
                new PriorityQueue<BinaryTree<HuffData>>(symbols.length,
                        new CompareHuffmanTrees());
        // Load the queue with the leaves.
        for (HuffData nextSymbol : symbols) {
            BinaryTree<HuffData> aBinaryTree =
                    new BinaryTree<HuffData>(nextSymbol, null, null);
            theQueue.offer(aBinaryTree);
        }

        // Build the tree.
        while (theQueue.size() > 1) {
            BinaryTree<HuffData> left = theQueue.poll();
            BinaryTree<HuffData> right = theQueue.poll();
            double wl = left.getData().weight;
            double wr = right.getData().weight;
            HuffData sum = new HuffData(wl + wr, null);
            BinaryTree<HuffData> newTree =
                    new BinaryTree<HuffData>(sum, left, right);
            theQueue.offer(newTree);
        }

        // The queue should now contain only one item.
        huffTree = theQueue.poll();
    }

    /**
     * Outputs the resulting code.
     * @param out A PrintStream to write the output to
     * @param code The code up to this node
     * @param tree The current node in the tree
     */
    private void printCode(PrintStream out, String code, BinaryTree<HuffData> tree) {
        HuffData theData = tree.getData();
        if (theData.symbol != null) {
            if (theData.symbol.equals(' ')) {
                out.println("space: " + code);
            } else {
                out.println(theData.symbol + ": " + code);
            }
        } else {
            printCode(out, code + "0", tree.getLeftSubtree());
            printCode(out, code + "1", tree.getRightSubtree());
        }
    }

    /**
     * Outputs the resulting code.
     * @param out A PrintStream to write the output to
     */
    public void printCode(PrintStream out) {
        printCode(out, "", huffTree);
    }

    /**
     * Method to decode a message that is input as a string of
     * digit characters '0' and '1'.
     * @param codedMessage The input message as a String of
     *        zeros and ones.
     * @return The decoded message as a String
     */
    public String decode(String codedMessage) {
        StringBuilder result = new StringBuilder();
        BinaryTree<HuffData> currentTree = huffTree;
        for (int i = 0; i < codedMessage.length(); i++) {
            if (codedMessage.charAt(i) == '1') {
                currentTree = currentTree.getRightSubtree();
            } else {
                currentTree = currentTree.getLeftSubtree();
            }
            if (currentTree.isLeaf()) {
                HuffData theData = currentTree.getData();
                result.append(theData.symbol);
                currentTree = huffTree;
            }
        }
        return result.toString();
    }

    /**
     * Print codes and their wiegths as string
     */
    public String toString(){

        String encodedCodes = "";
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        this.printCode(ps);
        //Htree.printCode(ps);

        try {
            encodedCodes = os.toString("UTF8");
            System.out.println("Encoded Codes : \n"+encodedCodes);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(HuffmanTree.class.getName()).log(Level.SEVERE, null, ex);
        }

        return encodedCodes;
    }

    /**
     * Verilen harfin huffman kodunu bulan fonksiyon
     * @param tree Its created huffman code for the alphabet
     * @param code huffman kod
     * @param c harf
     * @return huffman kod
     */
    public String findCode(BinaryTree<HuffData> tree, String code, char c){
        String r="";

        if (tree == null || (tree.isLeaf() && !(tree.getData().getSymbol().equals(c))))
            r = "";
        else if (tree.isLeaf() && tree.getData().getSymbol().equals(c))
            r=code;
        else {
            r+=findCode(tree.getLeftSubtree(), code + "0", c);
            r+=findCode(tree.getRightSubtree(), code + "1", c);
        }
        return r;
    }
    /**
     * Method to encode string message into Huffman encodes.
     * @param message The input message as a String
     * which is composed on the specified alphabet in the book
     * @param huffTree Its created huffman code for the alphabet
     * @return The encoded message as a String zero and ones.
     */
    public String encode(String message, BinaryTree<HuffData> huffTree) {
        String r = "";
        try {
            if (isAlpha(message)) {
                if (message.length() == 0) {
                    return r;
                } else {
                    r += findCode(huffTree, r, message.charAt(0));
                    return r + encode(message.substring(1), huffTree);
                }
            } else {
                throw new NoSuchElementException("illegal character.");
            }
        }catch (Exception e){
            System.out.printf(e.toString());
            System.exit(-1);
        }
        return r;
    }

    /**
     * Girilen stringin huffman tree'deki karakterleri icerip icermedigini kontrol eden fonksiyon
     * @param str   input string
     * @return  boolean
     */
    public boolean isAlpha(String str) {
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if(!Character.isLetter(c) && c!='_') {
                return false;
            }
        }
        return true;
    }
}
