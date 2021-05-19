package com.lsmmjc.md.service;

import com.lsmmjc.md.controller.dto.GraphDTO;
import com.lsmmjc.md.controller.dto.GraphRequest;
import com.lsmmjc.md.graph.Graph;
import com.lsmmjc.md.mappers.GraphMapper;

import javax.inject.Singleton;

@Singleton
public class GraphService {

    public GraphDTO createGraphForGivenEdges(GraphRequest graphRequest) {
        int vertices = graphRequest.getNumberOfNodes();

        Graph graph = new Graph(vertices);

        for (int i = 0; i < graphRequest.getEdgesMatrix().length; i++){
            graph.addEdge(graphRequest.getEdgesMatrix()[i][0], graphRequest.getEdgesMatrix()[i][1]);
        }

        return GraphMapper.mapToGraphDTO(graph);
    }

}
