package com.bondarenko.datastructures.stack;

import java.util.NoSuchElementException;


public abstract class AbstractStack<T> implements Stack<T> {
    protected int size;

    protected void validateSize() {
        if (size == 0) {
            throw new NoSuchElementException(" The stack is empty");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
