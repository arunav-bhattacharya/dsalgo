package com.arunav.dsalgo.queues;

/* Circular queue implementation using array. If rear and front pointers reach max size and if still there is space
in the queue, then the pointers are reset accordingly

IMP - The front and rear pointers are moving to maintain the first and last elements in the queue. Elements in the
array are not moved. Whenever an element is pushed out of the queue, it means the front pointer is no longer keeping
track of the item. The element is however not physically moved out of array.
*/
public class Queue<T> implements IQueue<T> {

    private T queueArray[];
    private int maxSize;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int size) {
        this.maxSize = size;
        queueArray = (T[]) new Object[maxSize];
        this.front = 0;
        this.rear = -1;
        this.nItems = 0;
    }

    public void insert(T t) {
        if (!isFull()) {
            /* If rear pointer has reached the end of the array then reset it before making a new insert */
            if (this.rear == maxSize - 1)
                this.rear = -1;
            this.rear++;
            queueArray[this.rear] = t;
            this.nItems++;
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

            this.nItems--;
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
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int getNoOfItems() {
        return nItems;
    }

    public void displayQueue() {
        displayQueue(queueArray);
    }

    public void displayQueuePointers() {
        displayQueuePointers(front, rear);
    }
}
