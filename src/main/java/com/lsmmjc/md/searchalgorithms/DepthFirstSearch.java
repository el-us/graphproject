package com.lsmmjc.md.searchalgorithms;

import com.lsmmjc.md.datastructures.list.ListImpl;
import com.lsmmjc.md.datastructures.stack.StackImpl;
import com.lsmmjc.md.graph.Graph;
import com.lsmmjc.md.searchalgorithms.common.CommonMethods;

public class DepthFirstSearch {

    private Graph graph;

    public DepthFirstSearch(Graph graph) {
        this.graph = graph;
    }

    public boolean runAlgorithm() {
        boolean[] visitedVertices = new boolean[this.graph.getV()];
        StackImpl<ListImpl.Vertex> stack = new StackImpl<>();

        ListImpl.Vertex currentVertex = this.graph.getIncidenceList().getHead();

        visitedVertices[currentVertex.getIndex()] = true;
        System.out.println(currentVertex.getIndex());
        stack.push(currentVertex);

        while (!stack.isEmpty()) {
            // pobierz nie odwiedzony wierzchołek przyległy do szczytowego elementu stosu
            currentVertex = CommonMethods.getUnvisitedVertex(this.graph, stack.peek(), visitedVertices);
            if (currentVertex == null) {
                stack.pop();
            } else {
                visitedVertices[currentVertex.getIndex()] = true;
//                System.out.println(currentVertex.getIndex());
                stack.push(currentVertex);
            }
        }

        return CommonMethods.isGraphConsistent(graph, visitedVertices);
    }

}
