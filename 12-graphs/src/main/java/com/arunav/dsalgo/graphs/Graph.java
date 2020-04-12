package com.arunav.dsalgo.graphs;

import java.util.Set;

public interface Graph<T> {

    void addVertex(T t);

    void addEdge(T srcVertex, T destVertex);

    int numOfVertices();

    int numOfEdges();

    Set<Vertex<T>> getAdjacentVertices(T vertex);

    Set<Vertex<T>> getAllVertices();

    Set<String> getAllEdges();

    void dfs(T t);

    void bfs(T t);

    void display();

    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }

}
