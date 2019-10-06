package com.kristoffer;

import java.util.ArrayList;

public class Vertex {

    // Bus stop name.
    private String name;
    private ArrayList<Edge> neighbors = new ArrayList<>();
    // For backtracking after Dijkstra’s Algorithm has found all
    // shortest paths.
    private Vertex previous = null;
    // Initialize to poor-man’s infinity.
    private int distance = Integer.MAX_VALUE;

    public Vertex(String name) {
        this.name = name;
    }

    public void addEdge(Edge neighbor) {
        neighbors.add(neighbor);
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    public ArrayList<Edge> getNeighbors() {
        return neighbors;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String sep1 = ";";
        String sep2 = ", ";
        String s = "Vertex with: name: " + name + sep1;
        s += " neigbhors: ";
        for (Edge n : neighbors) {
            s += n + sep2;
        }
        s += sep1;
        s += " previous: "
              + (previous == null ? "[none]" + sep1 : previous + sep1);
        s += " distance: " + distance + sep1;
        return s;
    }
}
