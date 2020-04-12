package com.arunav.dsalgo.graphs;

public class Vertex<T> {

    private T data;
    private Vertex<T> next;

    public Vertex(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Vertex<T> getNext() {
        return next;
    }

    public void setNext(Vertex<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return data + "";
    }
}
