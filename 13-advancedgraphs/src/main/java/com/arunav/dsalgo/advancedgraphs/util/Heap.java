package com.arunav.dsalgo.advancedgraphs.util;

import java.util.ArrayList;
import java.util.List;

public abstract class Heap<T extends Comparable<T>> {

    protected List<T> heapArray;
    protected int nItems;

    public Heap() {
        nItems = 0;
        heapArray = new ArrayList<>();
    }

    protected boolean isEmpty() {
        return nItems == 0;
    }

    protected void swap(T item1, T item2) {
        int item1Idx = heapArray.indexOf(item1);
        int item2Idx = heapArray.indexOf(item2);
        heapArray.set(item1Idx, item2);
        heapArray.set(item2Idx, item1);
    }

    protected int getLeftChildIdx(int idx) {
        int leftChildIdx = 2 * idx + 1;
        if (leftChildIdx >= nItems)
            return -1;
        return leftChildIdx;
    }

    protected int getRightChildIdx(int idx) {
        int rightChildIdx = 2 * idx + 2;
        if (rightChildIdx >= nItems)
            return -1;
        return rightChildIdx;
    }

    public void printHeap() {
        System.out.println(heapArray.toString());
    }

    public abstract void insert(T item);

    public abstract T delete();

    public abstract T getRoot();
}
