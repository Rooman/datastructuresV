package com.bondarenko.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public abstract class AbstractListTest<T> {

    List<Integer> list;

    @Before
    public void before() {
        list = getList();
    }

    protected abstract List getList();

    @Test
    public void testAdd() {
        for (int i = 0; i < 1; i++) {
            list.add(i);
        }
        list.add(1);
//        list.add(7);
//        list.add(8);
        assertEquals(2, list.size());
        for (int i = 0; i < 1; i++) {
            assertEquals(i, list.get(i));
        }
    }

    @Test
    public void testAddIndex() {
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }

        list.add(5, 3);
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(5, list.get(3));
        assertEquals(4, list.size());
    }

    @Test
    public void testAddIndexFirst() {
        for (int i = 0; i < 3; i++) {
            list.add(i);
        }

        list.add(8, 0);
        assertEquals(8, list.get(0));
        assertEquals(0, list.get(1));
        assertEquals(1, list.get(2));
        assertEquals(2, list.get(3));
        assertEquals(4, list.size());
    }

    @Test
    public void testRemove() {
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertEquals(5, list.size());

        Object removed = list.remove(1);
        assertEquals(4, list.size());
        assertEquals(0, list.get(0));
        assertEquals(1, removed);
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
        assertEquals(4, list.get(3));
    }

    @Test
    public void testSetFirst() {
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.set(8, 0);
        assertEquals(8, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(5, list.size());
    }

    @Test
    public void testClear() {
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testIsEmpty() {

        list.add(3);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testContainsTrue() {
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertTrue(list.contains(4));
    }

    @Test
    public void testContainsFalse() {
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertFalse(list.contains(102));
    }

    @Test
    public void testIndexOfForOneElement() {
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertEquals(2, list.indexOf(2));
    }

    @Test
    public void testIndexOfNotExist() {

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertEquals(-1, list.indexOf(222));
    }

    @Test
    public void testIndexOfNull() {
        list.add(1);
        list.add(null);
        list.add(2);
        list.add(null);
        list.add(3);
        assertEquals(1, list.indexOf(null));
    }

    @Test
    public void testLastIndexOf() {

        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        assertEquals(3, list.lastIndexOf(2));
    }
    @Test
    public void testLastIndexOfNull() {

        list.add(1);
        list.add(1);
        list.add(2);
        list.add(null);
        list.add(3);
        assertEquals(3, list.lastIndexOf(null));
    }


    @Test
    public void testLastIndexOfNotExist() {

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        assertEquals(-1, list.lastIndexOf(100));
    }

    @Test
    public void testToString() {

        list.add(1);
        list.add(null);
        list.add(3);
        list.add(4);
        list.add(4);

        assertEquals("[1,null,3,4,4]", list.toString());
    }

}
