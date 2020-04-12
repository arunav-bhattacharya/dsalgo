package com.arunav.dsalgo.graphsv2.operations.directed;

import com.arunav.dsalgo.graphsv2.structure.Digraph;

public class TopologicalSort {

    private Iterable<Integer> topoOrder;

    public TopologicalSort(Digraph digraph) {
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        if (!directedCycle.isHasCycle())
            topoOrder = new DepthFirstOrder(digraph).reversePostOrder();
    }

    public Iterable<Integer> getTopoOrder() {
        return topoOrder;
    }
}
