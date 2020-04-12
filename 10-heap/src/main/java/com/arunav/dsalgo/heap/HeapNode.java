package com.arunav.dsalgo.heap;

public class HeapNode<T extends Comparable<T>> {

    private T item;

    public HeapNode(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
