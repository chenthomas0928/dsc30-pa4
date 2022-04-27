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
public class DLLQueue<T> {

    private DoublyLinkedList<T> queue;

    public DLLQueue() {

        this.queue = new DoublyLinkedList<>();
    }

    public int size() {

        return this.queue.size();
    }

    public boolean isEmpty() {

        if (this.queue.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void enqueue(T data) {

        if (data == null) {
            throw new IllegalArgumentException();
        }
        else {
            this.queue.add(data);
        }
    }

    public T dequeue() {

        if (this.queue.size() == 0) {
            return null;
        }
        T temp = this.queue.get(0);
        this.queue.remove(0);
        return temp;
    }

    public T peek() {

        if (this.queue.size() == 0) {
            return null;
        }

        return this.queue.get(0);
    }

}
