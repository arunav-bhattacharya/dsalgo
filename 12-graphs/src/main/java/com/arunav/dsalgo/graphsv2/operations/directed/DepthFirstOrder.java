package com.arunav.dsalgo.graphsv2.operations.directed;

import com.arunav.dsalgo.graphsv2.structure.Digraph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstOrder {

    private Queue<Integer> preOrderQueue;
    private Queue<Integer> postOrderQueue;
    private Stack<Integer> reverstPostOrderStack;
    private boolean[] visited;
    private Digraph digraph;

    DepthFirstOrder(Digraph digraph) {
        this.visited = new boolean[digraph.vertices()];
        this.digraph = digraph;
        this.preOrderQueue = new ArrayDeque<>();
        this.postOrderQueue = new ArrayDeque<>();
        this.reverstPostOrderStack = new Stack<>();

        for (int i : digraph.listVertices())
            if (!visited[i])
                dfs(i);
    }

    private void dfs(int src) {
        visited[src] = true;
        preOrderQueue.add(src);
        for (int vertex : digraph.adjVertices(src))
            if (!visited[vertex])
                dfs(vertex);
        postOrderQueue.add(src);
        reverstPostOrderStack.push(src);
    }

    public Iterable<Integer> preOrder() {
        return preOrderQueue;
    }

    public Iterable<Integer> postOrder() {
        return postOrderQueue;
    }

    public Iterable<Integer> reversePostOrder() {
        return reverstPostOrderStack;
    }
}
