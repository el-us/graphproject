package com.lsmmjc.md.mappers;

import com.lsmmjc.md.controller.dto.GraphDTO;
import com.lsmmjc.md.datastructures.list.ListImpl;
import com.lsmmjc.md.graph.Graph;
import com.lsmmjc.md.searchalgorithms.BreadthFirstSearch;
import com.lsmmjc.md.searchalgorithms.DepthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphMapper {

    public static GraphDTO mapToGraphDTO(final Graph graph) {

        GraphDTO graphDTO = new GraphDTO();

        graphDTO.setAdjacencyMatrix(graph.getAdjacencyMatrix());
        graphDTO.setIncidenceMatrix(graph.getIncidenceMatrix());

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph);

        Map<String, Boolean> isConsistentMap = new HashMap<>();
        isConsistentMap.put("BreadthFirstSearch", breadthFirstSearch.runAlgorithm());
        isConsistentMap.put("DepthFirstSearch", depthFirstSearch.runAlgorithm());
        graphDTO.setIsConsistent(isConsistentMap);
        List<List<Integer>> incidenceList = mapIncidenceList(graph);
        graphDTO.setIncidenceList(incidenceList);

        return graphDTO;
    }

    private static List<List<Integer>> mapIncidenceList(final Graph graph) {
        ListImpl incidenceList = graph.getIncidenceList();
        List<List<Integer>> mappedIncidenceList = new ArrayList<>();

        for (int i = 0; i < graph.getV(); i++) {
            if (incidenceList.getVertex(i) != null) {
                ListImpl list = incidenceList.getVertex(i).getList();
                List<Integer> incidenceListForVertex = new ArrayList<>();

                ListImpl.Vertex vertex = list.getHead();
                while (vertex != null) {
                    incidenceListForVertex.add(vertex.getIndex());
                    vertex = vertex.getNext();
                }
                mappedIncidenceList.add(incidenceListForVertex);
            }
        }
        return mappedIncidenceList;
    }

}
