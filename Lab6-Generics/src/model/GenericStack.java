package model;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class GenericStack<T> {
    private List<T> elements;

    public GenericStack() {
        elements = new ArrayList<>();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void push(T element) {
        elements.add(element);
    }
    public T pop() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Stack is empty!");
        }
        return elements.remove(elements.size() - 1);
    }
    public T peek() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Stack is empty!");
        }
        return elements.get(elements.size() - 1);
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
