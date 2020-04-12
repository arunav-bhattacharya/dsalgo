package com.arunav.dsalgo.graphsv2.app;

import com.arunav.dsalgo.graphsv2.operations.directed.DirectedCycle;
import com.arunav.dsalgo.graphsv2.structure.Digraph;
import com.arunav.dsalgo.graphsv2.structure.Graph;
import com.arunav.dsalgo.graphsv2.util.GraphUtil;

public class DiGraphApp {

    public static void main(String[] args) {
        testDigraphs();
    }

    private static void testDigraphs() {
        //digraphRepresentation();
        directedCycle();
        topologicalSort();
    }

    private static void digraphRepresentation() {
        Graph<Integer> graph = GraphUtil.buildConnectedGraph(new Digraph());
        System.out.println("DIGRAPH");
        graph.printGraph();
    }

    private static void directedCycle() {
        Digraph digraph = (Digraph) GraphUtil.buildBipartiteCyclicGraph(new Digraph());
        System.out.println("DIGRAPH");
        digraph.printGraph();
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        //directedCycle.isHasCycle();
    }

    private static void topologicalSort() {
    }
}
