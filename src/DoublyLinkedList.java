/*
 * NAME: Thomas Chen
 * PID: A15636810
 */

import java.util.AbstractList;

/**
 * TODO
 * @author Thomas Chen
 * @since 1.8
 */
public class DoublyLinkedList<T> extends AbstractList<T> {

    /* DLL instance variables */
    private int nelems;
    private Node head;
    private Node tail;

    /**
     * Node for chaining together to create a linked list
     */
    protected class Node {

        /* Node instance variables */
        T data;
        Node next;
        Node prev;

        /**
         * Constructor to create singleton Node
         */
        private Node(T element) {
            this.data = element;
            // TODO: complete constructor
        }

        /**
         * Constructor to create singleton link it between previous and next
         *
         * @param element  Element to add, can be null
         * @param nextNode successor Node, can be null
         * @param prevNode predecessor Node, can be null
         */
        private Node(T element, Node nextNode, Node prevNode) {
            // TODO: complete implementation
            this.data = element;
            this.next = nextNode;
            this.prev = prevNode;
        }

        /**
         * Set the element
         *
         * @param element new element
         */
        public void setElement(T element) {
            // TODO: complete implementation
            this.data = element;
        }

        /**
         * Accessor to get the Nodes Element
         */
        public T getElement() {
            // TODO: complete implementation
            return this.data;
        }

        /**
         * Set the next node in the list
         *
         * @param n new next node
         */
        public void setNext(Node n) {
            // TODO: complete implementation
            this.next = n;
        }

        /**
         * Get the next node in the list
         *
         * @return the successor node
         */
        public Node getNext() {
            // TODO: complete implementation
            return this.next;
        }

        /**
         * Set the previous node in the list
         *
         * @param p new previous node
         */
        public void setPrev(Node p) {
            // TODO: complete implementation
            this.prev = p;
        }


        /**
         * Accessor to get the prev Node in the list
         *
         * @return predecessor node
         */
        public Node getPrev() {
            // TODO: complete implementation
            return this.prev;
        }

        /**
         * Remove this node from the list.
         * Update previous and next nodes
         */
        public void remove() {
            // TODO: complete implementation
            this.getPrev().setNext(this.getNext());
            this.getNext().setPrev(this.getPrev());
        }
    }

    /**
     * Creates a new, empty doubly-linked list.
     */
    public DoublyLinkedList() {
        // TODO: complete default constructor

        this.head = new Node(null);
        this.tail = new Node(null);
        head.setNext(tail);
        tail.setPrev(head);

    }

    /**
     * Add an element to the end of the list
     *
     * @param element data to be added
     * @return whether or not the element was added
     * @throws NullPointerException if data received is null
     */
    @Override
    public boolean add(T element) throws NullPointerException {
        // TODO: Implementation for throwing exceptions followed by
        // implementation of adding the new data
        Node newNode = new Node(element);
        this.tail.getPrev().setNext(newNode);
        newNode.setPrev(this.tail.getPrev());
        newNode.setNext(this.tail);
        this.tail.setPrev(newNode);

        return true;
    }


    /**
     * Adds an element to a certain index in the list, shifting exist elements
     * create room. Does not accept null values.
     *
     * TODO: Javadoc comments
     */
    @Override
    public void add(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        // TODO: Implementation for throwing exceptions followed by
        // implementation of adding the new data
        Node newNode = new Node(element);
        Node temp = this.head;
        for (int i = 0; i <= index; i++){
            temp = temp.getNext();
            if (temp == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        temp.getPrev().setNext(newNode);
        newNode.setPrev(temp.getPrev());
        newNode.setNext(temp);
        temp.setPrev(newNode);
    }

    /**
     * Clear the linked list
     */
    @Override
    public void clear() {
        // TODO: implement clear
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
    }

    /**
     * Determine if the list contains the data element anywhere in the list.
     *
     * TODO: Javadoc comments
     */
    @Override
    public boolean contains(Object element) {
        T data = (T)element;
        // TODO: Fill in implementation
        Boolean check = false;
        Node temp = this.head;
        while (temp != null) {
            if (temp.getElement() == element) {
                check = true;
            }
            temp = temp.getNext();
        }
        return check;
    }

    /**
     * Retrieves the element stored with a given index on the list.
     *
     * TODO: Javadoc comments
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        // TODO: Fill in implementation to get the node at index
        return null;
    }

    /**
     * Helper method to get the Nth node in our list
     *
     * TODO: Javadoc comments
     */
    private Node getNth(int index) {
        // TODO: implement
        return null;
    }

    /**
     * Determine if the list empty
     *
     * TODO: javadoc comments
     */
    @Override
    public boolean isEmpty() {
        // TODO: implement isEmpty
        return true;
    }

    /**
     * Remove the element from position index in the list
     *
     * TODO: javadoc comments
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        // TODO: Fill in implementation
        return null;
    }

    /**
     * Set the value of an element at a certain index in the list.
     *
     * TODO: javadoc comments
     */
    @Override
    public T set(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        // TODO: Fill in implmentation
        return null;
    }

    /**
     * Retrieves the amount of elements that are currently on the list.
     *
     * TODO: javadoc comments
     */
    @Override
    public int size() {
        // TODO: complete implementation
        return 0;
    }

    /**
     * String representation of this list in the form of:
     * "[(head) -> elem1 -> elem2 -> ... -> elemN -> (tail)]"
     *
     * TODO: javadoc comments
     */
    @Override
    public String toString() {
        return null;
    }

    /* ==================== EXTRA CREDIT ==================== */

    /**
     * Remove nodes whose index is a multiple of base
     *
     * TODO: javadoc comments
     */
    public void removeMultipleOf(int base) {
        // TODO: complete implementation       
    }

    /**
     * Swap the nodes between index [0, splitIndex] of two lists
     *
     * TODO: javadoc comments
     */
    public void swapSegment(DoublyLinkedList other, int splitIndex) {
        // TODO: complete implementation
    }

}