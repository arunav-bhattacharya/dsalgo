package com.arunav.dsalgo.linkedlists;

public class Queue<T> {

    private DoublyLinkedList<T> doublyLinkedList;
    private int nItems;

    public Queue() {
        doublyLinkedList = new DoublyLinkedList<>();
    }

    public void insert(T t) {
        doublyLinkedList.insertLast(t);
        nItems++;
    }

    public T remove() {
        if (!isEmpty()) {
            nItems--;
            return doublyLinkedList.deleteFirst();
        }
        return null;
    }

    public T peek() {
        if (!isEmpty())
            return doublyLinkedList.getLastData();
        return null;
    }

    public boolean isEmpty() {
        return doublyLinkedList.isEmpty();
    }

    public boolean isFull() {
        return false;
    }

    public int getNoOfItems() {
        return nItems;
    }

    public void displayQueue() {
        doublyLinkedList.displayLinkedList();
    }
}
