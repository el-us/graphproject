package com.lsmmjc.md.graph;

import com.lsmmjc.md.datastructures.list.ListImpl;
import lombok.Data;

@Data
public class Graph {

    private final static int INITIAL_MATRIX_SIZE = 1;
    private final int[][] adjacencyMatrix;
    private final ListImpl incidenceList;
    private final int v;
    private int e;
    int sizeOfMatrixE;
    private int[][] incidenceMatrix;

    public Graph(int v) {
        this.v = v;
        this.e = -1;
        this.adjacencyMatrix = new int[v][v];
        this.incidenceMatrix = new int[v][INITIAL_MATRIX_SIZE];
        this.incidenceList = new ListImpl();
        for (int i = 0; i < v; i++) {
            incidenceList.addVertex(i, new ListImpl());
        }
        sizeOfMatrixE = 1;
    }

    public void addEdge(int a, int b) {
        e++;
        if (e >= sizeOfMatrixE) {
            incidenceMatrix = expandMatrix(incidenceMatrix);
        }
        if (a >= 0 && a < v && b >= 0 && b < v) {
            adjacencyMatrix[a][b] = 1;
            incidenceMatrix[a][e] = 1;
            incidenceMatrix[b][e] = -1;

            incidenceList.getList(a).addVertex(b, incidenceList.getList(b));
        } else {
            String msg = String.format("\nJeden z wierzchołków %d lub %d, jest poza zakresem." +
                    "\nWartości powinny mieścić się w zakresie od 0 do %d", a, b, v);
            System.out.println(msg);
        }
    }

    public void printAdjacencyMatrix() {
        System.out.println("\nMacierz sąsiedztwa:");
        printMatrix(this.adjacencyMatrix);
    }

    public void printIncidenceMatrix() {
        System.out.println("\nMacierz incydencji:");
        printMatrix(this.incidenceMatrix);
    }

    public void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] >= 0) {
                    System.out.print(" " + matrix[i][j] + " ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.print("]\n");
        }
    }

    public void printIncidenceList() {
        System.out.printf("\nLista incydencji [liczba obiektów: %d]:%n", incidenceList.getCounter());
        for (int i = 0; i < v; i++) {
            System.out.print("Wierzchołek " + i + ": ");
            if (incidenceList.getList(i) != null) {
                incidenceList.getList(i).printList();
            }
        }
    }

    public int[][] expandMatrix(int[][] matrix) {
        sizeOfMatrixE += 1;
        int[][] newMatrix = new int[v][sizeOfMatrixE];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                newMatrix[i][j] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public int getV() {
        return v;
    }

    public ListImpl getIncidenceList() {
        return incidenceList;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }
}
