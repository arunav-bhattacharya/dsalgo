package com.arunav.dsalgo.graphsv2.operations.undirected;

import com.arunav.dsalgo.graphsv2.structure.Graph;

import java.util.Map;

// This class is to find paths in a graph with respect to a source vertex using DFS

public class DFSPaths<T extends Comparable<T>> extends AbstractPaths<T> {

    // Find all paths in graph reachable from source
    public DFSPaths(Graph<T> graph, T source) {
        super(graph, source);
        dfs(source, isVisited, pathArray, pathMap);
    }

    private void dfs(T source, boolean[] isVisited, T[] pathArray, Map<T, T> pathMap) {
        isVisited[graph.getIndexOf(source)] = true;

        for (T vertex : graph.adjVertices(source)) {
            int currVertexIdx = graph.getIndexOf(vertex);
            if (!isVisited[currVertexIdx]) {
                pathArray[currVertexIdx] = source;
                pathMap.put(vertex, source);
                dfs(vertex, isVisited, pathArray, pathMap);
            }
        }
    }
}
