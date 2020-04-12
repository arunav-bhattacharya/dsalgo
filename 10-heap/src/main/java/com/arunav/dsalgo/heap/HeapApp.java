package com.arunav.dsalgo.heap;

import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;

public class HeapApp {

    public static void main(String[] args) {

        testPriorityQueue();
        //testMaxHeap();
        //testMinHeap();
    }

    private static void testPriorityQueue() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Integer random;
        for (int i = 0; i < 11; i++) {
            //random = RandomStringUtils.random(5, true, false);
            random = new Random().nextInt(100);
            System.out.print(random + " ");
            queue.enqueue(random);
        }
        System.out.println("\nDisplay Queue: ");
        queue.displayQueue();

        while (null != queue.peek()) {
            Integer deletedElement = queue.dequeue();
            System.out.println("\nDeleted " + deletedElement);
            System.out.println("\nDisplay Queue: ");
            queue.displayQueue();
        }
    }

    private static void testMinHeap() {
        MinHeap<String> minHeap = new MinHeap<>();
        String random;
        boolean useLetters = true;
        boolean useNumbers = false;
        for (int i = 0; i < 11; i++) {
            random = RandomStringUtils.random(5, useLetters, useNumbers);
            //random = new Random().nextInt(100);
            System.out.print(random + " ");
            minHeap.insert(random);
        }
        System.out.println();
        minHeap.display();

        while (!minHeap.isEmpty()) {
            String deletedElement = minHeap.delete();
            System.out.println("\nDeleted " + deletedElement);
            minHeap.display();
        }
    }

    private static void testMaxHeap() {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(20);
        int random;
        for (int i = 0; i < 10; i++) {
            random = new Random().nextInt(100);
            System.out.print(random + " ");
            maxHeap.insert(random);
        }
        System.out.println();
        maxHeap.display();

        while (!maxHeap.isEmpty()) {
            Integer deletedElement = maxHeap.delete();
            System.out.println("\nDeleted " + deletedElement);
            maxHeap.display();
        }
    }
}
