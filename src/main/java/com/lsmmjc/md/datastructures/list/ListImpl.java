package com.lsmmjc.md.datastructures.list;

public class ListImpl {

    static int counter = 0;
    private Vertex head;

    public static class Vertex {
        private Vertex previous;
        private Vertex next;
        private int index;
        private ListImpl list;

        public Vertex(int index, ListImpl list) {
            this.previous = null;
            this.next = null;
            this.index = index;
            this.list = list;
        }

        public Vertex getPrevious() {
            return previous;
        }

        public Vertex getNext() {
            return next;
        }

        public int getIndex() {
            return index;
        }

        public ListImpl getList() {
            return list;
        }
    }

    public ListImpl() {
        this.head = null;
        counter++;
    }

    public void addVertex(int index, ListImpl list) {
        Vertex vertex = head;
        Vertex last = null;
        Vertex newVertex = new Vertex(index, list);

        while (vertex != null) {
            last = vertex;
            vertex = vertex.next;
        }
        if(last == null) {
            head = newVertex;
        } else {
            last.next = newVertex;
            newVertex.previous = last;
        }
    }

    public Vertex getVertex(int index) {
        if(index < 0) {
            System.out.printf("Błąd pobierania elemenu. Indeks musi być dodatni. Wybrany indeks: %d%n", index);
        }
        int i = 0;
        Vertex vertex = head;
        while (vertex != null && i < index) {
            i++;
            vertex = vertex.next;
        }
        if(vertex == null) {
            System.out.printf("Nie istnieje element o indeksie: %d%n", index);
        }
        return vertex;
    }

    public void deleteVertex(int index) {
        Vertex vertex = getVertex(index);
        if(vertex.previous == null) {
            head = vertex.next;
            head.previous = null;
        }
        else if(vertex.next == null) {
            vertex = vertex.previous;
            vertex.next = null;
        }
        else {
            vertex.previous.next = vertex.next;
            vertex.next.previous = vertex.previous;
        }
    }

    public void printList() {
        Vertex vertex = this.head;
        System.out.print("[");
        while(vertex != null) {
            if(vertex.next != null) {
                System.out.print(vertex.index + ", ");
            } else {
                System.out.print(vertex.index);
            }
            vertex = vertex.next;
        }
        System.out.print("]\n");
    }

    public ListImpl getList(int index) {
        return getVertex(index).list;
    }

    public int getCounter() {
        return counter;
    }

    public Vertex getHead() {
        return head;
    }
}
