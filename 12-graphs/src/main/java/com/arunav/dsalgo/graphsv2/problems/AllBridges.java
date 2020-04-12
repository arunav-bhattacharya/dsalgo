package com.arunav.dsalgo.graphsv2.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllBridges {

    private List<List<Integer>> graph = new ArrayList<>();
    private List<List<Integer>> bridges = new ArrayList<>();

    private int[] dfsVisitedNo;
    private boolean[] visited;
    private int visitedNo = 0;

    public List<List<Integer>> findBridges(List<List<Integer>> edges, int vertices) {

        for (int i = 0; i < vertices; i++)
            graph.add(new ArrayList<>());

        for (List<Integer> edge : edges) {
            graph.get(edge.get(0)).add(edge.get(1));
            graph.get(edge.get(1)).add(edge.get(0));
        }

        this.dfsVisitedNo = new int[graph.size()];
        this.visited = new boolean[graph.size()];

        int rootVertex = graph.get(0).get(0);
        dfs(rootVertex);
        return bridges;
    }

    private void dfs(Integer src) {
        visited[src] = true;
        dfsVisitedNo[src] = visitedNo;
        visitedNo++;

        for (Integer vertex : adjVertices(src)) {
            if (!visited[vertex]) {
                dfs(vertex);
                dfsVisitedNo[vertex] = getDfsLowNo(vertex, src);
                if (dfsVisitedNo[vertex] > dfsVisitedNo[src])
                    bridges.add(Arrays.asList(src,vertex));
            }
        }
    }

    private int getDfsLowNo(Integer vertex, Integer src) {
        int lowValue = dfsVisitedNo[vertex];
        for (Integer v : adjVertices(vertex)) {
            if (!v.equals(src))
                lowValue = Math.min(dfsVisitedNo[v], lowValue);
        }
        return lowValue;
    }

    private List<Integer> adjVertices(Integer vertex) {
        return graph.get(vertex);
    }
}
