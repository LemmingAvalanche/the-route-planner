package com.kristoffer;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    // Set the initial size to be greater than the max needed size
    // divided by the load factor (50 ÷ 0.75).
    //
    // See: The documentation for `java.util.HashMap<K,V>`.
    private HashMap<String, Vertex> graph = new HashMap(68);

    public Graph(ArrayList<Field> fields) {
        for (Field f : fields) {
            int weight = f.getTime();
            Vertex v1 = addVertex(f.getFrom());
            Vertex v2 = addVertex(f.getTo());

            v1.addEdge(new Edge(v2, weight));
            v2.addEdge(new Edge(v1, weight));
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
}
