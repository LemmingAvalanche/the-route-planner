package com.kristoffer;

import java.util.HashMap;

public class BinaryHeap {

    Vertex[] heap = new Vertex[Graph.MAX_VERTICES];
    HashMap<String, WrapperVertex> lookup = new HashMap<>(68);

    private int nextAvailable = 0;

    public void insert(Vertex v) {
        heap[nextAvailable] = v;
        lookup.put(v.getName(), new WrapperVertex(v.getName()));
        setWrapperIndex(v, nextAvailable);
        int index = nextAvailable;
        nextAvailable++;
        bubbleUp(v, index);
    }

    private void bubbleUp(Vertex v, int index) {
        if (index != 0) {
            int vWeight = v.getDistance();
            int pi = getParentIndex(index);
            int pWeight = heap[pi].getDistance();
            while (index != 0 && vWeight < pWeight) {
                swap(index, pi);
                index = pi;
                vWeight = v.getDistance();
                pi = getParentIndex(index);
                pWeight = heap[pi].getDistance();
            }
        }
    }

    private void decreaseKey(Vertex v) {
        int index = getWrapperIndex(v);
        int distance = v.getDistance();
        bubbleUp(v, index);
    }

    private static int getParentIndex(int index) {
        return index/2;
    }

    private static int getChild1(int index) {
        return 2 * index;
    }

    private static int getChild2(int index) {
        return (2 * index) + 1;
    }

    private void swap(int i1, int i2) {
        Vertex temp = heap[i1];
        heap[i1] = heap[i2];
        heap[i2] = temp;
    }

    private int getWrapperIndex(Vertex vertex) {
        WrapperVertex wv = lookup.get(vertex.getName());
        return wv.getIndex();
    }

    private void setWrapperIndex(Vertex vertex, int index) {
        WrapperVertex wv = lookup.get(vertex.getName());
        wv.setIndex(index);
    }

    private class WrapperVertex {
        private String name;
        private int index = -1;

        WrapperVertex(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

}
