package com.bondarenko.datastructures.list;

public class ArrayListTest<T> extends AbstractListTest<T> {

    @Override
    protected List<T> getList() {
        return new ArrayList();
    }
}



