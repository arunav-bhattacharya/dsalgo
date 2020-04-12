package com.arunav.dsalgo.graphsv2.util;

import com.arunav.dsalgo.graphsv2.operations.undirected.ConnectedComponents;
import com.arunav.dsalgo.graphsv2.operations.undirected.Paths;
import com.arunav.dsalgo.graphsv2.structure.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GraphUtil {

    public static Graph<Integer> buildConnectedGraph(Graph<Integer> graph) {
        addVertices(graph, 6);
        addEdgesForConnectedGraph(graph);
        return graph;
    }

    public static Graph<Integer> buildDisconnectedGraph(Graph<Integer> graph) {
        addVertices(graph, 13);
        addEdgesForDisconnectedGraph(graph);
        return graph;
    }

    public static Graph<Integer> buildAcyclicGraph(Graph<Integer> graph) {
        addVertices(graph, 13);
        addEdgesForAcyclicGraph(graph);
        return graph;
    }

    public static Graph<Integer> buildBipartiteCyclicGraph(Graph<Integer> graph) {
        addVertices(graph, 6);
        addEdgesForBipartiteCyclicGraph(graph);
        return graph;
    }

    public static void validatePaths(Paths<Integer> paths, Graph<Integer> graph, Integer source) {
        System.out.println();
        System.out.println("Paths from " + source);
        for (int v = 0; v < graph.vertices(); v++) {
            System.out.print(source + " to " + v + ": ");
            if (paths.hasPath(v)) {
                System.out.print(source);
                Stack<Integer> stack = paths.pathTo(v);
                while (!stack.isEmpty()) {
                    Integer element = stack.pop();
                    if (!element.equals(source))
                        System.out.print("-" + element);
                }
            }
            System.out.println();
        }
    }

    public static void validateConnectedComponents(ConnectedComponents<Integer> cc, Graph<Integer> graph) {
        int count = cc.noOfConnectedComponents();
        System.out.println();
        System.out.println("Connected Components Count = " + count);
        System.out.println();
        List<Integer>[] components = new ArrayList[count];
        for (int i = 0; i < count; i++)
            components[i] = new ArrayList<>();

        for (int v = 0; v < graph.vertices(); v++)
            components[cc.getComponentId(v)].add(v);

        for (int i = 0; i < count; i++) {
            System.out.print("Component " + i + ": ");
            for (int v : components[i])
                System.out.print(v + " ");
            System.out.println();
        }
    }

    private static void addVertices(Graph<Integer> graph, int nVertices) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nVertices; i++)
            list.add(i);
        graph.addVertices(list);
    }

    private static void addEdgesForConnectedGraph(Graph<Integer> graph) {
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(0, 5);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
    }

    private static void addEdgesForDisconnectedGraph(Graph<Integer> graph) {
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(0, 5);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);
    }

    private static void addEdgesForAcyclicGraph(Graph<Integer> graph) {
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(11, 12);
    }

    private static void addEdgesForBipartiteCyclicGraph(Graph<Integer> graph) {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 0);
    }
}
