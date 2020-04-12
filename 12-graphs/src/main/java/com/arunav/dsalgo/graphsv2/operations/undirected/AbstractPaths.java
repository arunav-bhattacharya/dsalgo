package com.arunav.dsalgo.graphsv2.operations.undirected;

import com.arunav.dsalgo.graphsv2.structure.Graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/* Used two different variations to store the path from source to destination vertex -
    i.  Map<destination, source> pathMap
    ii. T[] pathArray : Array-Index = destination and Array-value = source
*/

public abstract class AbstractPaths<T extends Comparable<T>> implements Paths<T> {

    protected boolean[] isVisited;
    protected T[] pathArray;
    protected Map<T, T> pathMap;
    protected T sourceVertex;
    protected Graph<T> graph;

    AbstractPaths(Graph<T> graph, T source) {
        isVisited = new boolean[graph.vertices()];
        pathArray = (T[]) new Comparable[graph.edges()];
        pathMap = new HashMap<>();
        sourceVertex = source;
        this.graph = graph;
    }

    // Check for path from source to destination vertex
    public boolean hasPath(T destination) {
        return isVisited[graph.getIndexOf(destination)];
    }

    // Return the path from source to destination
    public Stack<T> pathTo(T destination) {

        if (!hasPath(destination))
            return null;
        Stack<T> stack = new Stack<>();

        /*  Showing the different variations of map and array to traverse from destination to source */

//        while (!destination.equals(sourceVertex)) {
//            stack.push(destination);
//            destination = pathArray[graph.getIndexOf(destination)];
//        }
        while (!destination.equals(sourceVertex)) {
            stack.push(destination);
            destination = pathMap.get(destination);
        }
        stack.push(destination);
        return stack;
    }
}
