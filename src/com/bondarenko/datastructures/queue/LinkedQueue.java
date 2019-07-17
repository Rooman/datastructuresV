package com.bondarenko.datastructures.queue;

public class LinkedQueue<T> extends AbstractQueue<T> {

    private Node<T> head;
    private Node<T> tail;

    private static class Node<T> {
        private Node<T> next;
        private T value;

        Node(T value) {
            this.value = value;
        }
    }

    public void enqueue(T value) {

        Node<T> node = new Node<>(value);
        if (size == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T dequeue() {
        validateSize();
        T result = head.value;
        head = head.next;
        size--;
        return result;
    }

    public T peek() {
        validateSize();
        return head.value;
    }
}
