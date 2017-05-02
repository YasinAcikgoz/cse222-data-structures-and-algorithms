/**
 *
 * Created by syucer on 4/24/2017.
 */
public class HashTableChaining<K, V> implements HashMap<K, V> {
    /** The table */
    private HashtableOpen<K, V>[] table;
    //Do not forget you can use more class and methods to do this homework,
    // this project gives you an initial classes an methods to see easily
    //....
    //.... other class members
  //  private LinkedList<BinaryNavMap.Entry<K,V>>[] table;
    private final int INITIAL_CAPACITY = 101;

    private int numKeys;

    /**
     * constructor
     */
    public HashTableChaining(){
        table = new HashtableOpen[INITIAL_CAPACITY];
    }

    /**
     * get metodu
     * verilen key degerine gore value return eder
     * @param key key
     * @return value
     */
    @Override
    public V get(Object key) {
        //index olustur
        int index = key.hashCode() % table.length;
        //index degerinin 0'dan buyuk olup olmadigini kontrol et
        if(index<0)
            index+=table.length;

        if(table[index]==null)
            return null;
        else
            return table[index].get(key);

    }

    /**
     * put metodu
     * verilen key degerine gore tabloya ekleme yapar.
     * @param key eklenecek key
     * @param value eklenecek value
     * @return eklenen value
     */
    @Override
    public V put(K key, V value) {
        //index olustur
        int index = key.hashCode() % table.length;
        //index degerinin 0'dan buyuk olup olmadigini kontrol et
        if(index<0)
            index+=table.length;
        //tablo indexi bossa yeni bir linked list referansi olustur
        if(table[index]==null)
            table[index] = new HashtableOpen<>();


        // tabloyu keyi bulmak icin dolas
        table[index].put(key,value);
        ++numKeys;

        return value;
    }

    /**
     * remove metodu
     * @param key silinceke key
     * @return return silinecek eleman tabloda yoksa null, varsa silinen entrynin degeri.
     */
    @Override
    public V remove(Object key) {
        //index olustur
        int index = key.hashCode() % table.length;

        if (index < 0)
            index += table.length;

        if (table[index] == null) //key tabloda yok
            return null;

        V returnVal = table[index].remove(key);
        if(returnVal!=null)
            --numKeys;
        return returnVal;

    }

    /**
     * size metodu
     * @return tablodaki key sayisi
     */
    @Override
    public int size() {
        return numKeys;
    }

    /**
     * isEmpty metod
     * @return true tablo full degilse, false full doluysa
     */
    @Override
    public boolean isEmpty() {
        return numKeys == 0;
    }


}
