package com.lsmmjc.md.searchalgorithms.common;

public class Node<T> {
    T data;
    Node<T> next;

    public Node(T val, Node<T> n) {
        data = val;
        next = n;
    }

    public void setData(T val) {
        data = val;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> n) {
        next = n;
    }
}
