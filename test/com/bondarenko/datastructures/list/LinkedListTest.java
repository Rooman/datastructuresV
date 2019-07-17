package com.bondarenko.datastructures.list;

public class LinkedListTest<T> extends AbstractListTest<T> {

    @Override
    protected List<T> getList(){
        return new LinkedList();
    }
}
