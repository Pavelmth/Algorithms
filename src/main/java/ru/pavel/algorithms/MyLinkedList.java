package ru.pavel.algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    private class Node {
        T item;
        Node next;
        Node previous;

        public Node(Node previous, T item, Node next) {
            this.previous = previous;
            this.item = item;
            this.next = next;
        }
    }

    private Node first = null;
    private Node last = null;
    private int size = 0;

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    private class MyLinkedListIterator implements Iterator<T> {

        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T getFirst() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        return first.item;
    }

    public void addFirst(T item) {
        Node oldFirst = first;
        first = new Node(null, item, oldFirst);
        if (isEmpty()) {
            last = first;
        } else {
            oldFirst.previous = first;
        }
        size++;
    }

    public T removeFirst() {
        if(isEmpty()) throw new NoSuchElementException("List is empty");
        Node second = first.next;
        T item = first.item;
        first = second;
        size--;
        if (isEmpty()) {
            last = null;
        } else {
            second.previous = null;
        }
        return item;
    }

    public T getLast() {
        if (isEmpty()) throw new NoSuchElementException("List is empty");
        return last.item;
    }

    public void addLast(T item) {
        Node oldLast = last;
        last = new Node(oldLast, item, null);
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public T removeLast() {
        if(isEmpty()) throw new NoSuchElementException("List is empty");
        T item = last.item;
        Node previois = last.previous;
        last = previois;
        size--;
        if (isEmpty()) {
            first = null;
        } else {
            last.next = null;
        }
        return item;
    }

    public T get(int index) {
        if(index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (index < (size / 2)) {
            int currentIndex = 0;
            Node current = first;
            while (currentIndex < index) {
                current = current.next;
                currentIndex++;
            }
            return current.item;
        } else {
            int currentIndex = size - 1;
            Node current = last;
            while (currentIndex > index) {
                current = current.previous;
                currentIndex--;
            }
            return current.item;
        }
    }

    public void set(int index, T item) {
        if(index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        int currentIndex = 0;
        Node current = first;
        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        current.item = item;
    }

    public int indexOf(T item) {
        Node current = first;
        int currentIndex = 0;
        while (current != null && !current.item.equals(item)) {
            current = current.next;
            currentIndex++;
        }
        return current != null ? currentIndex : -1;
    }

    public boolean contains(T item) {
        return indexOf(item) > -1;
    }

    public boolean remove(T item) {
        Node current = first;
        while (current != null && !current.item.equals(item)) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if (current == first) {
            return true;
        }
        if (current == last) {
            return true;
        }
        Node next = current.next;
        Node previous = current.previous;
        previous.next = next;
        next.previous = previous;
        size--;
        current.previous = null;
        current.next = null;
        current.item = null;
        return true;
    }

    public void add(int index, T item) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(item);
            return;
        } else if (index == size) {
            addLast(item);
            return;
        }

        int currentIndex = 0;
        Node current = first;
        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        Node newNode = new Node(current.previous, item, current);
        current.previous.next = newNode;
        current.previous = newNode;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node current = first;
        while (current != null) {
            stringBuilder.append(current.item.toString());
            if(current.next != null) stringBuilder.append(", ");
            current = current.next;
        }
        return stringBuilder.toString();
    }
}
