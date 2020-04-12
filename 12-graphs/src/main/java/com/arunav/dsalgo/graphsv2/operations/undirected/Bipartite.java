package com.arunav.dsalgo.graphsv2.operations.undirected;

import com.arunav.dsalgo.graphsv2.structure.Graph;

/*
 * A bipartite graph is a graph whose vertices we can divide into two sets such that all edges connect a vertex in one
 * set with a vertex in the other set.
 */

public class Bipartite<T extends Comparable<T>> {

    private boolean[] isVisited;
    private boolean[] color;
    private Graph<T> graph;
    private boolean isBipartite;

    public Bipartite(Graph<T> graph) {
        this.graph = graph;
        this.isBipartite = true;
        this.isVisited = new boolean[graph.vertices()];
        this.color = new boolean[graph.vertices()];

        for (T vertex : graph.listVertices()) {
            if (!isVisited[graph.getIndexOf(vertex)])
                dfs(isVisited, vertex);
        }
    }

    private void dfs(boolean[] isVisited, T srcVertex) {
        isVisited[graph.getIndexOf(srcVertex)] = true;
        for (T currVertex : graph.adjVertices(srcVertex)) {
            if (!isVisited[graph.getIndexOf(currVertex)]) {
                color[graph.getIndexOf(currVertex)] = !color[graph.getIndexOf(srcVertex)];
                dfs(isVisited, currVertex);
            } else if (color[graph.getIndexOf(srcVertex)] == (color[graph.getIndexOf(currVertex)]))
                isBipartite = false;
        }
    }

    public boolean isBipartite() {
        return isBipartite;
    }
}
