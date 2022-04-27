/*
 * NAME: Thomas Chen
 * PID: A15636810
 */

/**
 *
 * @param <T> generic container
 * @author Thomas Chen
 * @since 1.8
 */
public class DLLStack<T> {

    private DoublyLinkedList<T> stack;

    public DLLStack() {

        this.stack = new DoublyLinkedList<>();
    }

    public int size() {

        return this.stack.size();
    }

    public boolean isEmpty() {

        if (this.stack.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void push(T data) {

        if (data == null) {
            throw new IllegalArgumentException();
        }
        else {
            this.stack.add(data);
        }
    }

    public T pop() {

        if (this.stack.size() == 0) {
            return null;
        }
        T temp = this.stack.get(this.stack.size() - 1);
        this.stack.remove(this.stack.size() - 1);
        return temp;
    }

    public T peek() {

        if (this.stack.size() == 0) {
            return null;
        }
        return this.stack.get(this.stack.size() - 1);
    }

}
