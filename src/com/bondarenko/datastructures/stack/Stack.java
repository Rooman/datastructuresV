package com.bondarenko.datastructures.stack;

//LIFO "Last in first out"
public interface Stack<T> {
    //исключение-EmptyStackException
    //помещает объект в стек
    void push(T value);

    //вытаскивает объект из стека
    T pop();

    // последний в стеке
    T peek();

    int size();

    boolean isEmpty();
}
