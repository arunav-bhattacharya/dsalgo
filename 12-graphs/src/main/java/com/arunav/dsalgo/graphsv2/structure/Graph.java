package com.arunav.dsalgo.graphsv2.structure;

import java.util.List;

public interface Graph<T extends Comparable<T>> {

    int vertices();

    int edges();

    void addVertex(T t);

    void addVertices(List<T> t);

    void addEdge(T source, T destination);

    Iterable<T> adjVertices(T t);

    Iterable<T> listVertices();

    void printGraph();

    int getIndexOf(T vertex);

    enum GraphType {
        DIRECTED, UNDIRECTED;
    }
}
