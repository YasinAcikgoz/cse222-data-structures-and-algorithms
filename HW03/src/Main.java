import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * Created by yacikgoz on 10.03.2017.
 */
public class Main{
    private final static int MAX = 100000;
    public static void main(String [] args) throws IOException {
        /****************************PART 1**************************************/
        fillFile();
        MyStringBuilder<Object> myStringBuilder = new MyStringBuilder<>();
        System.out.println(myStringBuilder.toString1());
        System.out.println(myStringBuilder.toString2());
        System.out.println(myStringBuilder.toString3());

        //System.out.println("/****************************PART 2***************************************/");
       // SingleLinkedList linkedList = new SingleLinkedList();
      //  linkedList.reverseToString();

        /****************************PART 3**************************************/
      /*  MyAbstractCollection<LinkedList> col1 = new MyAbstractCollection<>();
        MyAbstractCollection<ArrayList> col2 = new MyAbstractCollection<>();
        LinkedList<Object> linkedList = new LinkedList<>();
        ArrayList<Object> arrayList = new ArrayList<>();*/

        /****************************PART 4**************************************/
  //      ReuseDeletedNodes<Integer> list = new ReuseDeletedNodes<>();
     /*   list.add(5);
        list.add(15);
        list.add(25);
        list.add(35);
        list.add(45);
        System.out.println("list: " + list.toString());
        System.out.println("deletedlist: " + list.deletedToString());
        list.delete(15);
        list.delete(35);
        list.add(56);
        list.add(17);
        list.add(19);
        System.out.println("deletedlist: " + list.deletedToString());
        System.out.println("list: " + list.toString());*/
     /*   for(int i=0; i<=100; ++i)
            list.add(i);

        System.out.println("List (0-100)\n" + list.toString());
        for(int i=50; i<=100; ++i){
            list.delete(i);
        }
        System.out.println("List After Deleting (50-100)\n" + list.toString());
        System.out.println("Deleted Node List (50-100)\n" + list.deletedToString());
        for(int i=100; i<=150; ++i) {
            list.add(i);
        }
        System.out.println("List After Inserting (0-50) - (100-150) (\n" + list.toString());
        System.out.println("Deleted Node List\n" + list.deletedToString());*/
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
            // do something
        }
    }

}
