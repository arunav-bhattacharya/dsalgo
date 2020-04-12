package com.arunav.dsalgo.graphsv2.operations.undirected;

import com.arunav.dsalgo.graphsv2.structure.Graph;

/*
    This class checks for a cycle in an undirected graph, considering there are no loops or parallel edges
*/

public class Cycle<T extends Comparable<T>> {

    private boolean[] isVisited;
    private Graph<T> graph;
    private boolean hasCycle;

    public Cycle(Graph<T> graph) {
        this.graph = graph;
        isVisited = new boolean[graph.vertices()];
        hasCycle = false;

        for (T vertex : graph.listVertices()) {
            int vertexIdx = graph.getIndexOf(vertex);
            if (!isVisited[vertexIdx]) {
                dfs(vertex, vertex, isVisited);
            }
        }
    }

    private void dfs(T root, T source, boolean[] isVisited) {
        int vertexIdx = graph.getIndexOf(source);
        isVisited[vertexIdx] = true;
        for (T vertex : graph.adjVertices(source)) {
            vertexIdx = graph.getIndexOf(vertex);
            if (!isVisited[vertexIdx]) {
                dfs(source, vertex, isVisited);
            } else if (!root.equals(vertex))
                hasCycle = true;
        }
    }

    public boolean isHasCycle() {
        return hasCycle;
    }
}
