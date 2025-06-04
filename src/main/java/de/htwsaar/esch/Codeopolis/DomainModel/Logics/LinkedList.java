package de.htwsaar.esch.Codeopolis.DomainModel.Logics;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Consumer;
import de.htwsaar.esch.Codeopolis.DomainModel.Harvest.Harvest;


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


    @SuppressWarnings("unchecked")
    public void bubblesort() {
        if (size < 2) return;

        boolean swapped;
        do {
            swapped = false;
            Node current = anchor;
            while (current != null && current.nextNode != null) {
                T first = current.data;
                T second = current.nextNode.data;

                if (!(first instanceof Comparable)) {
                    throw new IllegalStateException("Element does not implement Comparable");
                }

                Comparable<T> comp = (Comparable<T>) first;
                if (comp.compareTo(second) > 0) {
                    // Swaps values
                    current.data = second;
                    current.nextNode.data = first;
                    swapped = true;
                }
                current = current.nextNode;
            }
        } while (swapped);
    }


    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;

        LinkedList<?> otherList = (LinkedList<?>) otherObject;
        if (this.size != otherList.size) return false;

        Iterator<T> thisIterator = this.iterator();
        Iterator<?> otherIterator = otherList.iterator();

        while (thisIterator.hasNext() && otherIterator.hasNext()) {
            T thisElement = thisIterator.next();
            Object otherElement = otherIterator.next();

            if (!(Objects.equals(thisElement, otherElement))) {
                return false;
            }
        }

        return true;
    }



    public LinkedList<T> filter(Predicate<T> predicate) {
        LinkedList<T> result = new LinkedList<>();
        for (T element : this) {
            if (predicate.test(element)) {
                result.addLast(element);
            }
        }
        return result;
    }

    public void forEach(Consumer<? super T> consumer) {
        for (T element : this) {
            consumer.accept(element);
        }
    }

    public void removeIf(Predicate<T> predicate) {
        Node dummy = new Node(null);
        dummy.nextNode = anchor;
        Node current = dummy;

        while (current.nextNode != null) {
            if (predicate.test(current.nextNode.data)) {
                current.nextNode = current.nextNode.nextNode;
                size--;
            } else {
                current = current.nextNode;
            }
        }
        anchor = dummy.nextNode;
    }

    public void addIf(T data, Predicate<T> predicate) {
        if (predicate.test(data)) {
            addLast(data);
        }
    }

    public void sort(Comparator<T> comparator) {
        if (size < 2) return;

        boolean swapped;
        do {
            swapped = false;
            Node current = anchor;
            while (current != null && current.nextNode != null) {
                T first = current.data;
                T second = current.nextNode.data;

                if (comparator.compare(first, second) > 0) {
                    current.data = second;
                    current.nextNode.data = first;
                    swapped = true;
                }
                current = current.nextNode;
            }
        } while (swapped);
    }

}

