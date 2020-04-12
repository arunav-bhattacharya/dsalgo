package com.arunav.dsalgo.heap;

public class PriorityQueue<T extends Comparable<T>> {

    private MinHeap<T> minHeap;

    PriorityQueue() {
        minHeap = new MinHeap<>();
    }

    public void enqueue(T key) {
        minHeap.insert(key);
    }

    public T dequeue() {
        return minHeap.delete();
    }

    public T peek() {
        return minHeap.getRoot();
    }

    public void displayQueue() {
        minHeap.display();
    }
}
