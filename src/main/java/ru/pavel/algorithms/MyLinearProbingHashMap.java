package ru.pavel.algorithms;

public class MyLinearProbingHashMap<T, V> {
    private final int M = 97;
    private int size = 0;
    //make stretching list
    private Object[] keys = new Object[M];
    private Object[] values = new Object[M];

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(T key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public V get(T key) {
        if (key == null) {
            throw new IllegalArgumentException("Key can't be null");
        }
        for (int i = hash(key); keys[i] != null ; i = (i + 1) % M) {
            if (((T) keys[i]).equals(key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    public boolean contains(T key) {
        return get(key) != null;
    }

    public void put(T key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key can't be null");
        }
        if (size == M - 1) {
            throw new IndexOutOfBoundsException("Most county of items in collection is reached");
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if(((T) keys[i]).equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    public V remove(T key) {
        if (key == null) {
            throw new IllegalArgumentException("Key can't be null");
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if(((T) keys[i]).equals(key)) {
                keys[i] = null;
                return (V) values[i];
            }
        }
        return null;
    }
}
