package ru.pavel.algorithms;

import java.util.NoSuchElementException;

public class MyStack<T> {
    int cap = 1;
    private Object[] array = new Object[cap];
    private int size = 0;

    public MyStack() {

    }

    public MyStack(int capacity) {
        this.cap = capacity;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        Object[] arr = new Object[capacity];
        System.arraycopy(this.array, 0, arr,0, this.size());
        this.array = arr;
    }

    public void push(T item) {
        if(size == array.length) {
            resize(2 * array.length);
        }
        array[size++] = item;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return (T) array[size - 1];
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        T item = (T) array[size - 1];
        size--;
        if (size == array.length / 4 && size > 0) resize(array.length / 2);
        return item;
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            strb.append(((T) array[i]).toString());
            if (i != 0) strb.append(", ");
        }
        return strb.toString();
    }
}
