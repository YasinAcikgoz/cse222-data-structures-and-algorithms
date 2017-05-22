import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * Created by yacikgoz on 21.05.2017.
 */
public abstract class AbstractGraphExtended extends AbstractGraph{

    /**
     * Construct a graph with the specified number of vertices
     * and the directed flag. If the directed flag is true,
     * this is a directed graph.
     *
     * @param numV     The number of vertices
     * @param directed The directed flag
     */
    public AbstractGraphExtended(int numV, boolean directed) {
        super(numV, directed);
    }

    /**
     * add random edge to graph
      * @param edgeLimit edge limit
     * @return edge limit
     */
    public int addRandomEdgesToGraph (int edgeLimit){
        int s, d;
        Random random = new Random();
        Edge edge;
        for (int i = 0; i < edgeLimit; ++i) {
            s = random.nextInt(getNumV());
            d = random.nextInt(getNumV());
            if (isEdge(s, d))
                --edgeLimit;
            else {
                edge = new Edge(s, d);
                insert(edge);
               // System.out.println("edge: " + edge.toString());
            }
          //  System.out.println("i: " + i + " d: " + d + " s: " + s);
        }
        return edgeLimit;
    }

    /**
     * writes graph to file
     * @param fileName file name
     * @throws IOException exception
     *
     */
    public void writeGraphToFile (String fileName) throws IOException {

        PrintWriter writer = new PrintWriter(new FileWriter(fileName));
        writer.println(getNumV());
        Graph graph = new ListGraph(getNumV(),false);

        for(int i=0; i<getNumV(); ++i){
            Iterator<Edge> edgeIterator = edgeIterator(i);
            while(edgeIterator.hasNext()){
                Edge edge = edgeIterator.next();
                if (!graph.isEdge(edge.getSource(), edge.getDest())) {
                    // source_destination
                    writer.println(edge.getSource() + " " + edge.getDest());

                    graph.insert(edge);
                //    System.out.println("e: " + edge.toString());
                }
            }
        }
        writer.close();
    }

    /**
     * breadthFirstSearch metod
     * @param start vertex
     * @return int array
     */
    public int [] breadthFirstSearch (int start){
        Queue< Integer > theQueue = new LinkedList<>();
        int[] parent = new int[this.getNumV()];
        for (int i = 0; i < this.getNumV(); i++) {
            parent[i] = -1;
        }
        boolean[] identified = new boolean[this.getNumV()];
        identified[start] = true;
        theQueue.offer(start);
        while (!theQueue.isEmpty()) {
            int current = theQueue.remove();
            Iterator < Edge > itr = this.edgeIterator(current);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                int neighbor = edge.getDest();
                if (!identified[neighbor]) {
                    identified[neighbor] = true;
                    theQueue.offer(neighbor);
                    parent[neighbor] = current;
                }
            }
        }
        return parent;
    }
    public Graph [] getConnectedComponentUndirectedGraph (){



        return null;
    }
    public boolean isBipartiteUndirectedGraph (){


        return false;
    }

}
