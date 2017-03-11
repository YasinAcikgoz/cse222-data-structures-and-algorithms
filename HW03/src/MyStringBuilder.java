import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * Created by yacikgoz on 10.03.2017.
 */
public class MyStringBuilder <E>{
    SingleLinkedList<Character> chars;

    public MyStringBuilder(){
        chars = new SingleLinkedList<>();
    }

    public MyStringBuilder append(Object object){
        if(object instanceof String)
            appendStr((String)object);
        else if(object instanceof Boolean)
            appendBool((Boolean) object);
        else if(object instanceof Double)
            appendDouble((Double)object);
        else if(object instanceof Integer)
            appendInt((Integer)object);
        else if(object instanceof Float)
            appendFloat((Float)object);
        else if(object instanceof Character)
            appendChar((Character)object);
        else if(object instanceof CharSequence)
            appendCharSeq((CharSequence)object);
        else if(object instanceof Long)
            appendLong((Long)object);
        else if(object instanceof char[])
            appendCharArr((char [])object);
        else
            appendStr(String.valueOf(object));


        return this;
    }
    public MyStringBuilder appendStr(String str){
        if(str== null)
            return appendNull();
        for(int i=0; i<str.length(); ++i) {
            chars.addFirst(str.charAt(i));
        }
        return this;
    }
    public MyStringBuilder appendBool(boolean b){
        if(b){
            chars.addFirst('t');
            chars.addFirst('r');
            chars.addFirst('u');
            chars.addFirst('e');
        } else{
            chars.addFirst('f');
            chars.addFirst('a');
            chars.addFirst('l');
            chars.addFirst('s');
            chars.addFirst('e');
        }
        return this;
    }
    public void appendChar(char c){
        chars.addFirst(c);
    }
    public void appendCharArr(char[] str){
        for(int i=0; i<str.length; ++i)
            chars.addFirst(str[i]);
    }
    public MyStringBuilder appendCharSeq(CharSequence s){
        if (s == null)
            return appendNull();
        else
            return this.append(s);

    }
    private MyStringBuilder appendNull() {
        chars.addFirst('n');
        chars.addFirst('u');
        chars.addFirst('l');
        chars.addFirst('l');
        return this;
    }
    public MyStringBuilder appendDouble(double d){
        String num = Double.toString(d);
        append(num);
        return this;
    }
    public MyStringBuilder appendFloat(float f){
        String num = Float.toString(f);
        append(num);
        return this;

    }
    public MyStringBuilder appendInt(int i){
        String num = Integer.toString(i);
        append(num);
        return this;

    }
    public MyStringBuilder appendLong(long lng){
        String num = Long.toString(lng);
        append(num);
        return this;
    }

    public String toString1(SingleLinkedList<E> list){
        MyStringBuilder sb = new MyStringBuilder();

        for(int i=0; i<list.size(); ++i){
            System.out.println(list.get(i).toString());
            sb.append((E)list.get(i));
        }
        return sb.toString();
    }
    public String toString2(SingleLinkedList<E> list){
        Iterator<E> iter = list.iterator();
        String temp = "";

        while(iter.hasNext()){

            temp += iter.next();
        }
        return temp;
    }
    public String toString3(SingleLinkedList<E> list){
        return list.toString();
    }
}
