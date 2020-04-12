package com.arunav.dsalgo.graphsv2.operations.directed;

import com.arunav.dsalgo.graphsv2.structure.Digraph;
import com.arunav.dsalgo.linkedlists.Stack;

public class DirectedCycle {

    private boolean[] visited;
    private boolean[] onStack;
    private int[] path;
    private boolean hasCycle;
    private Digraph digraph;
    private Stack<Integer> cycle;

    public DirectedCycle(Digraph digraph) {
        this.visited = new boolean[digraph.vertices()];
        this.onStack = new boolean[digraph.vertices()];
        this.path = new int[digraph.vertices()];
        this.hasCycle = false;
        this.digraph = digraph;

        for (int i = 0; i < digraph.vertices(); i++)
            if (!visited[i])
                dfs(i);
    }

    private void dfs(int src) {
        if (hasCycle)
            return;
        visited[src] = true;
        onStack[src] = true;

        for (int vertex : digraph.adjVertices(src)) {
            if (!visited[vertex]) {
                path[vertex] = src;
                dfs(vertex);
            } else if (onStack[vertex]) {
                path[vertex] = src;
                hasCycle = true;
                this.cycle = new Stack<>();
                cycle.push(vertex);
                for (int i = path[vertex]; i != vertex; i = path[i])
                    cycle.push(i);

                return;
            }
        }
        onStack[src] = false;
    }

    public boolean isHasCycle() {
        return hasCycle;
    }

    public Stack<Integer> cycle() {
        return cycle;
    }
}
