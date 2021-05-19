package com.lsmmjc.md.controller.dto;

import lombok.Data;

@Data
public class GraphRequest {
    private int numberOfNodes;
    private int[][] edgesMatrix;
}
