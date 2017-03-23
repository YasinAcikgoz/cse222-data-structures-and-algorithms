import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Main.java
 * Created by yacikgoz on 21.03.2017.
 */
public class Main {
    public static StackA<Object> stackA;
    public static StackB<Object> stackB;
    public static StackC<Object> stackC;
    public static StackD<Object> stackD;
    public static MyQueue<Object> queue;
    public static void main(String []args) throws IOException {
        stackA = new StackA<>();
        stackB = new StackB<>();
        stackC = new StackC<>();
        stackD = new StackD<>();
        queue = new MyQueue<>();
        readFile();
        writeFile();
    }
    /**
     * read test2.csv file
     */
    protected static void readQueue(MyQueue myQueue) {
        String fileName = "src/test.csv";
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String [] temp = line.split(",");
                for(int i=0; i<temp.length; ++i){
                    if(isInteger(temp[i])){
                        int a = Integer.parseInt(temp[i]);
                        myQueue.offer(a);
                    } else if(isFloat(temp[i])){
                        float a = Float.parseFloat(temp[i]);
                        myQueue.offer(a);
                    } else if(temp[i].length()==1){
                        myQueue.offer(temp[i]);
                    } else{
                        myQueue.offer(temp[i]);
                    }
                }
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * read test2.csv file
     */
    protected static void readFile() {
        String fileName = "src/test.csv";
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String [] temp = line.split(",");
                for(int i=0; i<temp.length; ++i){
                    if(isInteger(temp[i])){
                        int a = Integer.parseInt(temp[i]);
                        stackA.push(a);
                        stackB.push(a);
                        stackC.push(a);
                        stackD.push(a);
                    } else if(isFloat(temp[i])){
                        float a = Float.parseFloat(temp[i]);
                        stackA.push(a);
                        stackB.push(a);
                        stackC.push(a);
                        stackD.push(a);
                    } else if(temp[i].length()==1){
                        stackA.push(temp[i]);
                        stackB.push(temp[i]);
                        stackC.push(temp[i]);
                        stackD.push(temp[i]);
                    } else{
                        stackA.push(temp[i]);
                        stackB.push(temp[i]);
                        stackC.push(temp[i]);
                        stackD.push(temp[i]);
                    }
                }
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * is integer metod
     * @param s string
     * @return bool
     */
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
    /**
     * is float metod
     * @param s string
     * @return bool
     */
    public static boolean isFloat(String s) {
        try {
            Float.parseFloat(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

    /**
     * write file metod
     * @throws IOException exception
     */
    public static void writeFile() throws IOException {
        try {
            long start, end;
            String testFile = "src/testResult_1.csv";
            PrintWriter writer = new PrintWriter(new FileWriter(testFile));
            String testFile2 = "src/testResult_2.csv";
            PrintWriter writer2 = new PrintWriter(new FileWriter(testFile2));
            writer.print(stackA.size()+ ", ");

            start = System.currentTimeMillis();
            while(!stackA.isEmpty())
                writer.print(stackA.pop() + ", ");

            end = System.currentTimeMillis();
            System.out.println("Execution time is " + getRunningTime(start, end)+ " seconds for stackA.\n");
            writer.println();

            start = System.currentTimeMillis();
            writer.print(stackB.size()+ ", ");
            while(!stackB.isEmpty())
                writer.print(stackB.pop() + ", ");
            end = System.currentTimeMillis();
            System.out.println("Execution time is " + getRunningTime(start, end)+ " seconds for stackB.\n");
            writer.println();

            start = System.currentTimeMillis();
            writer.print(stackC.size()+ ", ");
            while(!stackC.isEmpty())
                writer.print(stackC.pop() + ", ");
            end = System.currentTimeMillis();
            System.out.println("Execution time is " + getRunningTime(start, end)+ " seconds for stackC.\n");
            writer.println();

            start = System.currentTimeMillis();
            writer.print(stackD.size()+ ", ");
            while(!stackD.isEmpty())
                writer.print(stackD.pop() + ", ");
            end = System.currentTimeMillis();
            System.out.println("Execution time is " + getRunningTime(start, end)+ " seconds for stackD.\n");
            writer.println();

            readQueue(queue);
            writer2.print(queue.size() + ", ");
            while(!queue.isEmpty())
                writer2.print(queue.poll() + ", ");
            writer2.println();
            //ayni queue'yu yeniden dosyadan oku
            MyQueue<Object> temp = new MyQueue<>();
            readQueue(temp);
            temp.reverse();
            writer2.print(temp.size() + ", ");
            while(!temp.isEmpty())
                writer2.print(temp.poll() + ", ");
            writer2.println();

            writer.close();
            writer2.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * verilen zaman aralıklarındaki gecen zamani hesaplayan fonksiyon
     * @param start baslangic zamani
     * @param end bitis zamani
     * @return calisma zamani (string olarak)
     */
    public static String getRunningTime(long start, long end){
        long total = end - start;
        NumberFormat formatter = new DecimalFormat("#0.00000");
        return formatter.format((total) / 1000d);
    }

}
