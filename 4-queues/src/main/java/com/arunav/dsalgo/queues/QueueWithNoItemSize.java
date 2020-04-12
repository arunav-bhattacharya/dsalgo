package com.arunav.dsalgo.queues;

/* In the case where there is no counter for the nuber of items in the queue, we will create a queue with size+1.
This is required to handle the corner cases in circular queue for isEmpty(), isFull() and getNoOfItems() methods*/
public class QueueWithNoItemSize<T> implements IQueue<T> {

    private T[] queueArray;
    private int maxSize;
    private int front;
    private int rear;

    public QueueWithNoItemSize(int size) {
        this.maxSize = size + 1;
        queueArray = (T[]) new Object[maxSize];
        this.front = 0;
        this.rear = -1;
    }

    public void insert(T t) {
        if (!isFull()) {
            /* If rear pointer has reached the end of the array then reset it before making a new insert */
            if (this.rear == maxSize - 1)
                this.rear = -1;
            this.rear++;
            queueArray[this.rear] = t;
            System.out.println("Inserted=" + t);
        } else {
            System.out.println("Can't insert. Queue is Full");
        }
    }

    public T remove() {
        if (!isEmpty()) {
            int oldFront = this.front++;
            /* If front pointer has reached the end of the array then reset the front pointer before removing */
            if (front == maxSize)
                front = 0;
            return queueArray[oldFront];
        } else {
            System.out.println("Queue is Empty");
            throw new RuntimeException();
        }
    }

    public T peek() {
        return queueArray[this.front];
    }

    public boolean isEmpty() {
        return (rear + 1 == front || ((front + maxSize - 1) == rear));
    }

    public boolean isFull() {
        return (rear + 2 == front || ((front + maxSize - 2) == rear));
    }

    public int getNoOfItems() {
        if (rear >= front)
            return rear - front + 1;
        else
            return (maxSize - front) + rear + 1;
    }

    public void displayQueue() {
        displayQueue(queueArray);
    }

    public void displayQueuePointers() {
        displayQueuePointers(front, rear);
    }
}
