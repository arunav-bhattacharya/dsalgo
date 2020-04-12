package com.arunav.dsalgo.graphsv2.operations.undirected;

import com.arunav.dsalgo.graphsv2.structure.Graph;

import java.util.HashMap;
import java.util.Map;

/*
    Groups of vertices that are reachable from one another are called connected components
*/

public class ConnectedComponents<T extends Comparable<T>> {

    private Map<T, Integer> componentMap = new HashMap<>();
    private Map<T, Boolean> visitedMap = new HashMap<>();
    private Graph<T> graph;
    private int componentId;

    public ConnectedComponents(Graph<T> graph) {
        this.graph = graph;
        this.componentId = 0;
        for (T vertex : graph.listVertices()) {
            if (!visitedMap.getOrDefault(vertex, false)) {
                dfs(vertex, componentId);
                componentId++;
            }
        }
    }

    private void dfs(T srcVertex, int componentId) {
        visitedMap.put(srcVertex, true);
        componentMap.put(srcVertex, componentId);
        for (T vertex : graph.adjVertices(srcVertex)) {
            if (!visitedMap.getOrDefault(vertex, false)) {
                dfs(vertex, componentId);
            }
        }
    }

    public boolean isConnected(T source, T destination) {
        return componentMap.get(source).equals(componentMap.get(destination));
    }

    public int noOfConnectedComponents() {
        return componentId;
    }

    public int getComponentId(T vertex) {
        return componentMap.get(vertex);
    }
}
