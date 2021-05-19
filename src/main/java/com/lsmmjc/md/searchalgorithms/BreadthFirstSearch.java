package com.lsmmjc.md.searchalgorithms;

import com.lsmmjc.md.datastructures.list.ListImpl;
import com.lsmmjc.md.datastructures.queue.QueueImpl;
import com.lsmmjc.md.graph.Graph;
import com.lsmmjc.md.searchalgorithms.common.CommonMethods;

public class BreadthFirstSearch {

    private Graph graph;

    public BreadthFirstSearch(Graph graph) {
        this.graph = graph;
    }

    public boolean runAlgorithm() {
        boolean[] visitedVertices = new boolean[this.graph.getV()];
        QueueImpl<ListImpl.Vertex> queue = new QueueImpl<>();

        ListImpl.Vertex currentVertex = this.graph.getIncidenceList().getHead();

        visitedVertices[currentVertex.getIndex()] = true;
        System.out.println(currentVertex.getIndex());
        queue.enqueue(currentVertex);

        while (!queue.isEmpty()) {
            currentVertex = queue.dequeue();

            ListImpl.Vertex tempVertex;
            while ((tempVertex = CommonMethods.getUnvisitedVertex(graph, currentVertex, visitedVertices)) != null){
                visitedVertices[tempVertex.getIndex()] = true;
//                System.out.println(tempVertex.getIndex());
                queue.enqueue(tempVertex);
            }
        }

        return CommonMethods.isGraphConsistent(graph, visitedVertices);
    }

}
