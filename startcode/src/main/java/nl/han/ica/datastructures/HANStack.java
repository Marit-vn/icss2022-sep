package nl.han.ica.datastructures;

public class HANStack<T> implements IHANStack<T> {

    private HANLinkedList<T> list;

    public HANStack() {
        this.list = new HANLinkedList<>();
    }

    @Override
    public void push(T value) {
        // Push adds the value to the front of the list
        list.addFirst(value);
    }

    @Override
    public T pop() {
        // Pop removes and returns the top element of the stack
        T value = list.getFirst(); // Get the first element (top of the stack)
        list.removeFirst(); // Remove it from the list
        return value;
    }

    @Override
    public T peek() {
        // Peek returns the top element without removing it
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.getSize() == 0;
    }

    public int getSize() {
        return list.getSize();
    }
}
