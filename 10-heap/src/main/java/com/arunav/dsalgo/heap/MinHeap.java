package com.arunav.dsalgo.heap;

import java.util.Arrays;

public class MinHeap<T extends Comparable<T>> {

    private final static int DEFAULT_SIZE = 10;
    private HeapNode<T>[] heapArray;
    private int nItems;
    private int maxSize;

    MinHeap() {
        maxSize = DEFAULT_SIZE;
        heapArray = (HeapNode<T>[]) new HeapNode[maxSize];
        nItems = 0;
    }

    private boolean isHalfFull() {
        return (nItems >= maxSize / 2);
    }

    private boolean isQuarterFull() {
        return (nItems <= maxSize / 4);
    }

    public int getNoOfItems() {
        return nItems;
    }

    public int getSize() {
        return heapArray.length;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public T getRoot() {
        if (!isEmpty())
            return heapArray[0].getItem();
        return null;
    }

    public void insert(T item) {
        if (isHalfFull())
            grow();
        heapArray[nItems] = new HeapNode<>(item);
        trickleUp(nItems);
        nItems++;
    }

    public T delete() {
        HeapNode<T> nodeToDelete = heapArray[0];
        heapArray[0] = heapArray[--nItems];
        trickleDown();
        heapArray[nItems] = null;
        if (isQuarterFull() && (maxSize / 2) >= DEFAULT_SIZE)
            shrink();
        return nodeToDelete.getItem();
    }

    private void trickleUp(int idx) {
        int parentIdx = (idx - 1) / 2;
        HeapNode<T> temp = heapArray[idx];

        while (idx > 0 && temp.getItem().compareTo(heapArray[parentIdx].getItem()) < 0) {
            heapArray[idx] = heapArray[parentIdx];
            idx = parentIdx;
            parentIdx = (idx - 1) / 2;
        }
        heapArray[idx] = temp;
    }

    private void trickleDown() {
        int leftIdx, rightIdx, smallerIdx;
        int currIdx = 0;

        while (currIdx < nItems / 2) {
            leftIdx = 2 * currIdx + 1;
            rightIdx = leftIdx + 1;
            smallerIdx = leftIdx;

            if (rightIdx < nItems && heapArray[rightIdx].getItem().compareTo(heapArray[leftIdx].getItem()) < 0)
                smallerIdx = rightIdx;

            if (heapArray[currIdx].getItem().compareTo(heapArray[smallerIdx].getItem()) > 0)
                swap(heapArray, currIdx, smallerIdx);
            else
                break;
            currIdx = smallerIdx;
        }
    }

    private void swap(HeapNode<T>[] heapArray, int currIdx, int smallerIdx) {
        HeapNode<T> temp = heapArray[currIdx];
        heapArray[currIdx] = heapArray[smallerIdx];
        heapArray[smallerIdx] = temp;
    }

    private void grow() {
        maxSize *= 2;
        reSize();
    }

    private void shrink() {
        maxSize /= 2;
        reSize();
    }

    private void reSize() {
        HeapNode<T>[] temp = (HeapNode<T>[]) new HeapNode[maxSize];
        copyArray(heapArray, temp);
        heapArray = (HeapNode<T>[]) new HeapNode[maxSize];
        copyArray(temp, heapArray);
    }

    private void copyArray(HeapNode<T>[] arr1, HeapNode<T>[] arr2) {
        for (int i = 0; i < nItems; i++)
            arr2[i] = arr1[i];
    }

    public void display() {
        Arrays.asList(heapArray).forEach(node -> {
            if (null != node)
                System.out.print(node.getItem() + " ");
        });
    }
}
