package com.arunav.dsalgo.advancedgraphs.representation;

public class Vertex<T> {

    private int id;
    private T vertex;

    public Vertex(int id, T vertex) {
        this.id = id;
        this.vertex = vertex;
    }

    public int getId() {
        return id;
    }

    public T getVertex() {
        return vertex;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id=" + id +
                '}';
    }
}
