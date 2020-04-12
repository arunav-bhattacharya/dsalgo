package com.arunav.dsalgo.linkedlists;

public class SinglyLinkedList<T extends Number> implements LinkedList<T> {

    private Node<T> first;

    public SinglyLinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    @Override
    // O(1) operation
    public void insertFirst(T t) {
        Node<T> newNode = new Node<T>();
        newNode.setData(t);
        newNode.setNext(first);
        first = newNode;
    }

    @Override
    // O(1) operation
    public T deleteFirst() {
        if (!isEmpty()) {
            Node<T> nodeToDelete = first;
            first = nodeToDelete.getNext();
            return nodeToDelete.getData();
        }
        return null;
    }

    @Override
    // O(N) operation
    public void insertLast(T t) {
        Node<T> newNode = new Node<T>();
        newNode.setData(t);
        if (!isEmpty()) {
            Node<T> currentNode = first;
            while (currentNode.getNext() != null)
                currentNode = currentNode.getNext();
            currentNode.setNext(newNode);
        } else {
            first = newNode;
        }
    }

    @Override
    // O(N) operation
    public T deleteLast() {
        if (!isEmpty()) {
            Node<T> currentNode = first;
            if (first.getNext() != null) {
                while (currentNode.getNext().getNext() != null)
                    currentNode = currentNode.getNext();
                Node<T> lastNode = currentNode.getNext();
                currentNode.setNext(null);
                return lastNode.getData();
            } else {
                first = null;
                return currentNode.getData();
            }
        }
        return null;
    }

    @Override
    public boolean find(T t) {
        Node<T> currentNode = first;
        while (currentNode != null) {
            if (currentNode.getData().equals(t))
                return true;
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public void displayLinkedList() {
        displayLinkedList(first);
    }
}
