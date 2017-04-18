/**
 * Main.java
 * Created by Yasin on 9.04.2016.
 */
public class Main {
    /**
     * Main metodu
     * @param args command line arguments
     */
    public static void main(String args[]){
        HuffmanTree Htree = new HuffmanTree();
        // Create symbol array
        HuffmanTree.HuffData[] symbols = {
                new HuffmanTree.HuffData(186, '_'),
                new HuffmanTree.HuffData(103, 'e'),
                new HuffmanTree.HuffData(80, 't'),
                new HuffmanTree.HuffData(64, 'a'),
                new HuffmanTree.HuffData(63, 'o'),
                new HuffmanTree.HuffData(57, 'i'),
                new HuffmanTree.HuffData(57, 'n'),
                new HuffmanTree.HuffData(51, 's'),
                new HuffmanTree.HuffData(48, 'r'),
                new HuffmanTree.HuffData(47, 'h'),
                new HuffmanTree.HuffData(32, 'd'),
                new HuffmanTree.HuffData(32, 'l'),
                new HuffmanTree.HuffData(23, 'u'),
                new HuffmanTree.HuffData(22, 'c'),
                new HuffmanTree.HuffData(21, 'f'),
                new HuffmanTree.HuffData(20, 'm'),
                new HuffmanTree.HuffData(18, 'w'),
                new HuffmanTree.HuffData(16, 'y'),
                new HuffmanTree.HuffData(15, 'g'),
                new HuffmanTree.HuffData(15, 'p'),
                new HuffmanTree.HuffData(13, 'b'),
                new HuffmanTree.HuffData(8, 'v'),
                new HuffmanTree.HuffData(5, 'k'),
                new HuffmanTree.HuffData(1, 'j'),
                new HuffmanTree.HuffData(1, 'q'),
                new HuffmanTree.HuffData(1, 'x'),
                new HuffmanTree.HuffData(1, 'z')
        };
        // Build hufffman tree
        Htree.buildTree(symbols);
        System.out.println("__________TEST FOR PART 1__________\n");
        String message = "yasin_acikgoz", message2 = "osman_suzer";
        System.out.printf("Message: %s\nEncoded Code:\t\t%s\n", message, Htree.encode(message, Htree.huffTree));
        String decodedCode = Htree.decode(Htree.encode(message, Htree.huffTree));
        System.out.println("Code to Message:\t"+Htree.encode(message, Htree.huffTree)+"\nDecoded Message: "+ decodedCode + "\n");

        System.out.printf("Message: %s\nEncoded Code:\t\t%s\n", message2, Htree.encode(message2, Htree.huffTree));
        decodedCode = Htree.decode(Htree.encode(message2, Htree.huffTree));
        System.out.println("Code to Message:\t"+Htree.encode(message2, Htree.huffTree)+"\nDecoded Message: "+ decodedCode + "\n");

    }
}
