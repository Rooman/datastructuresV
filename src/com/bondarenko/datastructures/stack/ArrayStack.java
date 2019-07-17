package com.bondarenko.datastructures.stack;

public class ArrayStack<T> extends AbstractStack<T> {
    private static final int INITIAL_CAPACITY = 4;
    private T[] array;

    public ArrayStack() {
        this(INITIAL_CAPACITY);
    }

    private ArrayStack(int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public void push(T value) {
        if (size == array.length) {
            T[] newArray = (T[]) new Object[(int) (array.length * 1.5+1)];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = value;
        size++;
    }

    @Override
    public T pop() {
        validateSize();
        T element = array[size - 1];
        array[size - 1] = null;
        size--;
        return element;
    }

    @Override
    public T peek() {
        validateSize();
        return array[size - 1];
    }
}

