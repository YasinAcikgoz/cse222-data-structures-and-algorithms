import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * Created by yacikgoz on 21.05.2017.
 */
public class Main {
    public static void main(String [] args) throws IOException {
        int [] out;
        int i=0;
        //input file
        File graph1 = new File("IOFiles/input_graph.txt");
        File graph2 = new File("IOFiles/input2_graph.txt");
        System.out.println("-------- TEST 1 --------");
        //List graph
        AbstractGraphExtended lgObj = (AbstractGraphExtended) AbstractGraph.createGraph(new Scanner(graph1), false, "List");
        lgObj.addRandomEdgesToGraph(11);
        lgObj.writeGraphToFile ("IOFiles/output_list_graph.txt");
        out = lgObj.breadthFirstSearch(0);
        System.out.print("Breadth First Search -> ");
        for (i=0; i<out.length; ++i)
            System.out.print(out[i] + " ");
        System.out.println();


        //Matrix graph
        AbstractGraphExtended mgObj = (AbstractGraphExtended) AbstractGraph.createGraph(new Scanner(graph1), false, "Matrix");
        mgObj.addRandomEdgesToGraph(8);
        mgObj.writeGraphToFile ("IOFiles/output_matrix_graph.txt");
        out = mgObj.breadthFirstSearch(1);
        System.out.print("Breadth First Search -> ");
        for (i=0; i<out.length; ++i)
            System.out.print(out[i] + " ");
        System.out.println();


        System.out.println("-------- TEST 2 --------");
        //List graph
        AbstractGraphExtended lgObj2 = (AbstractGraphExtended) AbstractGraph.createGraph(new Scanner(graph2), false, "List");
        lgObj2.addRandomEdgesToGraph(6);
        lgObj2.writeGraphToFile ("IOFiles/output2_list_graph.txt");
        out = lgObj2.breadthFirstSearch(0);
        System.out.print("Breadth First Search -> ");
        for (i=0; i<out.length; ++i)
            System.out.print(out[i] + " ");
        System.out.println();


        //Matrix graph
        AbstractGraphExtended mgObj2 = (AbstractGraphExtended) AbstractGraph.createGraph(new Scanner(graph2), false, "Matrix");
        mgObj2.addRandomEdgesToGraph(9);
        mgObj2.writeGraphToFile ("IOFiles/output2_matrix_graph.txt");
        out = mgObj2.breadthFirstSearch(1);
        System.out.print("Breadth First Search -> ");
        for (i=0; i<out.length; ++i)
            System.out.print(out[i] + " ");
        System.out.println();
    }
}
