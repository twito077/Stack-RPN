package demo;

public class Stack {
    private String[] elements;
    private int size;

    public Stack() {
        elements = new String[10];
        size = 0;
    }

    public void push(String element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot pop from an empty stack");
        }
        String topElement = elements[--size];
        elements[size] = null; // Avoid memory leaks
        return topElement;
    }

    public String peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot peek on an empty stack");
        }
        return elements[size - 1];
    }

    private void resize() {
        String[] newElements = new String[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}