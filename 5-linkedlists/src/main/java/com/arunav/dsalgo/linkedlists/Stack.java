package com.arunav.dsalgo.linkedlists;

public class Stack<T> {

    private DoublyLinkedList<T> linkedList;

    public Stack() {
        linkedList = new DoublyLinkedList<>();
    }

    public void push(T t) {
        linkedList.insertFirst(t);
    }

    public T pop() {
        if (!isEmpty())
            return linkedList.deleteFirst();
        return null;
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public boolean isFull() {
        return false;
    }

    public T peek() {
        if (!isEmpty())
            return linkedList.getFirstData();
        return null;
    }

    public void displayStack() {
        linkedList.displayLinkedList();
    }
}
