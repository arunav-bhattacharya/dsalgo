package com.arunav.dsalgo.graphsv2.structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AdjListGraph<T extends Comparable<T>> implements Graph<T> {

    private int nVertices;
    private int nEdges;
    private GraphType graphType;
    private List<T> vertexList;
    private List<List<T>> adjacencyList;

    public AdjListGraph(GraphType graphType) {
        this.nVertices = 0;
        this.nEdges = 0;
        this.graphType = graphType;
        this.vertexList = new ArrayList<>();
        this.adjacencyList = new ArrayList<>();
    }

    @Override
    public int vertices() {
        return nVertices;
    }

    @Override
    public int edges() {
        return nEdges;
    }

    @Override
    public void addVertex(T vertex) {
        adjacencyList.add(new LinkedList<>());
        vertexList.add(nVertices, vertex);
        nVertices++;
    }

    @Override
    public void addVertices(List<T> vertices) {
        for (T vertex : vertices) {
            adjacencyList.add(nVertices, new LinkedList<>());
            vertexList.add(nVertices, vertex);
            nVertices++;
        }
    }

    @Override
    public void addEdge(T source, T destination) {
        if (!vertexList.contains(source) || !vertexList.contains(destination))
            throw new RuntimeException("Invalid vertex provided");

        int srcVertex = vertexList.indexOf(source); // Get index of source
        List<T> list = adjacencyList.get(srcVertex); // Get the linked list on the vertex
        list.add(destination); // Add destination to end of the linked list

        /* For an undirected graph, the edge needs to be specified from dest to source
           as well in the adjList */
        if (graphType == GraphType.UNDIRECTED) {
            int destVertex = vertexList.indexOf(destination);
            list = adjacencyList.get(destVertex);
            list.add(source);
        }
        nEdges++;
    }

    @Override
    public List<T> adjVertices(T vertex) {
        if (vertexList.contains(vertex))
            return adjacencyList.get(vertexList.indexOf(vertex));
        else
            throw new RuntimeException("Searching for invalid vertex =" + vertex);
    }

    @Override
    public Iterable<T> listVertices() {
        return vertexList;
    }

    @Override
    public void printGraph() {
        for (int i = 0; i < nVertices; i++) {
            List<T> list = adjacencyList.get(i);
            System.out.print("Vertex " + i + " -");
            for (T t : list)
                System.out.print("-> " + t);
            System.out.println();
        }
    }

    public int getIndexOf(T vertex) {
        if (vertexList.contains(vertex))
            return vertexList.indexOf(vertex);
        else
            throw new RuntimeException("Searching for invalid vertex =" + vertex);
    }
}
