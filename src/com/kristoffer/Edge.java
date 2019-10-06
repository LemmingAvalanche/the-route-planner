package com.kristoffer;

public class Edge {

    // An edge goes from the owning Vertex to another Vertex.
    private Vertex to;
    // The weight is the time in minutes it takes to traverse.
    private int weight;

    public Edge(Vertex to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    public Vertex getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "edge with vertex: " + to.getName()
                + "; weight: " + weight
                + ";";
    }
}
