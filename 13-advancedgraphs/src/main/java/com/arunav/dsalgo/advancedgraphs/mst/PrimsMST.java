package com.arunav.dsalgo.advancedgraphs.mst;

import com.arunav.dsalgo.advancedgraphs.representation.undirected.Edge;
import com.arunav.dsalgo.advancedgraphs.representation.undirected.EdgeWeightedGraph;

import java.util.*;

public class PrimsMST extends AbstractMST {

    private PriorityQueue<VertexDistance> pq; // This is to keep the vertices prioritized in the order of shortest distance
    private Set<Integer> verticesInPQ; // This is used to keep track of vertices in the priority queue
    private boolean[] visited;
    private double[] distanceTo;
    private Edge[] edgeTo;

    public PrimsMST(EdgeWeightedGraph graph) {
        super(graph);
        int nVertices = graph.getVertices();
        edgeTo = new Edge[nVertices];
        distanceTo = new double[nVertices];
        pq = new PriorityQueue<>(Comparator.comparingDouble(VertexDistance::getDistance));
        verticesInPQ = new HashSet<>(nVertices);
        visited = new boolean[nVertices];

        for (int i = graph.allVertices().get(0); i < nVertices; i++)
            distanceTo[i] = Double.MAX_VALUE;
    }

    public List<Edge> getMst() {
        int source = graph.allVertices().get(0);
        distanceTo[source] = 0.0;
        pq.add(new VertexDistance(source, 0));
        verticesInPQ.add(source);

        while (!pq.isEmpty())
            visit(pq.remove());

        for (Edge edge : edgeTo)
            if (edge != null)
                mst.add(edge);
        return mst;
    }

    private void visit(VertexDistance vd) {
        int currVertex = vd.getVertex();
        visited[currVertex] = true;

        for (Edge edge : graph.adjEdges(vd.getVertex())) {
            int other = (currVertex == edge.getV1()) ? edge.getV2() : edge.getV1();
            if (visited[other])
                continue;
            double currEdgeWeight = edge.getWeight();

            if (currEdgeWeight < distanceTo[other]) {
                distanceTo[other] = currEdgeWeight;
                edgeTo[other] = edge;

                if (verticesInPQ.contains(other)) {
                    pq.remove(vd);
                }
                pq.add(new VertexDistance(other, currEdgeWeight));
                verticesInPQ.add(other);
            }
        }
    }

    public double getWeight() {
        for (Edge edge : edgeTo) {
            if (null != edge)
                weight += edge.getWeight();
        }
        return weight;
    }

    private static class VertexDistance {
        private int vertex;
        private double distance;

        VertexDistance(int vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public int getVertex() {
            return vertex;
        }

        public double getDistance() {
            return distance;
        }
    }

}