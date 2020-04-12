package com.arunav.dsalgo.graphs;

import java.util.HashSet;
import java.util.Set;

public class AdjMatrixGraph<T> extends AbstractGraph<T> {

    private int[][] adjMatrix;

    public AdjMatrixGraph(GraphType graphType) {
        super(graphType);
        adjMatrix = new int[MAX_VERTICES][MAX_VERTICES];
        for (int i = 0; i < MAX_VERTICES; i++)
            for (int j = 0; j < MAX_VERTICES; j++)
                adjMatrix[i][j] = 0;
    }

    public void addVertex(T t) {
        if (nVertices >= MAX_VERTICES)
            throw new ArrayStoreException("Cannot add any more vertices");
        vertexList[nVertices++] = new Vertex<>(t);
    }

    public void addEdge(T srcVertex, T destVertex) {
        int srcVertexIdx = -1, destVertexIdx = -1;
        for (int i = 0; i < nVertices; i++) {
            if (vertexList[i].getData().equals(srcVertex))
                srcVertexIdx = i;
            if (vertexList[i].getData().equals(destVertex))
                destVertexIdx = i;
            if (srcVertexIdx != -1 && destVertexIdx != -1)
                break;
        }
        if (srcVertexIdx == -1 || destVertexIdx == -1)
            throw new IllegalArgumentException("Invalid vertex indices. SourceIdx=" + srcVertex + " DestIdx=" + destVertex);

        adjMatrix[srcVertexIdx][destVertexIdx] = 1;
        if (this.graphType == GraphType.UNDIRECTED)
            adjMatrix[destVertexIdx][srcVertexIdx] = 1;
        this.nEdges++;
    }

    public Set<Vertex<T>> getAdjacentVertices(T vertex) {
        int i = 0;
        for (; i < nVertices; i++)
            if (vertexList[i].getData().equals(vertex))
                break;
        if (i >= nVertices)
            throw new IllegalArgumentException("Invalid vertex");

        int j = i;
        Set<Vertex<T>> adjVertices = new HashSet<>();
        for (i = 0; i < nVertices; i++)
            if (adjMatrix[j][i] == 1)
                adjVertices.add(vertexList[i]);
        return adjVertices;
    }

    public Set<Vertex<T>> getAllVertices() {
        Set<Vertex<T>> vertices = new HashSet<>();
        for (int i = 0; i < nVertices; i++)
            vertices.add(vertexList[i]);
        return vertices;
    }

    public Set<String> getAllEdges() {
        Set<String> edges = new HashSet<>();
        for (int i = 0; i < nVertices; i++)
            for (int j = 0; j < nVertices; j++)
                if (adjMatrix[i][j] == 1)
                    if (!edges.contains(vertexList[j].toString() + "-" + vertexList[i].toString()))
                        edges.add(vertexList[i].toString() + "-" + vertexList[j].toString());
        return edges;
    }

    @Override
    public int getInDegree(T vertex) {
        int inDegree = 0;
        int idx = 0;
        //Get the index of the vertex from the vertexList array
        for (; idx < nVertices; idx++) {
            if (vertexList[idx].getData().equals(vertex))
                break;
        }
        //Iterate through all the rows of the column idx
        for (int i = 0; i < nVertices; i++) {
            if (adjMatrix[i][idx] == 1)
                inDegree++;
        }
        return inDegree;
    }

    public void display() {

    }
}
