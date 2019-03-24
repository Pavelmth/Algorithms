package ru.pavel.algorithms;

public class MyLinearProbingHashMap<T, V> {
    private int M = 5;
    private int size = 0;
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

        int k;

        int mt = (int) (M * 0.7);
        if (mt < size) {
            mt = (int) (M * 1.5);
            Object[] keysT = new Object[(int) (mt)];
            Object[] valuesT = new Object[(int) (mt)];
            for (int j = 0; j < keys.length; j++) {
                if (keys[j] != null) {
                    k = hash((T) keys[j]);
                    keysT[k] = keys[j];
                    valuesT[k] = values[j];
                }
            }

            keys = keysT;
            values = valuesT;
            M = mt;
        }
    }

    public V remove(T key) {
        V valueT;

        if (key == null) {
            throw new IllegalArgumentException("Key can't be null");
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if(((T) keys[i]).equals(key)) {
                keys[i] = null;
                size--;
                valueT = (V) values[i];

                int k;
                if (size < (M / 2)) {
                    Object[] keysT = new Object[(int) (M * 0.7)];
                    Object[] valuesT = new Object[(int) (M * 0.7)];
                    for (int j = 0; j < keys.length; j++) {
                        if (keys[j] != null) {
                            k = hash((T) keys[j]);
                            keysT[k] = keys[j];
                            valuesT[k] = values[j];
                        }
                    }

                    keys = keysT;
                    values = valuesT;
                    M = (int) (M * 0.7);
                }

                return valueT;
            }
        }

        return null;
    }
}
