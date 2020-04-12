package com.arunav.dsalgo.queues;

/* In this implementation of PriorityQueue, the smallest item is stored at the end of the array and the removal
happens for the smallest item from the end of the array. There are no separate front and rear pointers in this
implementation as the actual positions inside the array are shifted positions during insert and during removal just
the counter(nItems) is decremented and losing the reference of the previous values in the array */
public class PriorityQueue {

    private long[] queueArray;
    private int maxSize;
    private int nItems;

    PriorityQueue(int size) {
        maxSize = size;
        queueArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long item) {
        if (!isFull()) {
            if (nItems == 0)
                queueArray[nItems++] = item;
            else {
                int i;
                for (i = nItems - 1; i >= 0; i--) {
                    if (item > queueArray[i])
                        queueArray[i + 1] = queueArray[i];
                    else
                        break;
                }
                queueArray[i + 1] = item;
                nItems++;
            }
        }
    }

    public long remove() {
        if (!isEmpty()) {
            return queueArray[--nItems];
        } else {
            System.out.println("Queue is Empty, can't remove");
            throw new RuntimeException();
        }
    }

    public long peek() {
        return queueArray[--nItems];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int getNoOfItems() {
        return nItems;
    }

    public void displayQueue() {
        System.out.print("Priority Queue = [");
        for (long value : queueArray) {
            System.out.print(value + " ");
        }
        System.out.println("]");
    }
}
