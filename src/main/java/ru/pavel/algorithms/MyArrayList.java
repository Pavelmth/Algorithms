package ru.pavel.algorithms;

public class MyArrayList<T> {
    private Object[] array = new Object[10];
    private Object[] array2;
    private int last = 0;

    public boolean add (T item) {
        if(outOfBounds(last)) {
            array[last] = item;
            if (array.length == last + 1) {
                array2 = new Object[last*2];
                System.arraycopy(array, 0 , array2, 0, array.length);
                array = new Object[last*2];
                System.arraycopy(array2, 0 , array, 0, last);
                array2 = null;
            }
            last++;
            return true;
        } else {
            array2 = new Object[last*2];
            System.arraycopy(array, 0 , array2, 0, array.length);
            array2[last + 1] = item;
            array = new Object[last*2];
            System.arraycopy(array2, 0 , array, 0, last);
            array2 = null;
            return true;
        }
    }

    public boolean add(int index, T item) {
        if(outOfBounds(index)) {
            if (last == array.length) {
                array2 = new Object[last*2];
                System.arraycopy(array, 0 , array2, 0, array.length);
                array = new Object[last*2];
                System.arraycopy(array2, 0 , array, 0, last);
                array2 = null;
            }
            if (index == 0) {
                array2 = new Object[array.length];
                System.arraycopy(array, 1 , array2, 1, last - 1);
                array2[0] = item;
                System.arraycopy(array2, 0, array, 0, array.length);
                array2 = null;
                last++;
                return true;
            } else if (index == last) {
                array2 = new Object[array.length];
                System.arraycopy(array, 0 , array2, 0, last - 1);
                array2[last] = item;
                System.arraycopy(array2, 0, array, 0, array.length);
                array2 = null;
                last++;
                return true;
            } else {
                array2 = new Object[array.length];
                System.arraycopy(array, 0 , array2, 0, index - 1);
                array2[index] = item;
                System.arraycopy(array, index, array2, index + 1, array.length - index - 1);
                System.arraycopy(array2, 0, array, 0, array.length);
                array2 = null;
                last++;
                return true;
            }
        } else {
            throw new IndexOutOfBoundsException("out of bounds");
        }
    }

    public boolean set(int index, T item) {
        if(outOfBounds(index)) {
            array[index] = item;
            return true;
        } else {
            throw new IndexOutOfBoundsException("out of bounds");
        }
    }

    public boolean delete(int index) {
        if(outOfBounds(index)) {
            array2 = new Object[array.length];
            System.arraycopy(array, 0, array2, 0, index);
            System.arraycopy(array, index + 1, array2, index, array.length - 1);
            System.arraycopy(array2, 0, array, 0, array.length);
            last--;
            array2 = null;
            return true;
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
        return last;
    }

    public boolean sort() {
        return true;
    }

    private boolean outOfBounds(int index) {
        if (index < 0) {
            return false;
        }
        if (index <= last) {
            return true;
        } else {
            return false;
        }
    }
}
