package com.bondarenko.datastructures.queue;

import java.util.NoSuchElementException;

public abstract class AbstractQueue<T> implements Queue<T> {
    protected int size;

    protected void validateSize() {
        if (size == 0) {
            throw new NoSuchElementException("The queue is empty");
        }
    }

    @Override
    public int size() {
        return size;
    }

}

