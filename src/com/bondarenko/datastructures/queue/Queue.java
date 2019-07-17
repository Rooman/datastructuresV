package com.bondarenko.datastructures.queue;
//FIFO ("First in first out")

public interface Queue<T> {
    //Добавление элемента в конец очереди
    void enqueue(T value);

    //удаляем  элемент из очереди
    T dequeue();

    //возвращает без удаления элемент из начала очереди
    T peek();

    int size();

}