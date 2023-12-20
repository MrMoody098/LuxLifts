package App.DataTypes;

/**
 * Node class for a doubly linked list.
 *
 * @param <T> The type of data stored in the node.
 */
public class Node<T> {
    public T data;
    public Node<T> next;
    public Node<T> prev;

    /**
     * Initializes a node with the specified data.
     *
     * @param data The data to be stored in the node.
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
