package com.arunav.dsalgo.graphsv2.operations.directed;

import com.arunav.dsalgo.graphsv2.structure.Digraph;

public class KosarajuSharirSCC {

    private Digraph digraph;
    private boolean[] visited;
    private int[] componentId;
    private int sccCount;

    public KosarajuSharirSCC(Digraph digraph) {
        this.digraph = digraph;
        this.sccCount = 0;
        this.visited = new boolean[digraph.vertices()];
        this.componentId = new int[digraph.vertices()];

        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(digraph.reverse());
        for (int i : depthFirstOrder.reversePostOrder()) {
            if (!visited[i])
                dfs(i, sccCount);
            sccCount++;
        }
    }

    private void dfs(int src, int sccCount) {
        visited[src] = true;
        componentId[src] = sccCount;
        for (int v : digraph.adjVertices(src)) {
            if (!visited[v])
                dfs(v, sccCount);
        }
    }

    public boolean isStronglyConnected(int source, int destination) {
        return (componentId[source] == componentId[destination]);
    }

    public int countOfSCCs() {
        return sccCount;
    }
    
    public int sccId(int vertex) {
        return componentId[vertex];
    }
}
