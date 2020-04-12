package com.arunav.dsalgo.advancedgraphs.shortestpath;

import com.arunav.dsalgo.advancedgraphs.representation.Vertex;
import com.arunav.dsalgo.advancedgraphs.representation.directed.DirectedEdge;
import com.arunav.dsalgo.advancedgraphs.representation.directed.EdgeWeightedDigraph;

import java.util.Stack;

public class SPApp {

    public static void main(String[] args) {
        testDijkstra();
    }

    private static void testDijkstra() {
        EdgeWeightedDigraph<String> graph = new EdgeWeightedDigraph<>(8);
        graph.addEdge(new DirectedEdge<>(new Vertex<>(1, "A"), new Vertex<>(2, "B"), 4));
        graph.addEdge(new DirectedEdge<>(new Vertex<>(1, "A"), new Vertex<>(3, "C"), 1));
        graph.addEdge(new DirectedEdge<>(new Vertex<>(2, "B"), new Vertex<>(5, "E"), 1));
        graph.addEdge(new DirectedEdge<>(new Vertex<>(2, "B"), new Vertex<>(6, "F"), 3));
        graph.addEdge(new DirectedEdge<>(new Vertex<>(2, "B"), new Vertex<>(4, "D"), 1));
        graph.addEdge(new DirectedEdge<>(new Vertex<>(6, "F"), new Vertex<>(5, "E"), 2));
        graph.addEdge(new DirectedEdge<>(new Vertex<>(6, "F"), new Vertex<>(4, "D"), 3));
        graph.addEdge(new DirectedEdge<>(new Vertex<>(4, "D"), new Vertex<>(7, "G"), 2));
        graph.addEdge(new DirectedEdge<>(new Vertex<>(3, "C"), new Vertex<>(4, "D"), 3));
        graph.addEdge(new DirectedEdge<>(new Vertex<>(3, "C"), new Vertex<>(7, "G"), 8));

        DijkstraSP<String> sp = new DijkstraSP<>(graph);
        Vertex<String> source = new Vertex<>(1, "A");
        sp.shortestPath(source);
        for (int t = 1; t < graph.getVertices(); t++) {
            System.out.print(source + " to Vertex{id=" + t + "}");
            System.out.printf(" Shortest distance={%4.2f}: Path={ ", sp.distTo(t));
            Stack<DirectedEdge<String>> directedEdges = sp.pathTo(t);
            while (!directedEdges.isEmpty())
                System.out.print(directedEdges.pop() + ", ");

            System.out.println("}");
        }
    }
}
