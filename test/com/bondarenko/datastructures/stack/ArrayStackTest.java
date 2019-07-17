package com.bondarenko.datastructures.stack;

public class ArrayStackTest<T> extends AbstractStackTest<T> {

    @Override
    protected Stack<T> getStack() {
        return new ArrayStack();
    }
}