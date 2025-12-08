package com.matteofuso.adt;

public class List<T> extends ADT {
    public List() {
        this.elements = (T[]) new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    private void resize(int size){
        if (size < 1) {
            throw new IllegalArgumentException();
        }
        T[] newElements = (T[]) new Object[size];
        System.arraycopy(this.elements, 0, newElements, 0, Math.min(this.size, size));
        this.elements = newElements;
    }

    public void add(T element) {
        if (this.size == this.elements.length) {
            resize(this.elements.length * 2);
        }
        this.elements[this.size++] = element;
    }

    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (this.size == this.elements.length) {
            resize(this.elements.length * 2);
        }
        System.arraycopy(this.elements, index, this.elements, index + 1, this.size - index);
        this.elements[index] = element;
        this.size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    public T get() {
        return get(this.size - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void empty() {
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    final int INITIAL_CAPACITY = 8;
    T[] elements;
    int size;
}
