package com.arunav.dsalgo.graphs;

import com.arunav.dsalgo.linkedlists.Queue;

import java.util.*;

public abstract class AbstractGraph<T> implements Graph<T> {

    protected final static int MAX_VERTICES = 20;
    protected Vertex<T>[] vertexList;
    protected int nVertices;
    protected int nEdges;
    protected GraphType graphType;
    private Map<T, Boolean> isVisited;

    AbstractGraph(GraphType graphType) {
        vertexList = (Vertex<T>[]) new Vertex[MAX_VERTICES];
        this.nVertices = 0;
        this.nEdges = 0;
        this.graphType = graphType;
    }

    public abstract void addVertex(T t);

    public abstract void addEdge(T srcVertex, T destVertex);

    public abstract Set<Vertex<T>> getAdjacentVertices(T vertex);

    public abstract Set<Vertex<T>> getAllVertices();

    public abstract Set<String> getAllEdges();

    public abstract int getInDegree(T vertex);

    @Override
    public void dfs(T vertexData) {
        Vertex<T> vertex;
        if ((vertex = findVertex(vertexData)) != null) {
            isVisited = new HashMap<>();
            init(isVisited);
            dfs(vertex);
            init(isVisited);
        } else
            throw new IllegalArgumentException("Invalid Vertex=" + vertexData);
    }

    @Override
    public void bfs(T vertexData) {
        Vertex<T> vertex;
        if ((vertex = findVertex(vertexData)) != null) {
            isVisited = new HashMap<>();
            init(isVisited);
            bfs(vertex);
            init(isVisited);
        } else
            throw new IllegalArgumentException("Invalid Vertex=" + vertexData);
    }

    private void dfs(Vertex<T> vertex) {
        // 1. Check if the vertex passed as argument is already visited
        if (!isVisited.get(vertex.getData())) {
            // 2. If the vertex is not visited, mark it as visited now
            isVisited.put(vertex.getData(), true);
            // 3. Visit the vertex --- In all practical examples, here the actual processing logic will go in
            System.out.print(" -> " + vertex.getData());
            // 4. Get the adjacent vertices of the current vertex
            Set<Vertex<T>> adjacentVertices = getAdjacentVertices(vertex.getData());
            // 5. Iterate through the adjacent vertices, if any of the vertex is not visited then recursively call dfs
            for (Vertex<T> vertex1 : adjacentVertices) {
                if (!isVisited.get(vertex1.getData())) {
                    dfs(vertex1);
                }
            }
        }
    }

    private void bfs(Vertex<T> vertex) {
        // 1. Insert the vertex (on which bfs is to be done) into a queue
        Queue<Vertex<T>> queue = new Queue<>();
        queue.insert(vertex);
        // 2. Iterate until the queue is empty
        while (!queue.isEmpty()) {
            // 3. Get the next element from the queue
            Vertex<T> current = queue.remove();
            // 4. If the element is already visited, then ignore. Else, do the next steps
            if (!isVisited.get(current.getData())) {
                // 5. Mark the element as visited
                isVisited.put(current.getData(), true);
                // 6. Visit the vertex -- In all practical examples, here the actual processing logic will go in
                System.out.print(" -> " + current.getData());
                // 7. Get the adjacent vertices
                Set<Vertex<T>> adjacentVertices = getAdjacentVertices(current.getData());
                // 8. If any of the adjacent vertices is not previously visited, then add it to the queue
                for (Vertex<T> vertex1 : adjacentVertices)
                    if (!isVisited.get(vertex1.getData()))
                        queue.insert(vertex1);
            }
        }
    }

    protected Vertex<T> findVertex(T vertexData) {
        for (Vertex<T> vertex : vertexList)
            if (vertex.getData().equals(vertexData))
                return vertex;
        return null;
    }

    private void init(Map<T, Boolean> visitedMap) {
        for (Vertex<T> vertex1 : vertexList) {
            if (vertex1 != null)
                visitedMap.put(vertex1.getData(), false);
        }
    }

    @Override
    public int numOfVertices() {
        return this.nVertices;
    }

    @Override
    public int numOfEdges() {
        return this.nEdges;
    }

    public List<T> topoSort() {
        if (this.graphType == GraphType.DIRECTED)
            return topologicalSort();
        else
            throw new UnsupportedOperationException("Topological Sort is not supported on UNDIRECTED graph");
    }

    private List<T> topologicalSort() {
        Map<T, Integer> inDegreeMap = new HashMap<>();
        Queue<T> queue = new Queue<>();

        // 1. Calculate the indegrees of all the vertices and store it in a HashMap mapping to the vertices
        // 2. Insert the indegrees of value 0 to a queue
        for (Vertex<T> vertex : vertexList) {
            if (vertex != null) {
                int inDegree = getInDegree(vertex.getData());
                inDegreeMap.put(vertex.getData(), inDegree);
                if (inDegree == 0)
                    queue.insert(vertex.getData());
            }
        }

        List<T> sortedVertices = new ArrayList<>();
        // 3. Iterate until queue is empty
        while (!queue.isEmpty()) {
            // 4. Get the next vertex from the queue & add it to the sorted list
            T vertex = queue.remove();
            sortedVertices.add(vertex);

            // 5. Get all vertices adjacent to the current vertex
            Set<Vertex<T>> adjacentVertices = getAdjacentVertices(vertex);
            // 6. For each adjacent vertex, re-calculate the in-degrees by fetching the latest value from the map and
            // reducing by 1 and store the update indegree back inside the map. If indegree of any of the adjacent
            // vertices happens to be 0, add it to the queue.
            for (Vertex<T> adjVertex : adjacentVertices) {
                int newInDegree = inDegreeMap.get(adjVertex.getData()) - 1;
                inDegreeMap.put(adjVertex.getData(), newInDegree);
                if (newInDegree == 0)
                    queue.insert(adjVertex.getData());
            }
        }

        // 7. Return the sorted list. If the count of elements in the sorted list don't match with the no. of
        // elements in the graph, there was definitely a cycle in the graph
        if (sortedVertices.size() != nVertices)
            throw new RuntimeException("The graph has a cycle. Can't do a topological sort on it");

        return sortedVertices;
    }
}
