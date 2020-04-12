package com.arunav.dsalgo.heap;

import java.util.Arrays;

public class MaxHeap<T extends Comparable<T>> {

    private int nItems;
    private int maxSize;
    private T[] arr;

    public MaxHeap(int size) {
        nItems = 0;
        maxSize = size;
        this.arr = (T[]) new Comparable[maxSize];
    }

    private boolean isFull() {
        return nItems == maxSize;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean insert(T data) {
        if (isFull())
            return false;
        arr[nItems] = data;
        trickleUp(nItems);
        nItems++;
        return true;
    }

    private void trickleUp(int index) {
        int parentIdx = (index - 1) / 2;
        T data = arr[index];
        while (index > 0 && data.compareTo(arr[parentIdx]) > 0) {
            arr[index] = arr[parentIdx];
            index = parentIdx;
            parentIdx = (index - 1) / 2;
        }
        arr[index] = data;
    }

    public T delete() {
        T root = arr[0];
        arr[0] = arr[--nItems];
        arr[nItems] = root;
        trickleDown(0);
        return root;
    }

    private void trickleDown(int idx) {
        int leftIdx, rightIdx;
        int largerChildIdx;

        while (idx < nItems / 2) {
            leftIdx = 2 * idx + 1;
            rightIdx = leftIdx + 1;
            largerChildIdx = leftIdx;
            if (rightIdx < nItems && arr[leftIdx].compareTo(arr[rightIdx]) < 0)
                largerChildIdx = rightIdx;

            if (arr[idx].compareTo(arr[largerChildIdx]) < 0)
                swap(arr, idx, largerChildIdx);
            else
                break;
            idx = largerChildIdx;
        }
    }

    private void swap(T[] arr, int idx, int largerChildIdx) {
        T temp = arr[idx];
        arr[idx] = arr[largerChildIdx];
        arr[largerChildIdx] = temp;
    }

    public void display() {
        Arrays.asList(arr).forEach(i -> System.out.print(i + " "));
    }
}
