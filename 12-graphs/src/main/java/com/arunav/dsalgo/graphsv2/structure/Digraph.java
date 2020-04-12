package com.arunav.dsalgo.graphsv2.structure;

import java.util.ArrayList;
import java.util.List;

public class Digraph implements Graph<Integer> {

    private List<List<Integer>> adjList;
    private int nVertices;
    private int nEdges;

    public Digraph() {
        this.nVertices = 0;
        this.nEdges = 0;
        this.adjList = new ArrayList<>();
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
    public void addVertex(Integer integer) {
        adjList.add(nVertices++, new ArrayList<>());
    }

    @Override
    public void addVertices(List<Integer> vertices) {
        for (Integer vertex : vertices) {
            adjList.add(vertex, new ArrayList<>());
            nVertices++;
        }
    }

    @Override
    public void addEdge(Integer source, Integer destination) {
        adjList.get(source).add(destination);
        nEdges++;
    }

    @Override
    public Iterable<Integer> adjVertices(Integer vertex) {
        if (adjList.get(vertex) == null)
            throw new RuntimeException("Invalid Vertex");
        return adjList.get(vertex);
    }

    @Override
    public List<Integer> listVertices() {
        List<Integer> vertices = new ArrayList<>();
        for (int i = 0; i < nVertices; i++) {
            vertices.add(i);
        }
        return vertices;
    }

    @Override
    public void printGraph() {
        for (int i = 0; i < nVertices; i++) {
            List<Integer> list = adjList.get(i);
            System.out.print("Vertex " + i + " -");
            for (Integer t : list)
                System.out.print("-> " + t);
            System.out.println();
        }
    }

    @Override
    public int getIndexOf(Integer vertex) {
        return vertex;
    }

    public Digraph reverse() {
        Digraph reverseDigraph = new Digraph();
        for (int src = 0; src < this.vertices(); src++) {
            for (Integer dest : adjVertices(src))
                reverseDigraph.addEdge(dest, src);
        }
        return reverseDigraph;
    }
}
