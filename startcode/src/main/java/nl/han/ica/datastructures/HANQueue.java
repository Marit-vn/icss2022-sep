package nl.han.ica.datastructures;

public class HANQueue<T> implements IHANQueue<T> {

    private HANLinkedList<T> list;  // Linked list to store elements of the queue

    public HANQueue() {
        list = new HANLinkedList<>();  // Initialize the linked list
    }

    @Override
    public void clear() {
        list.clear();  // Clears the underlying linked list
    }

    @Override
    public boolean isEmpty() {
        return list.getSize() == 0;  // Queue is empty if linked list size is 0
    }

    @Override
    public void enqueue(T value) {
        list.insert(list.getSize(), value);  // Adds to the end (back) of the list
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T value = list.getFirst();  // Get the first (front) element
        list.removeFirst();         // Remove the front element
        return value;               // Return the dequeued value
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();  // Return the first (front) element without removing it
    }

    @Override
    public int getSize() {
        return list.getSize();  // Returns the size of the queue (same as the linked list size)
    }
}
