package com.lsmmjc.md.controller.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class GraphDTO {

    private int[][] adjacencyMatrix;
    private int[][] incidenceMatrix;
    private List<List<Integer>> incidenceList;
    private Map<String, Boolean> isConsistent;

}
