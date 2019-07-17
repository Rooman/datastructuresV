package com.bondarenko.datastructures.stack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public abstract class AbstractStackTest<T> {


    Stack<String> stack;
    @Before
    public void before() {
        stack = getStack();
    }

    protected abstract Stack getStack();

    @Test
    public void testPushAndPop() {

        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");

        assertEquals(4, stack.size());
        assertEquals("D", stack.pop());
        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
        assertEquals(0, stack.size());

    }
    @Test
    public void testIsEmpty() {

        stack.push("A");
        stack.push("B");
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPushAndPeek() {

        stack.push("A");
        stack.push("B");
        stack.push("D");
        assertEquals(3, stack.size());
        assertEquals("D", stack.peek());
        assertEquals("D", stack.pop());
        assertEquals("B", stack.peek());
        assertEquals(2, stack.size());

    }
}