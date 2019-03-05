package ru.pavel.algorithms;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    private int cap = 1;
    private Object[] array = new Object[cap];
    private int size = 0;
    private int start = 0;
    private int end = 0;

    public MyQueue() {

    }

    public MyQueue(int capacity) {
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
        for (int i = 0; i < size; i++) {
            arr[i] = array[(start + i) % array.length];
        }
        this.array = arr;
        start = 0;
        end = size;
    }

    public void push(T item) {
        if(size == array.length) {
            resize(2 * array.length);
        }
        array[end++] = item;
        end %= array.length;
        size++;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack is queue");
        return (T) array[start];
    }

    public T poll() {
        if (isEmpty()) throw new NoSuchElementException("Stack is queue");
        T item = (T) array[start];
        size--;
        start++;
        start %= array.length;
        if (size == array.length / 4 && size > 0) resize(array.length / 2);
        return item;
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            strb.append(((T) array[(start + i) % array.length]).toString());
            if (i != size - 1) strb.append(", ");
        }
        return strb.toString();
    }
}
