import java.util.Iterator;
import java.util.Stack;

/*
 *
 * Created by yacikgoz on 13.03.2017.
 *
 */
public class ReuseDeletedNodes <E>{
    SingleLinkedList<E> list;
    Stack<Node> deletedNodes;

    /**
     * Node class
     * @param <E> generic type
     */
    private static class Node < E > {
        /** The data value. */
        private E data;

        /** constructor
         @param dataItem data value
         */
        private Node(E dataItem) {
            data = dataItem;
        }
    }

    /**
     * constructor
     */
    public ReuseDeletedNodes(){
        list = new SingleLinkedList<>();
        deletedNodes = new Stack<>();
    }

    /**
     * add Object
     * @param obj object
     */
    public void add(E obj){
        if(deletedNodes.isEmpty())
            list.add(list.size(),obj);
        else{
            Node node =  deletedNodes.pop();
            node.data=obj;
            list.add(list.size(), (E) node.data);
        }
    }

    /**
     * delete metod
     * @param obj object
     */
    public void delete(E obj){
        Iterator iter = list.Iterator();
        Object temp ;
        int index = -1, j=0;
        for(int i=0; i<list.size(); ++i){
            if(list.get(i) !=null && list.get(i).equals(obj)){
               // System.out.println("bulundu: "+  i  + " obj: "  + list.get(i));
                index = i;
            }
        }
        if(index>0)
            while(iter.hasNext()){
            if(j!=index)
                temp = iter.next();
            else
                temp = obj;
            if(temp!=null && temp.equals(obj)){
              //  System.out.println("aranan eleman: " + temp.toString());
                iter.remove();
                Node node = new Node<>(obj);
                deletedNodes.push(node);
            }
            ++j;
        }
    }

    /**
     * list to string metod
     * @return string
     */
    @Override
    public String toString() {
        return list.myToString();
    }
}
