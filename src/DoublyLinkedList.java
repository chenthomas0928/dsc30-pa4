/*
 * NAME: Thomas Chen
 * PID: A15636810
 */

import java.util.AbstractList;

/**
 *
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

        }

        /**
         * Constructor to create singleton link it between previous and next
         *
         * @param element  Element to add, can be null
         * @param nextNode successor Node, can be null
         * @param prevNode predecessor Node, can be null
         */
        private Node(T element, Node nextNode, Node prevNode) {

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

            this.data = element;
        }

        /**
         * Accessor to get the Nodes Element
         */
        public T getElement() {

            return this.data;
        }

        /**
         * Set the next node in the list
         *
         * @param n new next node
         */
        public void setNext(Node n) {

            this.next = n;
        }

        /**
         * Get the next node in the list
         *
         * @return the successor node
         */
        public Node getNext() {

            return this.next;
        }

        /**
         * Set the previous node in the list
         *
         * @param p new previous node
         */
        public void setPrev(Node p) {

            this.prev = p;
        }


        /**
         * Accessor to get the prev Node in the list
         *
         * @return predecessor node
         */
        public Node getPrev() {

            return this.prev;
        }

        /**
         * Remove this node from the list.
         * Update previous and next nodes
         */
        public void remove() {

            this.getPrev().setNext(this.getNext());
            this.getNext().setPrev(this.getPrev());
        }
    }

    /**
     * Creates a new, empty doubly-linked list.
     */
    public DoublyLinkedList() {


        this.head = new Node(null);
        this.tail = new Node(null);
        head.setNext(tail);
        tail.setPrev(head);
        this.nelems = 0;

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
        // implementation of adding the new data
        Node newNode = new Node(element);
        this.tail.getPrev().setNext(newNode);
        newNode.setPrev(this.tail.getPrev());
        newNode.setNext(this.tail);
        this.tail.setPrev(newNode);
        this.nelems++;
        return true;
    }


    /**
     * Adds an element to a certain index in the list, shifting exist elements
     * create room. Does not accept null values.
     *
     *
     * @param index of the position data is added
     * @param element data to be added
     * @throws IndexOutOfBoundsException if index is out of bound
     * @throws NullPointerException if data received is null
     */
    @Override
    public void add(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
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
        this.nelems++;
    }

    /**
     * Clear the linked list
     */
    @Override
    public void clear() {
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
        this.nelems = 0;
    }

    /**
     * Determine if the list contains the data element anywhere in the list.
     *
     *
     * @param element the data element that is checked
     * @return whether or not the list contains the data element
     */
    @Override
    public boolean contains(Object element) {
        T data = (T)element;
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
     *
     * @param index of the element in the list
     * @return data of the element at input index
     * @throws IndexOutOfBoundsException if the index is out of bound
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {

        if (index > this.nelems) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = this.head;
        for (int i = 0; i <= index; i++) {
            temp = temp.getNext();
        }
        return temp.data;
    }

    /**
     * Helper method to get the Nth node in our list
     *
     *
     * @param index of the element in the list
     * @return Node at input index
     * @throws IndexOutOfBoundsException if the index is out of bound
     */
    private Node getNth(int index) {

        if (index > this.nelems) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = this.head;
        for (int i = 0; i <= index; i++) {
            temp = temp.getNext();
        }

        return temp;
    }

    /**
     * Determine if the list empty
     *
     *
     * @return if the list is empty or not
     */
    @Override
    public boolean isEmpty() {

        if (this.nelems == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Remove the element from position index in the list
     *
     *
     * @param index the position of the element
     * @return data of the element that is removed
     * @throws IndexOutOfBoundsException if index is out of bound
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {

        if (index > this.nelems) {
            throw new IndexOutOfBoundsException();
        }
        Node temp = this.head;
        for (int i = 0; i <= index; i++) {
            temp = temp.getNext();
        }
        temp.getPrev().setNext(temp.getNext());
        temp.getNext().setPrev(temp.getPrev());
        this.nelems--;
        return temp.data;
    }

    /**
     * Set the value of an element at a certain index in the list.
     *
     *
     * @param index of the element that is reset
     * @param element the new element of the data
     * @return original element of the data
     * @throws IndexOutOfBoundsException if index is out of bound
     * @throws NullPointerException if data received is null
     */
    @Override
    public T set(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {

        if (index > this.nelems) {
            throw new IndexOutOfBoundsException();
        }
        if (element == null) {
            throw new NullPointerException();
        }
        Node temp = this.head;
        for (int i = 0; i <= index; i++) {
            temp = temp.getNext();
        }
        T original = temp.data;
        temp.data = element;
        return original;
    }

    /**
     * Retrieves the amount of elements that are currently on the list.
     *
     *
     * @return the size of the list
     */
    @Override
    public int size() {

        return this.nelems;
    }

    /**
     * String representation of this list in the form of:
     * "[(head) -> elem1 -> elem2 -> ... -> elemN -> (tail)]"
     *
     *
     * @return elements in the list in special string format
     */
    @Override
    public String toString() {
        String result = "[(head) -> ";
        Node temp = this.head;
        for (int i = 0; i < this.nelems; i++) {
            temp = temp.getNext();
            result += temp.getElement() + " -> ";
        }
        result += "(tail)]";
        return result;
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