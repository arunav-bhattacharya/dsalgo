package com.arunav.dsalgo.queues;

public class QueueApp {

    public static void main(String[] args) {
        testCircularQueue();
        testCircularQueueWithNoItemSize();
        testPriorityQueue();
    }

    private static void testPriorityQueue() {
        System.out.println("\nTesting PriorityQueue.....\n");
        PriorityQueue queue = new PriorityQueue(5);
        queue.insert(20);
        queue.insert(40);
        queue.insert(10);
        queue.displayQueue();
        queue.insert(30);
        queue.insert(5);
        queue.displayQueue();
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
    }

    private static void testCircularQueue() {
        System.out.println("\nTesting CircularQueue.....\n");
        Queue<Integer> integerQueue = new Queue<>(5);
        performQueueOperations(integerQueue);
    }

    private static void testCircularQueueWithNoItemSize() {
        System.out.println("\nTesting CircularQueueWithNoItemSize.....\n");
        QueueWithNoItemSize<Integer> integerQueue = new QueueWithNoItemSize<>(5);
        performQueueOperations(integerQueue);
    }

    private static void performQueueOperations(IQueue queue) {
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);
        queue.insert(60);  // Queue is Full message should be thrown

        queue.displayQueue();
        queue.displayQueuePointers();

        System.out.println("\nRemove=" + queue.remove());

        queue.displayQueue();
        queue.displayQueuePointers();

        queue.insert(60);

        queue.displayQueue();
        queue.displayQueuePointers();

        System.out.println("Remove=" + queue.remove());
        queue.insert(99);
        queue.displayQueue();
        queue.displayQueuePointers();

        System.out.println("Remove=" + queue.remove());
        System.out.println("Remove=" + queue.remove());
        System.out.println("Remove=" + queue.remove());

        queue.displayQueue();
        queue.displayQueuePointers();

        System.out.println("No. of Elements=" + queue.getNoOfItems());
        System.out.println("Peek queue front=" + queue.peek());
    }
}
