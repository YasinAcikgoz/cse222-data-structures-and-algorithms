import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * Created by yacikgoz on 10.03.2017.
 */
public class Main{
    private final static int MAX = 10000;
    public static void main(String [] args) throws IOException {
        System.out.println("/****************************PART 1***************************************/");
        fillFile();
        MyStringBuilder<Object> myStringBuilder = new MyStringBuilder<>();
        System.out.println(myStringBuilder.toString1());
        System.out.println(myStringBuilder.toString2());
        System.out.println(myStringBuilder.toString3());

        System.out.println("/****************************PART 2***************************************/");
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.reverseToString();


        System.out.println("/****************************PART 4***************************************/");
        ReuseDeletedNodes<Integer> list = new ReuseDeletedNodes<>();
       for(int i=1; i<=100; ++i)
            list.add(i);

        System.out.println("List (1-100)\n" + list.toString());
        for(int i=50; i<=100; ++i){
            list.delete(i);
        }
        System.out.println("List After Deleting (50-99)\n" + list.toString());
        System.out.println("Deleted Node List (50-99)\n" + list.deletedToString());
        for(int i=100; i<=150; ++i) {
            list.add(i);
        }
        System.out.println("List After Inserting (1-50) - (100-150) (\n" + list.toString());
        System.out.println("Deleted Node List\n" + list.deletedToString());
    }

    /**
     * input.txt dosyasini integer degerlerle doldur
     */
    private static void fillFile(){
        try{
            PrintWriter writer = new PrintWriter("src/input.txt");
            for (int i = 0; i<MAX; ++i){
                writer.println(i);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
