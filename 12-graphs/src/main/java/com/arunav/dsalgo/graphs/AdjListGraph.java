package com.arunav.dsalgo.graphs;

import java.util.HashSet;
import java.util.Set;

public class AdjListGraph<T> extends AbstractGraph<T> {

    public AdjListGraph(GraphType graphType) {
        super(graphType);
    }

    @Override
    public void addVertex(T t) {
        if (nVertices >= MAX_VERTICES)
            throw new ArrayStoreException("Max no. of vertices reached. Can't add anymore.");
        vertexList[nVertices++] = new Vertex<>(t);
    }

    @Override
    public void addEdge(T srcVertex, T destVertex) {

        boolean isSrcVertexValid = false;
        Vertex<T> destVrtx;
        for (Vertex<T> vertex : vertexList) {
            if (vertex.getData().equals(srcVertex)) {
                isSrcVertexValid = true;
                // Iterate thru all the vertices to find the destVertex. If destVertex is present then add it to the
                // end of the last vertex linked to the srcVertex.
                if ((destVrtx = findVertex(destVertex)) != null) {
                    Vertex<T> current = vertex;
                    while (current.getNext() != null)
                        current = current.getNext();
                    current.setNext(new Vertex<>(destVertex));
                    nEdges++;

                    // If Undirected graph, then add the srcVertex to the end of the last vertex linked to the
                    // destination vertex
                    if (graphType.equals(GraphType.UNDIRECTED)) {
                        current = destVrtx;
                        while (current.getNext() != null)
                            current = current.getNext();
                        current.setNext(new Vertex<>(srcVertex));
                    }
                    break;
                } else
                    throw new IllegalArgumentException("Invalid Dest Vertex=" + destVertex);
            }
        }

        if (!isSrcVertexValid)
            throw new IllegalArgumentException("Invalid Src Vertex=" + srcVertex);
    }

    @Override
    public Set<Vertex<T>> getAdjacentVertices(T vertex) {
        Set<Vertex<T>> adjVertices = new HashSet<>();
        for (Vertex<T> vertex1 : vertexList) {
            if (vertex1 != null) {
                if (vertex1.getData().equals(vertex)) {
                    Vertex<T> current = vertex1.getNext();
                    while (current != null) {
                        adjVertices.add(current);
                        current = current.getNext();
                    }
                }
            }
        }
        return adjVertices;
    }

    @Override
    public Set<Vertex<T>> getAllVertices() {
        Set<Vertex<T>> vertices = new HashSet<>();
        for (Vertex<T> vertex : vertexList)
            vertices.add(vertex);
        return vertices;
    }

    @Override
    public Set<String> getAllEdges() {
        Set<String> edges = new HashSet<>();
        for (Vertex<T> vertex : vertexList) {
            if (vertex != null) {
                Vertex<T> current = vertex.getNext();
                while (current != null) {
                    // If edge is already in the set in an opposite order, then skip it. This is true only for
                    // undirected graphs
                    if (!edges.contains(current.getData().toString() + "-" + vertex.getData().toString()))
                        edges.add(vertex.getData().toString() + "-" + current.getData().toString());
                    current = current.getNext();
                }
            }
        }
        return edges;
    }

    @Override
    public int getInDegree(T vertex) {
        int inDegree = 0;
        for (Vertex<T> vertex1 : vertexList) {
            if (vertex1 != null) {
                Vertex<T> current = vertex1.getNext();
                while (current != null) {
                    if (current.getData().equals(vertex)) {
                        inDegree++;
                        break;
                    }
                    current = current.getNext();
                }
            }
        }
        return inDegree;
    }

    public void display() {
        for (Vertex<T> vertex : vertexList) {
            if (vertex != null) {
                Vertex<T> current = vertex.getNext();
                System.out.print("\n" + vertex + " -");
                while (current != null) {
                    System.out.print("-> " + current + " ");
                    current = current.getNext();
                }
            }
        }
    }
}
