package de.htwsaar.esch.Codeopolis.DomainModel;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    private class Node {
        T data;
        Node nextNode;

        Node(T data) {
            this.data = data;
        }
    }

    private Node anchor;
    private int size;

    public LinkedList() {
        anchor = null;
        size = 0;
    }

    public void addLast(T data) {
        Node newNode = new Node(data);
        if (anchor == null) {
            anchor = newNode;
        } else {
            Node current = anchor;
            while (current.nextNode != null)
                current = current.nextNode;
            current.nextNode = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (isEmpty()) return null;
        T data = anchor.data;
        anchor = anchor.nextNode;
        size--;
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        checkIndex(index);
        Node current = nodeAt(index);
        return current.data;
    }

    public T set(int index, T data) {
        checkIndex(index);
        Node current = nodeAt(index);
        T old = current.data;
        current.data = data;
        return old;
    }

    public void clear() {
        anchor = null;
        size = 0;
    }

    public T remove(int index) {
        checkIndex(index);
        if (index == 0) return removeFirst();

        Node prev = nodeAt(index - 1);
        Node current = prev.nextNode;
        prev.nextNode = current.nextNode;
        size--;
        return current.data;
    }

    public void addAll(LinkedList<T> other) {
        for (T item : other) {
            addLast(item);
        }
    }

    private Node nodeAt(int index) {
        Node current = anchor;
        for (int i = 0; i < index; i++)
            current = current.nextNode;
        return current;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node current = anchor;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T data = current.data;
            current = current.nextNode;
            return data;
        }
    }
}

