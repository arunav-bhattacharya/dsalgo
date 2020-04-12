package com.arunav.dsalgo.graphsv2.operations.undirected;

import java.util.Stack;

public interface Paths<T extends Comparable<T>> {

    // Check for path from source to destination vertex
    boolean hasPath(T destination);

    // Return the path from source to destination
    Stack<T> pathTo(T destination);
}
