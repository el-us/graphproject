package com.lsmmjc.md.datastructures.queue;

import com.lsmmjc.md.searchalgorithms.common.Node;

import java.util.NoSuchElementException;

public class QueueImpl<T> {

    private int size;
    private Node<T> first;
    private Node<T> last;

    public QueueImpl() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public T peek() {
        if (this.isEmpty()) throw new NoSuchElementException();
        return this.first.getData();
    }

    public void enqueue(T item) {
        final Node<T> oldLast = last;
        last = new Node<>(item, null);

        if (this.isEmpty()) first = last;
        else oldLast.setNext(last);
        size++;
    }

    public T dequeue() {
        T item;
        if (this.isEmpty()) throw new NoSuchElementException();
        else {
            item = first.getData();
            first = first.getNext();
            size--;
        }

        if (this.isEmpty()) last = null;
        return item;
    }

}
