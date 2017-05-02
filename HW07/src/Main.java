
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;


public class Main
{
    public static void main(String args[]){
        final Boolean q1 = Q1Test();
        final Boolean q2 = Q2Test();
        if (q1 == q2 == Boolean.TRUE) {
            System.out.println("Your tests is done. Make sure that you test all methods of class!! " );
            return;
        }
    }
    public static Boolean Q1Test(){

        NavigableMap<String,String> turkey = new BinaryNavMap<>();
        System.out.println("\n----------- PART 1 -----------------\n");
        turkey.put("uskudar","istanbul");
        turkey.put("kadıkoy","istanbul");
        turkey.put("cekirge","bursa");
        turkey.put("gebze","kocaeli");
        turkey.put("niksar","tokat");
        turkey.put("kecıoren","ankara");
        turkey.put("aksaray","istanbul");
        turkey.put("foca","izmir");
        turkey.put("manavgat","antalya");
        turkey.put("kahta","adıyaman");
        turkey.put("biga","canakkale");


        System.out.println("The original set odds is " + turkey.toString());
        System.out.println("The first key is " + turkey.firstKey());
        System.out.println("The last key is " + turkey.lastKey());
        System.out.println("The first entry is " + turkey.firstEntry());
        System.out.println("The last entry is " + turkey.lastEntry());

        return Boolean.TRUE;

    }
    public static Boolean Q2Test(){
        HashMap<String,String> turkey=new HashTableChaining<String,String>();
        System.out.println("\n----------- PART 2 -----------------\n");
        System.out.println("isEmpty: " + turkey.isEmpty());
        turkey.put("edremit","balikesir");
        turkey.put("edremit","van");
        turkey.put("kemalpasa","bursa");
        turkey.put("kemalpasa","izmir");
        turkey.put("ortakoy","istanbul"); //we assume a district
        turkey.put("ortakoy","aksaray");
        turkey.put("ortakoy","corum");
        turkey.put("kecıoren","ankara");
        turkey.put("pinarbasi","kastamonu");
        turkey.put("pinarbasi","kayseri");
        turkey.put("eregli","konya");
        turkey.put("eregli","tekirdag");
        turkey.put("eregli","zonguldak");
        turkey.put("golbasi","adıyaman");
        turkey.put("golbasi","ankara");
        turkey.put("biga","canakkale");

        System.out.println("size: " + turkey.size());
        System.out.println("remove: " + turkey.remove("eregli"));
        System.out.println("isEmpty: " + turkey.isEmpty());
        System.out.println("size: " + turkey.size());

        return Boolean.TRUE;
    }


}
