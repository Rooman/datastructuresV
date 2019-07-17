package com.bondarenko.datastructures.list;

import java.util.Objects;

public class LinkedList<T> extends AbstractList<T> {

    private Node<T> head;
    private Node<T> tail;

    private static class Node<T> {
        private Node<T> next;
        private Node<T> prev;
        private T value;

        Node(T value) {
            this.value = value;
        }
    }

    @Override
    public void add(T value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " should be between 0 and " + size + " inclusive");
        }
        Node<T> node = new Node<>(value);
        if (size == 0) {
            head = tail = node;
        } else if (index == 0) {
            head.prev = node;
            node.next = head;
            head = node;
        } else if (index == size) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        } else {
            Node<T> currentNode = getNode(index);
            node.prev = currentNode.prev;
            currentNode.prev.next = node;
            node.next = currentNode;
            currentNode.prev = node;
        }
        size++;
    }

    private Node<T> getNode(int index) {

        if (index < size / 2) {
            Node<T> currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode;

        } else {
            Node<T> currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
            return currentNode;
        }
    }

    @Override
    public T remove(int index) {
        validateIndex(index);
        Node<T> currentNode = getNode(index);
        if (size == 1) {
            head = tail = null;
        } else if (index == size - 1) {
            tail.prev.next = null;
            tail = tail.prev;
        } else if (index == 0) {
            head.next.prev = null;
            head = head.next;

        } else {
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
        }
        size--;
        return currentNode.value;
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        return getNode(index).value;
    }

    @Override
    public T set(T value, int index) {
        validateIndex(index);
        Node<T> currentNode = getNode(index);
        T oldValue = currentNode.value;
        currentNode.value = value;
        return oldValue;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int indexOf(T value) {
        int index = 0;
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (Objects.equals(value, currentNode.value)) {
                return index;
            }
            index++;
            currentNode = currentNode.next;
        }

        return -1;
    }

    public int lastIndexOf(T value) {
        int currentIndex = size - 1;
        Node<T> currentNode = tail;
        while (currentNode != null) {
            if (Objects.equals(value, currentNode.value)) {
                return currentIndex;
            }
            currentIndex--;
            currentNode = currentNode.prev;
        }
        return -1;
    }

    @Override
    public String toString() {
        Node<T> current = head;
        String result = "[";
        while (current != null) {
            result += String.valueOf(current.value);
            current = current.next;
            if (current != null) {
                result += ",";
            }
        }
        result += "]";
        return result;
    }
}
