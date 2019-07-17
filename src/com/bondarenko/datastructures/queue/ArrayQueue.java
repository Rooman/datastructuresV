package com.bondarenko.datastructures.queue;


public class ArrayQueue<T> extends AbstractQueue<T> {

    private static final int INITIAL_CAPACITY = 5;
    private T[] array;

    public ArrayQueue() {
        this(INITIAL_CAPACITY);
    }

    private ArrayQueue(int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public void enqueue(T value) {
        if (size == array.length) {
            T[] newArray = (T[]) new Object[(int) (array.length * 1.5+1)];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size] = value;
        size++;
    }

    public T dequeue() {
        validateSize();
        T result = array[0];
        System.arraycopy(array, 1, array, 0, array.length - 1);
        array[size - 1] = null;
        size--;
        return result;
    }

    public T peek() {
        validateSize();
        return array[0];
    }

}
