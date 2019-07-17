package com.bondarenko.datastructures.queue;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public abstract class AbstractQueueTest<T> {

    Queue<String> queue;

    @Before
    public void before() {
        queue = getQueue();
    }

    protected abstract Queue getQueue();

    @Test
    public void testEnqueueAndDequeue() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        assertEquals(3, queue.size());
        assertEquals("A", queue.dequeue());
        assertEquals(2, queue.size());
    }

    @Test
    public void testDequeueAndPeek() {
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");

        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.peek());
        assertEquals("B", queue.dequeue());
        assertEquals("C", queue.peek());
    }
}