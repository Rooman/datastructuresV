package com.bondarenko.datastructures.list;

import java.util.Objects;

public  class ArrayList<T> extends AbstractList<T> {

    private static final int INITIAL_CAPACITY = 5;
    private T[] array;

    public ArrayList() {
        this(INITIAL_CAPACITY);
    }

    private ArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value, int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " should be between 0 and " + size + " inclusive");
        }
        if (size == array.length) {
            T[] newArray = (T[]) new Object[(int) (array.length * (1.5)+1)];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    @Override
    public T remove(int index) {
        validateIndex(index);
        T valueToRemove = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;

        return valueToRemove;
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public T set(T value, int index) {
        validateIndex(index);
        T oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(value, array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(value, array[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += String.valueOf(array[i]);
            if (i < size - 1) {
                result += ",";
            }
        }
        result += "]";
        return result;
    }
}
