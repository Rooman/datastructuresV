package com.bondarenko.datastructures.queue;

public class LinkedQueueTest<T> extends AbstractQueueTest<T> {
    @Override
    protected Queue<T> getQueue() {
        return  new LinkedQueue();
    }
}