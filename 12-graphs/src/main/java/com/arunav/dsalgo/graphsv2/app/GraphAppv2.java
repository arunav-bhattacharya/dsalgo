package com.arunav.dsalgo.graphsv2.app;

import com.arunav.dsalgo.graphsv2.operations.undirected.*;
import com.arunav.dsalgo.graphsv2.structure.AdjListGraph;
import com.arunav.dsalgo.graphsv2.structure.Graph;
import com.arunav.dsalgo.graphsv2.util.GraphUtil;

public class GraphAppv2 {

    public static void main(String[] args) {
        testUndirectedGraphs();
    }

    private static void testUndirectedGraphs() {
        testDFSPaths();
        testBFSPaths();
        testConnectedComponents();
        testHasCycle();
        testBipartite();
    }

    private static void testDFSPaths() {
        System.out.println();
        System.out.println("Testing DFS Paths");
        System.out.println("=================");

        Integer source = 0;
        Graph<Integer> graph = GraphUtil.buildConnectedGraph(new AdjListGraph<>(Graph.GraphType.UNDIRECTED));
        System.out.println("GRAPH :");
        graph.printGraph();
        DFSPaths<Integer> dfsPaths = new DFSPaths<>(graph, source);
        GraphUtil.validatePaths(dfsPaths, graph, source);
    }

    private static void testBFSPaths() {
        System.out.println();
        System.out.println("Testing BFS Paths");
        System.out.println("=================");

        Integer source = 0;
        Graph<Integer> graph = GraphUtil.buildConnectedGraph(new AdjListGraph<>(Graph.GraphType.UNDIRECTED));
        System.out.println("GRAPH :");
        graph.printGraph();
        BFSPaths<Integer> bfsPaths = new BFSPaths<>(graph, source);
        GraphUtil.validatePaths(bfsPaths, graph, source);
    }

    private static void testConnectedComponents() {
        System.out.println();
        System.out.println("Testing Connected Components");
        System.out.println("============================");

        Graph<Integer> graph = GraphUtil.buildDisconnectedGraph(new AdjListGraph<>(Graph.GraphType.UNDIRECTED));
        System.out.println("GRAPH :");
        graph.printGraph();
        ConnectedComponents<Integer> connectedComponents = new ConnectedComponents<>(graph);
        GraphUtil.validateConnectedComponents(connectedComponents, graph);
    }

    private static void testHasCycle() {
        System.out.println();
        System.out.println("Testing Has Cycles");
        System.out.println("==================");

        //Graph<Integer> graph = GraphUtil.buildDisconnectedGraph(new AdjListGraph<>(Graph.GraphType.UNDIRECTED));
        Graph<Integer> graph = GraphUtil.buildAcyclicGraph(new AdjListGraph<>(Graph.GraphType.UNDIRECTED));
        System.out.println("GRAPH :");
        graph.printGraph();
        Cycle<Integer> cycle = new Cycle<>(graph);
        System.out.println("Has Cycle : " + cycle.isHasCycle());
    }

    private static void testBipartite() {
        System.out.println();
        System.out.println("Testing Bipartite");
        System.out.println("=================");

        //Graph<Integer> graph = GraphUtil.buildConnectedGraph(new AdjListGraph<>(Graph.GraphType.UNDIRECTED));
        //Graph<Integer> graph = GraphUtil.buildDisconnectedGraph(new AdjListGraph<>(Graph.GraphType.UNDIRECTED));
        //Graph<Integer> graph = GraphUtil.buildAcyclicGraph(new AdjListGraph<>(Graph.GraphType.UNDIRECTED));
        Graph<Integer> graph = GraphUtil.buildBipartiteCyclicGraph(new AdjListGraph<>(Graph.GraphType.UNDIRECTED));
        System.out.println("GRAPH :");
        graph.printGraph();
        Bipartite<Integer> bipartite = new Bipartite<>(graph);
        System.out.println("Is Bipartite : " + bipartite.isBipartite());
    }
}
