package com.lsmmjc.md.datastructures.stack;

import com.lsmmjc.md.searchalgorithms.common.Node;

import java.util.EmptyStackException;

public class StackImpl<T> {

    private Node<T> top;
    int size;

    public StackImpl () {
        top = null;
        size = 0;
    }

    public boolean isEmpty () {
        return top == null;
    }

    public int size () {
        return size;
    }

    public void push (T val) {
        top = new Node<>(val, top);
        size++;
    }

    public T pop() {
        T data;
        if (isEmpty()) throw new EmptyStackException();
        else {
            data = top.getData();
            Node<T> tmp = top;
            top = top.getNext();
            tmp.setNext(null);
            size--;
        }
        return data;
    }

    public T peek () {
        if (this.isEmpty()) throw new EmptyStackException();
        return top.getData();
    }

}
