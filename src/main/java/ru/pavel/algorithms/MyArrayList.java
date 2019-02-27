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
            array2 = null;
        }
    }

    public void add(int index, T item) {
        if(outOfBounds(index)) {
            array2 = new Object[array.length + 1];
            System.arraycopy(array, 0 , array2, 0, index - 1);
            array2[index] = item;
            System.arraycopy(array, index, array2, index + 1, array.length - index);
            array = new Object[array.length + 1];
            System.arraycopy(array2, 0, array, 0, array.length);
            array2 = null;
        } else {
            throw new IndexOutOfBoundsException("out of bounds");
        }
    }

    public void set(int index, T item) {
        if(outOfBounds(index)) {
            array[index] = item;
        } else {
            throw new IndexOutOfBoundsException("out of bounds");
        }
    }

    public void delete(int index) {
        if(outOfBounds(index)) {
            array2 = new Object[array.length];
            System.arraycopy(array, 0, array2, 0 , index);
            System.arraycopy(array, index + 1, array2, index, array.length - index);
            System.arraycopy(array2, 0, array, 0, array.length);
            array2 = null;
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
