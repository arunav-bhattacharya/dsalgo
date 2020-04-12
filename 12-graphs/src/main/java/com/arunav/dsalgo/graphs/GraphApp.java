package com.arunav.dsalgo.graphs;

import java.util.Arrays;
import java.util.List;

public class GraphApp {

    static final int NO_OF_ELEMENTS = 5;

    public static void main(String[] args) {
        System.out.println("\n\nU N D I R E C T E D    A D J A C E N C Y    M A T R I X");
        System.out.println("========================================================");
        testGraph(new AdjMatrixGraph<>(Graph.GraphType.UNDIRECTED));

        System.out.println("\n\nU N D I R E C T E D    A D J A C E N C Y    L I S T");
        System.out.println("===================================================");
        testGraph(new AdjListGraph<>(Graph.GraphType.UNDIRECTED));

        System.out.println("\n\nD I R E C T E D    A D J A C E N C Y    M A T R I X");
        System.out.println("===================================================");
        //testGraph(new AdjMatrixGraph<>(Graph.GraphType.DIRECTED));

        System.out.println("\n\nD I R E C T E D    A D J A C E N C Y    L I S T");
        System.out.println("===============================================");
        testGraph(new AdjListGraph<>(Graph.GraphType.DIRECTED));
    }

    private static void testGraph(AbstractGraph<Integer> graph) {
        Integer[] vertexList = {57, 75, 62, 16, 47};
        for (Integer i : vertexList)
            graph.addVertex(i);

/*      //Integer vertex;
        //String[] vertexList = new String[NO_OF_ELEMENTS];
        //Integer[] vertexList = new Integer[NO_OF_ELEMENTS];
        for (int i = 0; i < NO_OF_ELEMENTS; i++) {
            vertex = new Random().nextInt(99);
            //vertex = RandomStringUtils.random(2, true, false).toLowerCase();
            graph.addVertex(vertex);
            vertexList[i] = vertex;
        }*/

        System.out.println("No of Vertices=" + graph.numOfVertices());
        for (int i = 0; i < vertexList.length; i++)
            System.out.println(i + " -> " + vertexList[i]);

        graph.addEdge(vertexList[0], vertexList[1]);
        //graph.addEdge(vertexList[1], vertexList[2]);
        graph.addEdge(vertexList[1], vertexList[3]);
        graph.addEdge(vertexList[2], vertexList[3]);
        graph.addEdge(vertexList[2], vertexList[4]);
        //graph.addEdge(vertexList[3], vertexList[4]);
        graph.addEdge(vertexList[4], vertexList[0]);
        //graph.addEdge(vertexList[5], vertexList[9]);
        //graph.addEdge(vertexList[6], vertexList[3]);
        //graph.addEdge(vertexList[7], vertexList[5]);
        //graph.addEdge(vertexList[8], vertexList[0]);
        //graph.addEdge(vertexList[9], vertexList[1]);
        //graph.addEdge(vertexList[0], vertexList[7]);
        //graph.addEdge(vertexList[1], vertexList[6]);


        System.out.println("No of Edges= " + graph.numOfEdges());
        for (String edge : graph.getAllEdges())
            System.out.println(edge);

        Arrays.asList(vertexList).forEach(vrtx -> {
            System.out.println("\nAdjacent Vertices of Vertex=" + vrtx);
            Arrays.asList(graph.getAdjacentVertices(vrtx)).forEach(System.out::print);
        });

/*        System.out.print("\n\nD F S");
        System.out.print("\n=====");
        for (int i = 0; i < vertexList.length; i++) {
            System.out.println("\nDFS for " + vertexList[i]);
            graph.dfs(vertexList[i]);
        }

        System.out.print("\n\nB F S");
        System.out.print("\n=====");
        for (int i = 0; i < vertexList.length; i++) {
            System.out.println("\nBFS for " + vertexList[i]);
            graph.bfs(vertexList[i]);
        }*/

        System.out.println();
        if (graph.graphType == Graph.GraphType.DIRECTED) {
            for (int i = 0; i < vertexList.length; i++)
                System.out.println("Indegree for " + vertexList[i] + " = " + graph.getInDegree(vertexList[i]));
        }

        if (graph.graphType == Graph.GraphType.DIRECTED) {
            System.out.println("Topologically Sorted Graph");
            List<Integer> vertices = graph.topoSort();
            for (Integer vertex : vertices)
                System.out.print(vertex + " ");
        }
    }
}