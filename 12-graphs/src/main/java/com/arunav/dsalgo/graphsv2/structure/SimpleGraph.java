package com.arunav.dsalgo.graphsv2.structure;

import java.util.ArrayList;
import java.util.List;

public class SimpleGraph implements Graph<Integer> {

    private int nVertices;
    private int nEdges;
    private List<List<Integer>> adjList;

    public SimpleGraph() {
        this.nEdges = 0;
        this.nVertices = 0;
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
    public void addVertex(Integer vertex) {
        adjList.add(nVertices++, new ArrayList<>());
    }

    @Override
    public void addVertices(List<Integer> vertices) {
        for (int i : vertices) {
            adjList.add(nVertices++, new ArrayList<>());
        }
    }

    @Override
    public void addEdge(Integer source, Integer destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source);
    }

    @Override
    public Iterable<Integer> adjVertices(Integer vertex) {
        return adjList.get(vertex);
    }

    @Override
    public Iterable<Integer> listVertices() {
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
}
