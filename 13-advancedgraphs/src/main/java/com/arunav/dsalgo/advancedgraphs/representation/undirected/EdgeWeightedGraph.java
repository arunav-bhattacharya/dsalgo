package com.arunav.dsalgo.advancedgraphs.representation.undirected;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedGraph {

    private List<List<Edge>> edgeList;
    private int vertices;
    private int edges;

    public EdgeWeightedGraph(int vertices) {
        this.edgeList = new ArrayList<>();
        this.vertices = vertices;
        this.edges = 0;
        for (int i = 0; i < vertices; i++)
            edgeList.add(i, new ArrayList<>());
    }

    public void addEdge(Edge edge) {
        edgeList.get(edge.getV1()).add(edge);
        edgeList.get(edge.getV2()).add(edge);
        edges++;
    }

    public List<Edge> allEdges() {
        List<Edge> allEdges = new ArrayList<>();
        for (int v = 0; v < vertices; v++) {
            for (Edge edge : adjEdges(v)) {
                int otherVertex = (v == edge.getV1()) ? edge.getV2() : edge.getV1();
                if (otherVertex > v)
                    allEdges.add(edge);
            }
        }
        return allEdges;
    }

    public List<Integer> allVertices() {
        List<Integer> allVertices = new ArrayList<>();
        for (int v = 0; v < vertices; v++)
            allVertices.add(v);
        return allVertices;
    }

    public Iterable<Edge> adjEdges(int vertex) {
        return edgeList.get(vertex);
    }

    public int getVertices() {
        return vertices;
    }

    public int getEdges() {
        return edges;
    }
}
