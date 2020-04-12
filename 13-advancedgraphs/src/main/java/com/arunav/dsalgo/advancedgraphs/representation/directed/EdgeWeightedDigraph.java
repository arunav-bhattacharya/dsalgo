package com.arunav.dsalgo.advancedgraphs.representation.directed;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedDigraph<T> {

    private List<List<DirectedEdge<T>>> edgeList;
    private int vertices;

    public EdgeWeightedDigraph(int vertices) {
        this.edgeList = new ArrayList<>();
        this.vertices = vertices;
        for (int i = 0; i < vertices; i++)
            edgeList.add(i, new ArrayList<>());
    }

    public void addEdge(DirectedEdge<T> edge) {
        edgeList.get(edge.getFrom().getId()).add(edge);
    }

    public List<DirectedEdge<T>> allEdges() {
        List<DirectedEdge<T>> edges = new ArrayList<>();
        for (int v = 0; v < vertices; v++) {
            for (DirectedEdge edge : adjEdges(v))
                edges.add(edge);
        }
        return edges;
    }

    public List<Integer> allVertices() {
        List<Integer> vertices = new ArrayList<>();
        for (int v = 0; v < this.vertices; v++)
            vertices.add(v);
        return vertices;
    }

    public Iterable<DirectedEdge<T>> adjEdges(int vertex) {
        return edgeList.get(vertex);
    }

    public int getVertices() {
        return vertices;
    }
}
