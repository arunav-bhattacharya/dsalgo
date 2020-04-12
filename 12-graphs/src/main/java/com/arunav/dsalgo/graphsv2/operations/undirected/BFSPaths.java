package com.arunav.dsalgo.graphsv2.operations.undirected;

import com.arunav.dsalgo.graphsv2.structure.Graph;

import java.util.ArrayDeque;
import java.util.Queue;

// This class is to find paths in a graph with respect to a source vertex using BFS

public class BFSPaths<T extends Comparable<T>> extends AbstractPaths<T> {

    // Find all paths in graph reachable from source
    public BFSPaths(Graph<T> graph, T source) {
        super(graph, source);
        bfs();
    }

    private void bfs() {
        Queue<T> queue = new ArrayDeque<>();
        queue.add(sourceVertex);
        isVisited[graph.getIndexOf(sourceVertex)] = true;
        while (!queue.isEmpty()) {
            T item = queue.remove();
            for (T vertex : graph.adjVertices(item)) {
                if (!isVisited[graph.getIndexOf(vertex)]) {
                    isVisited[graph.getIndexOf(vertex)] = true;
                    pathArray[graph.getIndexOf(vertex)] = item;
                    pathMap.put(vertex, item);
                    queue.add(vertex);
                }
            }
        }
    }
}
