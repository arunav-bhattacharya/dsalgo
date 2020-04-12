package com.arunav.dsalgo.advancedgraphs.util;

public class MinHeap<T extends Comparable<T>> extends Heap<T> {

    @Override
    public void insert(T item) {
        heapArray.add(nItems, item);
        shiftUp(item);
        nItems++;
    }

    @Override
    public T delete() {
        T item = heapArray.get(0);
        heapArray.set(0, heapArray.get(nItems - 1));
        shiftDown();
        nItems--;
        return item;
    }

    private void shiftUp(T item) {
        while (true) {
            int itemIdx = heapArray.indexOf(item);
            int parentIdx = (itemIdx - 1) / 2;
            if (parentIdx < 0)
                break;
            T parent = heapArray.get(parentIdx);
            if (item.compareTo(parent) < 0)
                swap(item, parent);
            else
                break;
        }
    }

    private void shiftDown() {
        int idx = 0;
        T item = heapArray.get(idx);
        while (true) {
            int leftChildIdx = getLeftChildIdx(idx);
            int rightChildIdx = getRightChildIdx(idx);
            if (leftChildIdx > 0 && rightChildIdx > 0) {
                T leftChild = heapArray.get(leftChildIdx);
                T rightChild = heapArray.get(rightChildIdx);
                T smallerChild = leftChild.compareTo(rightChild) < 0 ? leftChild : rightChild;
                if (smallerChild.compareTo(item) < 0) {
                    idx = leftChild.compareTo(rightChild) < 0 ? leftChildIdx : rightChildIdx;
                    swap(smallerChild, item);
                } else
                    break;
            } else if (leftChildIdx > 0) {
                if (heapArray.get(leftChildIdx).compareTo(item) < 0)
                    swap(heapArray.get(leftChildIdx), item);
                break;
            } else if (rightChildIdx > 0) {
                if (heapArray.get(rightChildIdx).compareTo(item) < 0)
                    swap(heapArray.get(rightChildIdx), item);
                break;
            } else
                break;
        }
    }

    @Override
    public T getRoot() {
        if (!isEmpty())
            return heapArray.get(0);
        throw new RuntimeException("MinHeap is empty");
    }
}
