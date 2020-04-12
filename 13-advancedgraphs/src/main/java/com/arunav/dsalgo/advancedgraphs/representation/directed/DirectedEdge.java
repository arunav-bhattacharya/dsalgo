package com.arunav.dsalgo.advancedgraphs.representation.directed;

import com.arunav.dsalgo.advancedgraphs.representation.Vertex;

public class DirectedEdge<T> {

    private Vertex<T> from;
    private Vertex<T> to;
    private double weight;

    public DirectedEdge(Vertex<T> from, Vertex<T> to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Vertex<T> getFrom() {
        return from;
    }

    public Vertex<T> getTo() {
        return to;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return String.format("%d->%d %.2f", from.getId(), to.getId(), weight);
    }
}
