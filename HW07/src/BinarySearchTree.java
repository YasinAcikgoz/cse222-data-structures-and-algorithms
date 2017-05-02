import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class for a binary search tree that stores type E objects.
 * Created by yacikgoz on 6.04.2017.
 */
public class BinarySearchTree <E extends Comparable <E>> extends BinaryTree<E> {

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("{");
        helpToString(root, string);
        string.append("}");
        return string.toString();
    }

    /**
     * Recursive help method for toString in order traversal
     *
     * @param node root node
     * @param string string builder
     */
    private void helpToString(Node<E> node, StringBuilder string) {
        if (node == null)
            return;

        if (node.left != null) {
            helpToString(node.left, string);
            string.append(", ");
        }

        string.append("\n");
        string.append(node.data);

        if (node.right != null) {
            string.append(", ");
            helpToString(node.right, string);
        }
    }
}
