package com.kristoffer;

import java.util.ArrayList;

public class Vertex {

    // Bus stop name.
    private String name;
    private ArrayList<Edge> neighbors = null;
    // For backtracking after Dijkstra’s Algorithm has found all
    // shortest paths.
    private Vertex previous = null;
    // Initialize to poor-man’s infinity.
    private int distance = Integer.MAX_VALUE;

    public Vertex(String name) {
        this.name = name;
    }
}
