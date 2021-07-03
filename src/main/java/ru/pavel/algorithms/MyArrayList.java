package ru.pavel.algorithms;

public class MyArrayList<T> {
    private int cap = 1;
    private Object[] array = new Object[cap];
    private int size = 0;

    public MyArrayList() {
    }

    public MyArrayList(int cap) {
        this.cap = cap;
    }

    public void resize(int last) {
        Object[] arrayTemp = new Object[last*2];
        System.arraycopy(array, 0, arrayTemp, 0, array.length);
        array = arrayTemp;
        arrayTemp = null;
    }

    private boolean outOfBounds(int index) {
        if (index < 0) {
            return true;
        } else if (index > array.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean add (T item) {
        if(outOfBounds(size + 1)) resize(array.length);
        array[size++] = item;
        return true;
    }

    public boolean add(int index, T item) {
        if(outOfBounds(size + 1)) resize(array.length);
        if(outOfBounds(index) || (index > (size - 1))) throw new IndexOutOfBoundsException("out of bounds");
        Object[] arrayTemp = new Object[array.length];
        System.arraycopy(array, 0, arrayTemp, 0, index);
        arrayTemp[index] = item;
        System.arraycopy(array, index, arrayTemp, index + 1, array.length - index -1);
        array = arrayTemp;
        size++;
        return true;
    }

    public boolean set(int index, T item) {
        if(outOfBounds(index)) throw new IndexOutOfBoundsException("out of bounds");
        array[index] = item;
        return true;
    }

    public boolean delete(int index) {
        if (outOfBounds(index)) throw new IndexOutOfBoundsException("out of bounds");
        if (isEmpty()) {System.out.println("Array is empty");}
        Object[] arrayTemp = new Object[array.length];
        System.arraycopy(array, 0, arrayTemp, 0, index);
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        array = arrayTemp;
        size--;
        return true;
    }

    public T get (int index) {
        if(outOfBounds(index)) throw new IndexOutOfBoundsException("out of bounds");
        return (T) array[index];
    }

    // new methods

    public int length() {
        return size;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(array[i] + ", ");
        }
        return stringBuilder.toString();
    }

    public void sortInsert(){
        int in, out;
        for(out = 1;out < this.size; out++){
            int temp = (int) this.array[out];
            in = out;
            while(in > 0 && (int) this.array[in-1] >= temp){
                this.array[in] = this.array[in-1];
                --in;
            }
            this.array[in] = temp;
        }
    }


    public void sortSelect() {
        int out, in, mark;
        for (out = 0; out < this.size; out++) {
            mark = out;
            for(in = out + 1; in < this.size; in++) {
                if ((int) this.array[in] < (int) this.array[mark]) {
                    mark = in;
                }
            }
            change(out, mark);
        }
    }

    public void sortBubble() {
        int out, in;
        for (out = this.size - 1; out >= 1; out--) {
            for (in = 0; in < out; in++) {
                if ((int) this.array[in] > (int) this.array[in + 1]) {
                    change(in, in + 1);
                }
            }
        }
    }

    private void change(int a, int b) {
        int tmp = (int) this.array[a];
        this.array[a] = this.array[b];
        this.array[b] = tmp;
    }
}

