package com.arunav.dsalgo.advancedgraphs.shortestpath;

import com.arunav.dsalgo.advancedgraphs.representation.Vertex;
import com.arunav.dsalgo.advancedgraphs.representation.directed.DirectedEdge;
import com.arunav.dsalgo.advancedgraphs.representation.directed.EdgeWeightedDigraph;

import java.util.*;

/*
 * DIJKSTRA's ALGORITHM: Shortest path to all vertices from a single-source in a weightedGraph with positive weights
 *
 * Input : EdgeWeightedDigraph & source Vertex
 * Output: List of shortest-path edges
 *
 * Big O : E log V
 *
 * 1. Create a PriorityQueue of Vertex + Distance (VertexDistance), priortized by the shortest distance
 * 2. To facilitate find vertex option in the priority queue, create a Set of vertices
 * 3. Create a list of distances, indexed by vertices
 * 4. Create a list of edges in the shortest path, indexed by vertices
 * 5. Initialize the distanceTable and shortestPath lists
 *
 * 6. For finding the shortest-path from a source vertex, we update the distanceTable, vertexMap & PQ
 *    with the sourceVertex and the distance to be 0.
 * 7. Iterate through the PQ until it is empty and relax the vertices from the shortest distance vertex -
 *
 * 8. Relaxation Process -
 *      a. Iterate through the all the adjacent edges for the vertex removed from the PQ
 *      b. Get the distance from the distance table for each vertex from the vertex just removed from PQ.
 *      c. If the distance of the vertex (from-Vertex) removed from PQ + weight of the edge being iterated is less than
 *         the distance of the to-Vertex in the distance table then do the following -
 *          i.  Update the new distance in the distance table for the to-Vertex
 *          ii. Update the edgeTo table for the to-Vertex with the edge being iterated now
 *          iii.Update the PQ with the new vertex+distance
 *          iv. Update the vertexMap with the newDistance
 * */


public class DijkstraSP<T> {

    private PriorityQueue<VertexDistance> pq; // This is to keep the vertices prioritized in the order of shortest distance
    private Set<Integer> verticesInPQ; // This is used to keep track of vertices in the priority queue

    //Index to both the lists is the vertex Id
    private List<Double> distanceTable; // Keeps track of all the distances from the source vertex
    private List<DirectedEdge<T>> edgeTo; // Keeps track of all the edges in the shortest path
    private EdgeWeightedDigraph<T> graph;

    public DijkstraSP(EdgeWeightedDigraph<T> graph) {
        int nVertices = graph.getVertices();
        edgeTo = new ArrayList<>(nVertices);
        distanceTable = new ArrayList<>(nVertices);
        pq = new PriorityQueue<>(Comparator.comparingDouble(VertexDistance::getDistance));
        verticesInPQ = new HashSet<>(nVertices);
        this.graph = graph;

        // Initialize the distance Table & shortestPathEdges with entries for all vertex Ids
        // Distance table initialized to infinite distance
        // Since no edges are added to the shortest path so initialized as null
        for (int i = 0; i < nVertices; i++) {
            distanceTable.add(i, Double.MAX_VALUE);
            edgeTo.add(i, null);
        }
    }

    public void shortestPath(Vertex<T> source) {
        distanceTable.set(source.getId(), 0.0); // Update distance table with source vertex distance
        pq.add(new VertexDistance(source.getId(), 0)); // Add the source vertex & distance to priority queue
        verticesInPQ.add(source.getId()); // Add the vertex in the vertexSet to keep track of it in the PQ

        while (!pq.isEmpty())
            relax(pq.remove());
    }

    private void relax(VertexDistance vd) {

        // Iterate through each of the adj edges for the shortest element that has been dequeued
        for (DirectedEdge<T> edge : graph.adjEdges(vd.getVertexId())) {
            // Get the toVertex from the current vertex
            int toVertex = edge.getTo().getId();
            // Get the new distance = current-vertex distance + weight of the current edge
            double newDistance = distanceTable.get(vd.getVertexId()) + edge.getWeight();
            // If the new distance to the toVertex is smaller than the current distance in the distance table,
            // then update the newDistance in the distanceTable and also update the shortest-path
            if (distanceTable.get(toVertex) > newDistance) {
                distanceTable.set(toVertex, newDistance);
                edgeTo.set(toVertex, edge);
                // If the vertex is already there in the PQ, this can be determined using the vertexSet.
                // If present, then remove and add it with the new distance in PQ and also add it to vertexSet
                if (verticesInPQ.contains(toVertex))
                    pq.remove(vd);
                pq.add(new VertexDistance(toVertex, newDistance));
                verticesInPQ.add(toVertex);
            }
        }
    }

    public double distTo(int v) {
        return distanceTable.get(v);
    }

    public Stack<DirectedEdge<T>> pathTo(int v) {
        Stack<DirectedEdge<T>> path = new Stack<>();
        // Iterate through all the edges in the shortesPathEdges
        for (DirectedEdge<T> e = edgeTo.get(v); e != null; e = edgeTo.get(e.getFrom().getId()))
            path.push(e);
        return path;
    }

    private static class VertexDistance {
        private int vertexId;
        private double distance;

        VertexDistance(int vertexId, double distance) {
            this.vertexId = vertexId;
            this.distance = distance;
        }

        public int getVertexId() {
            return vertexId;
        }

        public double getDistance() {
            return distance;
        }
    }
}