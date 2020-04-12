package com.arunav.dsalgo.advancedgraphs.mst;


import com.arunav.dsalgo.advancedgraphs.representation.undirected.Edge;
import com.arunav.dsalgo.advancedgraphs.representation.undirected.EdgeWeightedGraph;

import java.util.List;

public class MSTApp {
    private static EdgeWeightedGraph graph = new EdgeWeightedGraph(19);

    public static void main(String[] args) {
        buildGraph();
        testKruskalMST();
        testPrimsMST();
    }

    private static void testPrimsMST() {
        AbstractMST mst = new PrimsMST(graph);
        testMST(mst);
        System.out.println("Total Prim's MST Cost=" + mst.getWeight());
    }

    private static void testKruskalMST() {
        AbstractMST mst = new KruskalMST(graph);
        testMST(mst);
        System.out.println("Total Krushkal's MST Cost=" + mst.getWeight());
    }

    private static void testMST(AbstractMST mst) {
        List<Edge> result = mst.getMst();
        for (Edge edge : result)
            System.out.println(edge);
    }

    private static void buildGraph() {
        graph.addEdge(new Edge(0, 1, 7));
        graph.addEdge(new Edge(1, 2, 4));
        graph.addEdge(new Edge(1, 3, 1));
        graph.addEdge(new Edge(2, 5, 1));
        graph.addEdge(new Edge(2, 6, 3));
        graph.addEdge(new Edge(2, 4, 2));
        graph.addEdge(new Edge(6, 5, 2));
        graph.addEdge(new Edge(6, 4, 3));
        graph.addEdge(new Edge(4, 7, 2));
        graph.addEdge(new Edge(3, 4, 5));
        graph.addEdge(new Edge(3, 7, 8));
    }
}
