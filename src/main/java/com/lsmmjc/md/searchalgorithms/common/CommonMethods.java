package com.lsmmjc.md.searchalgorithms.common;

import com.lsmmjc.md.datastructures.list.ListImpl;
import com.lsmmjc.md.graph.Graph;

public class CommonMethods {

    public static ListImpl.Vertex getUnvisitedVertex(final Graph graph, final ListImpl.Vertex vertex, final boolean[] visitedVertices) {
        for (int i = 0; i < graph.getV(); i++) {
            if (graph.getAdjacencyMatrix()[vertex.getIndex()][i] != 0 && !visitedVertices[i])
                return graph.getIncidenceList().getVertex(i);
        }
        return null;
    }

    public static boolean isGraphConsistent(final Graph graph, final boolean[] visitedVertices) {
        boolean allTrue = true;
        for (int i = 0; i < graph.getV(); i++) {
            if (!visitedVertices[i]) {
                allTrue = false;
                break;
            }
        }
        if (allTrue) {
            System.out.println("Graf jest spójny (wyszukiwanie dotarło do wszystkich wierzchołków grafu).");
            return true;
        }
            System.out.println("Graf nie jest spójny (wyszukiwanie nie dotarło do wszystkich wierzchołków grafu).");
        return false;
    }

}
