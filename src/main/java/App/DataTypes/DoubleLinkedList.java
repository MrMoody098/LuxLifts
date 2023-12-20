package App.DataTypes;

import App.Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

/**
 * Doubly linked list implementation for storing and manipulating generic data.
 *
 * @param <T> The type of data stored in the list.
 */
public class DoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    /**
     * Initializes an empty doubly linked list.
     */
    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    /**
     * Retrieves an iterable containing all elements in the list.
     *
     * @return An iterable containing all elements in the list.
     */
    public Iterable<T> getAll() {
        List<T> dataList = new ArrayList<>();
        Node<T> current = head;

        // Traverse the list and add each element to the dataList
        while (current != null) {
            dataList.add(current.data);
            current = current.next;
        }

        return dataList;
    }

    /**
     * Adds a new element to the end of the list.
     *
     * @param data The data to be added.
     */
    public void add(Vehicle data) {
        Node newNode = new Node(data);

        // If the list is empty, set the new node as both head and tail
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    /**
     * Removes the specified element from the list.
     *
     * @param data The data to be removed.
     */
    public void remove(Vehicle data) {
        Node current = head;

        // Traverse the list to find the node with the specified data
        while (current != null) {
            if (current.data.equals(data)) {
                // Adjust pointers to remove the node
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                break;
            }
            current = current.next;
        }
    }

    /**
     * Checks if the list contains the specified element.
     *
     * @param data The data to check for.
     * @return True if the list contains the element, false otherwise.
     */
    public boolean contains(T data){
        Node current = head;
        while (current != null){
            if (current.data.equals(data)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Moves the specified element to the end of the list.
     *
     * @param data The data to be moved to the end.
     */
    public void moveToEnd(Vehicle data) {
        Node current = head;

        // Traverse the list to find the node with the specified data
        while (current != null) {
            if (current.data.equals(data)) {

                // Adjust pointers to move the node to the end
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                // Set pointers to add the node to the end
                if (tail != null) {
                    tail.next = current;
                    current.prev = tail;
                    current.next = null;
                    tail = current;
                } else {
                    head = tail = current;
                    current.prev = current.next = null;
                }

                return;
            }

            current = current.next;
        }
    }

    /**
     * Gets the size of the list.
     *
     * @return The size of the list.
     */
    public int size() {
        int count = 0;
        Node current = head;

        // Count the number of nodes in the list
        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    /**
     * Retrieves the element at the specified index.
     *
     * @param index The index of the element to retrieve.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException If the index is out of bounds.
     */
    public T getAtIndex(int index) {
        // Check if the index is within valid bounds
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }

        Node<T> current = head;

        // Traverse the list to the specified index
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }
}
