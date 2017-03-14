import java.util.*;

/**
 * MyAbstractCollection.java
 * Created by yacikgoz on 11.03.2017.
 */
public class MyAbstractCollection<E> extends AbstractCollection<E>{

    public void appendAnything(MyAbstractCollection obj){
        super.addAll(obj);
    }
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

}
