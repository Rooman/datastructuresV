package com.bondarenko.datastructures.queue;

public class ArrayQueueTest<T> extends AbstractQueueTest<T> {
    @Override
    protected Queue<T> getQueue() {
        return new ArrayQueue();
    }
}