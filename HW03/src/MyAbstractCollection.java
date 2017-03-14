import java.util.*;

/**
 * MyAbstractCollection.java
 * Created by yacikgoz on 11.03.2017.
 */
public abstract class MyAbstractCollection<E> extends AbstractCollection<E>{
    /**
     * concats two MyAbstractCollection object
     * @param obj MyAbstractCollection object
     */
    public void appendAnything(MyAbstractCollection obj){
        Iterator<E> iter = obj.iterator();
        while(iter.hasNext()){
            this.add(iter.next());
        }
    }
}
