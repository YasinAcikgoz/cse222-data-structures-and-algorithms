import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;

/**
 *
 * Created by yacikgoz on 10.03.2017.
 */
public class MyStringBuilder <E>{
    SingleLinkedList<Character> chars;

    /**
     * constructor
     */
    public MyStringBuilder(){
        chars = new SingleLinkedList<>();
    }

    /**
     * append metod
     * @param object object
     * @return Mystringbuider object
     */
    private MyStringBuilder append(Object object){
        MyStringBuilder myStringBuilder;
        if(object instanceof String)
            myStringBuilder = appendStr((String)object);
        else if(object instanceof Boolean)
            myStringBuilder = appendBool((Boolean) object);
        else if(object instanceof Double)
            myStringBuilder = appendDouble((Double)object);
        else if(object instanceof Integer)
            myStringBuilder = appendInt((Integer)object);
        else if(object instanceof Float)
            myStringBuilder = appendFloat((Float)object);
        else if(object instanceof Character)
            myStringBuilder = appendChar((Character)object);
        else if(object instanceof CharSequence)
            myStringBuilder = appendCharSeq((CharSequence)object);
        else if(object instanceof Long)
            myStringBuilder = appendLong((Long)object);
        else if(object instanceof char[])
            myStringBuilder = appendCharArr((char [])object);
        else
            myStringBuilder = appendStr(String.valueOf(object));
        return myStringBuilder ;
    }

    /**
     * append String
     * @param str string value
     * @return MyStringBuilder object
     */
    private MyStringBuilder appendStr(String str){
        if(str== null)
            return appendNull();
        for(int i=0; i<str.length(); ++i) {
            chars.add(str.charAt(i));
        }
        return this;
    }
    private MyStringBuilder appendBool(boolean b){
        if(b){
            chars.add('t');
            chars.add('r');
            chars.add('u');
            chars.add('e');
        } else{
            chars.add('f');
            chars.add('a');
            chars.add('l');
            chars.add('s');
            chars.add('e');
        }
        return this;
    }

    /**
     * append char
     * @param c char value
     * @return MyStringBuilder object
     */
    private MyStringBuilder appendChar(char c){
        chars.add(c);
        return this;
    }

    /**
     * append char arr
     * @param str char array
     * @return MyStringBuilder object
     */
    private MyStringBuilder appendCharArr(char[] str){
        for(int i=0; i<str.length; ++i)
            chars.add(str[i]);
        return this;
    }

    /**
     * append char sequence
     * @param s charsequence
     * @return MyStringBuilder
     */
    private MyStringBuilder appendCharSeq(CharSequence s){
        if (s == null)
            return appendNull();
        else
            return this.append(s);
    }

    /**
     * append null metod
     * @return
     */
    private MyStringBuilder appendNull() {
        chars.add('n');
        chars.add('u');
        chars.add('l');
        chars.add('l');
        return this;
    }

    /**
     * append double metod
     * @param d double value
     * @return MyStringBuilder object
     */
    private MyStringBuilder appendDouble(double d){
        String num = Double.toString(d);
        append(num);
        return this;
    }

    /**
     * append float metod
     * @param f float value
     * @return MyStringBuilder object
     */
    private MyStringBuilder appendFloat(float f){
        String num = Float.toString(f);
        append(num);
        return this;
    }

    /**
     * append int metod
     * @param i integer value
     * @return MyStringBuilder object
     */
    private MyStringBuilder appendInt(int i){
        String num = Integer.toString(i);
        append(num);
        return this;
    }

    /**
     * append long metod
     * @param lng long value
     * @return MyStringBuilder object
     */
    private MyStringBuilder appendLong(long lng){
        String num = Long.toString(lng);
        append(num);
        return this;
    }

    /**
     * karakter linked list elemanlarina linked list'in get metoduyla erisip
     * append metodunu kullanarak dosyaya ekleyen toString1 metodu
     * @return running time
     * @throws IOException exception
     */
    public String toString1() throws IOException {
        long start, end;
        readFile();
        start = System.currentTimeMillis();
        try{
            PrintWriter writer = new PrintWriter("src/result1.txt");
            for(int i=0; i<chars.size(); ++i)
                writer.print(chars.get(i));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        end  = System.currentTimeMillis();
        return "Execution time is " + getRunningTime(start, end)+ " seconds for toString1() method.\n";
    }


    /**
     * karakter linked list elemanlarina linked list'in iteratoruyle erisip
     * append metodunu kullanarak dosyaya ekleyen toString2 metodu
     * @return running time
     * @throws IOException exception
     */
    public String toString2() throws IOException {
        long start, end;
        readFile();
        start = System.currentTimeMillis();
        try{
            PrintWriter writer = new PrintWriter("src/result2.txt");
            Iterator<Character> iter = chars.Iterator();
            while(iter.hasNext()){
                writer.print(iter.next());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        end  = System.currentTimeMillis();
        return "Execution time is " + getRunningTime(start, end)+ " seconds for toString2() method.\n";
    }

    /**
     * karakter linked list'in elemanlarini dosyaya linked list'in
     * toString metoduya yazan toString3 metodu
     * @return running time
     * @throws IOException exception
     */
    public String toString3() throws IOException {
        long start, end;
        readFile();
        start = System.currentTimeMillis();
        try{
            PrintWriter writer = new PrintWriter("src/result3.txt");
            writer.print(lltoString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        end  = System.currentTimeMillis();
        return "Execution time is " + getRunningTime(start, end)+ " seconds for toString3() method.\n";
    }

    /**
     * verilen zaman aralıklarındaki gecen zamani hesaplayan fonksiyon
     * @param start baslangic zamani
     * @param end bitis zamani
     * @return calisma zamani (string olarak)
     */
    private String getRunningTime(long start, long end){
        long total = end - start;
        NumberFormat formatter = new DecimalFormat("#0.00000");
        return formatter.format((total) / 1000d);
    }

    /**
     * main'de olusturulan input dosyasini okuyan metod
     * @throws IOException exception
     */
    private void readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        try {
            String line = br.readLine();
            while (line != null) {
                append(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            br.close();
        }
    }

    /**
     * linked list sinifina ait toString metodu
     * @return string
     */
    private String lltoString(){
        Iterator<Character> it = chars.Iterator();
        if (! it.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            Character e = it.next();
            sb.append(e);
            if (!it.hasNext()){
                return sb.append(']').toString();
            }
            sb.append(',').append(' ');
        }
    }
}
