package ru.pavel.algorithms;

public class MyDeque<T> {
    private Object[] array = new Object[1];
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void resize(int capacity) {
        Object[] arr = new Object[capacity];
        System.arraycopy(this.array, 0, arr,0, this.size());
        this.array = arr;
    }

}
