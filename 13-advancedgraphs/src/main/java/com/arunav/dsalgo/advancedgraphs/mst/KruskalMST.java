package com.arunav.dsalgo.advancedgraphs.mst;

import com.arunav.dsalgo.advancedgraphs.representation.undirected.Edge;
import com.arunav.dsalgo.advancedgraphs.representation.undirected.EdgeWeightedGraph;
import com.arunav.dsalgo.unionfind.UnionFind;

import java.util.List;

/*
 * Big O Time Complexity - E log E
 *
 * Steps for finding MST using Kruskal's Algorithm -
 *
 * A. Pre-requisite:
 *   1. Create Edge with v1, v2, weight
 *   2. Create EdgeWeightedGraph as List<List<Edge>> and define the following methods -
 *       - addEdge(v1, v2)
 *       - allEdges()
 *       - allVertices()
 *       - adjEdges(v)
 *   3. Define a UnionFind data-structure defining following methods -
 *       - add(v)
 *       - union(v1, v2)
 *       - find(v)
 *
 * B. Processing:
 *   0. Input is an edgeWeightedGraph graph
 *   1. Get all edges from the graph using graph.allEdges()
 *   2. Sort the edges based on weights
 *   3. Get all vertices from the graph using graph.allVertices()
 *   4. Add the vertices to a unionFind instance
 *   5. Iterate through all edges and do the following -
 *      - a. Get the roots for each of the 2 vertices of the edge in the unionFind
 *      - b. If both the vertices have the same root, it means it is forming a cycle and we ignore that vertex
 *      - c. If they don't form a cycle, then add to the MST and calculate the total weight of the MST
 * */

public class KruskalMST extends AbstractMST {

    private List<Edge> allEdges;

    public KruskalMST(EdgeWeightedGraph graph) {
        super(graph);
        allEdges = graph.allEdges();
        allEdges.sort((e1, e2) -> (int) (e1.getWeight() - e2.getWeight()));
    }

    public List<Edge> getMst() {
        UnionFind<Integer> unionFind = new UnionFind<>();

        for (int vertex : graph.allVertices())
            unionFind.add(vertex);

        for (Edge edge : allEdges) {
            Integer root1 = unionFind.find(edge.getV1());
            Integer root2 = unionFind.find(edge.getV2());

            if (!root1.equals(root2)) {
                mst.add(edge);
                unionFind.union(edge.getV1(), edge.getV2());
                weight += edge.getWeight();
            }
        }
        return mst;
    }

    public double getWeight() {
        return weight;
    }
}
