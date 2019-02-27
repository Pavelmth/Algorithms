package ru.pavel.algorithms;

public class MyArrayList<T> {
    private Object[] array = new Object[10];
    private Object[] array2;
    private int last = 0;

    public void MyArrayList (T object) {

    }

    public void add(T item) {
        if(outOfBounds(last)) {
            array[last] = item;
            last++;
        } else {
            array2 = new Object[last*2];
            System.arraycopy(array, 0 , array2, 0, array.length);
        }
    }

    public void add(int index, T item) {
        if(outOfBounds(index)) {
            //copy
            array[index] = item;
            //create
        } else {
            throw new IndexOutOfBoundsException("out of bounds");
        }
    }

    public void set(int index, T item) {
        if(outOfBounds(index)) {
            //copy
            array[index] = item;
            //create
        } else {
            throw new IndexOutOfBoundsException("out of bounds");
        }
    }

    public void delete(int index) {
        if(outOfBounds(index)) {

        } else {
            throw new IndexOutOfBoundsException("out of bounds");
        }
    }

    public T get(int index) {
        if(outOfBounds(index)) {
            return (T) array[index];
        } else {
            throw new IndexOutOfBoundsException("out of bounds");
        }
    }

    public int length() {
        return array.length;
    }

    private boolean outOfBounds(int index) {
        if (index < 0) {
            return false;
        }
        if (index < array.length) {
            return true;
        } else {
            return false;
        }
    }
}
