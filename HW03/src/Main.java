import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * Created by yacikgoz on 10.03.2017.
 */
public class Main{
    private static long start, end;
    public static void main(String [] args){
        SingleLinkedList<Object> list = new SingleLinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("yasin");
        sb.append("acikgoz");
        System.out.println(sb.toString());
       /* for(int i=0; i<500; ++i){
            linkedList.addFirst(i);
        }*/

       /* for(int i =0 ; i<10000; ++i)
            linkedList.addFirst("y");*/
       for (int i = 0; i<3; ++i){
           if(i%2==0)
               list.addFirst(true);
           else
               list.addFirst(false);
       }
       list.addFirst("str");
        list.addFirst(465);
        MyStringBuilder<Object> myStringBuilder = new MyStringBuilder<>();
   /*     start = System.currentTimeMillis();
        System.out.println("toString1");
        stringBuilder.toString1();
        end  = System.currentTimeMillis();
        System.out.print("Execution time is " + getRunningTime(start, end)+ " seconds\n");*/

        start = System.currentTimeMillis();
        System.out.println("toString1");
        System.out.println(myStringBuilder.toString1(list));
      //  myStringBuilder.toString1(list);
        end  = System.currentTimeMillis();
        System.out.print("Execution time is " + getRunningTime(start, end)+ " seconds\n");



    }
    private static String getRunningTime(long start, long end){
        long total = end - start;
        NumberFormat formatter = new DecimalFormat("#0.00000");
        return formatter.format((total) / 1000d);
    }
    private static void fillFile(){
        try{
            PrintWriter writer = new PrintWriter("the-file-name.txt");
            writer.println("The first line");
            writer.println("The second line");
            writer.close();
        } catch (IOException e) {
            // do something
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
