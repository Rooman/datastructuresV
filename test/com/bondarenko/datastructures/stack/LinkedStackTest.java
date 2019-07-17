package com.bondarenko.datastructures.stack;

public class LinkedStackTest<T> extends AbstractStackTest<T> {

    @Override
    protected Stack<T> getStack() {
        return new LinkedStack();
    }
}