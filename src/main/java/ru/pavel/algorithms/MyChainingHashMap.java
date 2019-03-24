package ru.pavel.algorithms;

public class MyChainingHashMap<T, V> {
    private int M = 97;
    private int size = 0;
    private Object[] st = new Object[M];
    private class Node {
        T key;
        V value;
        Node next;
        Node previous;

        public Node(T key, V value, Node next, Node previous) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

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
        int i = hash(key);
        Node x = (Node) st[i];
        while (x!= null) {
            if (key.equals(x.key)) {
                return x.value;
            }
            x = x.next;
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
        int i = hash(key);
        Node x = (Node) st[i];
        while (x != null) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
            x = x.next;
        }
        st[i] = new Node(key, value, (Node) st[i], (Node) st[i]);
        size++;
    }

    public V remove(T key) {
        if (key == null) {
            throw new IllegalArgumentException("Key can't be null");
        }
        int i = hash(key);
        Node x = (Node) st[i];
        V value;
        while (x != null) {
            if (key.equals(x.key)) {
                value = x.value;
                st[i] = x.next;
                size--;
                return value;
            }
            x = x.next;
        }
        return null;
    }
}
