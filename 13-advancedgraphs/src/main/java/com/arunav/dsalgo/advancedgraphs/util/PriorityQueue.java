package com.arunav.dsalgo.advancedgraphs.util;

public class PriorityQueue<T extends Comparable<T>> {

    private MinHeap<T> minHeap;

    public PriorityQueue() {
        minHeap = new MinHeap<>();
    }

    public void enqueue(T item) {
        minHeap.insert(item);
    }

    public T dequeue() {
        return minHeap.delete();
    }

    public T peek() {
        return minHeap.getRoot();
    }

    public void display() {
        minHeap.printHeap();
    }
}
