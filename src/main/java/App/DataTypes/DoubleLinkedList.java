package App.DataTypes;

import App.Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class DoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public Iterable<T> getAll() {
        List<T> dataList = new ArrayList<>();
        Node<T> current = head;

        while (current != null) {
            dataList.add(current.data);
            current = current.next;
        }

        return dataList;
    }
    

    public void add(Vehicle data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void remove(Vehicle data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
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

        //I made these 3 additional methods that I think might be useful 
    public void moveToEnd(Vehicle data) { //this one when vehicle is selected it can be moved at the end of the list 
        Node current = head;
    
        while (current != null) {
            if (current.data.equals(data)) {
               
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

    public int size() {
        int count = 0;
        Node current = head;
    
        while (current != null) {
            count++;
            current = current.next;
        }
    
        return count;
    }
    

    public T getAtIndex(int index) {  
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
    
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
    
        return current.data;
    }

    
    
}
