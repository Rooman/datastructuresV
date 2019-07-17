package com.bondarenko.datastructures.list;


public abstract class AbstractList<T> implements List<T> {
    protected int size;

    protected void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is incorrect" + index + " should be between" + 0 + "and " + size + " inclusive");
        }
    }

    public void add(T value) {
        add(value, size);
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object value) {
        return indexOf((T) value) > 0;
    }
}