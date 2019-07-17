package com.bondarenko.datastructures.stack;

public class LinkedStack<T> extends AbstractStack<T> {
    private Node<T> tail;

    private static class Node<T> {
        private Node<T> prev;
        private T value;

        Node(T value) {
            this.value = value;
        }
    }

    @Override
    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        if (size != 0) {
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    @Override
    public T pop() {
       validateSize();
        T result = tail.value;
        tail = tail.prev;
        size--;
        return result;
    }

    @Override
    public T peek() {
        T result = tail.value;
        return result;
    }

}

