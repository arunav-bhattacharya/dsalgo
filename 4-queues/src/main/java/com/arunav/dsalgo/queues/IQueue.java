package com.arunav.dsalgo.queues;

import java.util.Arrays;

public interface IQueue<T> {

    void insert(T t);

    T remove();

    T peek();

    boolean isEmpty();

    boolean isFull();

    int getNoOfItems();

    void displayQueue(); //Not required when implementing a Queue, kept it for ease of use

    void displayQueuePointers(); //Not required when implementing a Queue, kept it for ease of use

    default void displayQueue(T[] queueArray) {
        System.out.println("");
        Arrays.asList(queueArray).forEach(value -> {
            System.out.print(value + " ");
        });
    }

    default void displayQueuePointers(int front, int rear) {
        System.out.println("\nFront: " + front + " Rear: " + rear);
    }
}
