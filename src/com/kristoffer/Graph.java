package com.kristoffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

public class Graph {

    // Set the initial size to be greater than the max needed size
    // divided by the load factor (50 ÷ 0.75).
    //
    // See: The documentation for `java.util.HashMap<K,V>`.
    private HashMap<String, Vertex> graph = new HashMap(68);

    public Graph(ArrayList<Field> fields, String start) {
        for (Field f : fields) {
            int weight = f.getTime();
            Vertex v1 = addVertex(f.getFrom());
            Vertex v2 = addVertex(f.getTo());

            setToZeroIfStart(v1, start);
            setToZeroIfStart(v2, start);

            v1.addEdge(new Edge(v2, weight));
            v2.addEdge(new Edge(v1, weight));
        }
    }

    // The distance (in minutes) from the starting vertex to itself is
    // 0.
    private static void setToZeroIfStart(Vertex vertex, String start) {
        if (vertex.getName().equals(start)) {
            vertex.setDistance(0);
        }
    }

    public Vertex addVertex(String name) {
        if (!graph.containsKey(name)) {
            graph.put(name, new Vertex(name));
            return graph.get(name);
        } else {
            return graph.get(name);
        }
    }

    public Vertex getVertex(String name) throws Exception {
        Vertex v = graph.get(name);
        if (v != null) {
            return v;
        } else {
            throw new Exception(
                    "Tried to return Vertex that is not in the Graph."
            );
        }
    }

    public Stack<Vertex> getShortestPath(String start, String stop) {
        dijkstra();
        Stack<Vertex> path = new Stack<>();

        Vertex stopVertex = graph.get(stop);
        Vertex p = stopVertex;
        while (p != null) {
            path.push(p);
            p = p.getPrevious();
        }
        return path;
    }

    public String shortestPathToString(String start, String stop) {
        Stack<Vertex> path = getShortestPath(start, stop);
        String string = "";
        while (!path.isEmpty()) {
            Vertex v = path.pop();
            String name = v.getName();
            string += name;
            // Add an arrow if this is not the final destination.
            if (!name.equals(stop)) {
                string += " → ";
            }
        }
        Vertex destination = graph.get(stop);
        string += ": " + destination.getDistance() + " minutes.";
        return string;
    }

    public void dijkstra() {
        PriorityQueue<Vertex> pqueue =
                new PriorityQueue<>(50, new Comparator<Vertex>() {
                    @Override
                    public int compare(Vertex v1, Vertex v2) {
                        return v1.getDistance() - v2.getDistance();
                    }
                });
        pqueue.addAll(graph.values());

        Vertex v = null;
        while (!pqueue.isEmpty()) {
            v = pqueue.remove();
            int distance = v.getDistance();
            for (Edge e : v.getNeighbors()) {
                Vertex n = e.getTo();
                int w = e.getWeight();
                int newDistance = distance + w;
                if (n.getDistance() > newDistance) {
                    // `PriorityQueue` has no `decreasekey(_)` method
                    // so we need to remove the object and re-insert
                    // it after we have updated `distance`.
                    //
                    // TODO: This degrades the complexity of the
                    //   algorithm since `remove(_)` is O(n).
                    pqueue.remove(n);
                    n.setDistance(newDistance);
                    pqueue.offer(n);

                    n.setPrevious(v);
                }
            }
        }
    }
}
