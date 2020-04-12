package com.arunav.dsalgo.linkedlists;

public class CircularLinkedList<T extends Number> implements LinkedList<T> {

    private Node<T> first;
    private Node<T> last;

    public CircularLinkedList() {
        first = null;
        last = null;
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
        if (isEmpty())
            last = newNode;
        first = newNode;
    }

    @Override
    // O(1) operation
    public T deleteFirst() {
        if (!isEmpty()) {
            Node<T> nodeToDelete = first;
            first = first.getNext();
            return nodeToDelete.getData();
        } else
            return null;
    }

    @Override
    // O(1) operation
    public void insertLast(T t) {
        Node<T> newNode = new Node<T>();
        newNode.setData(t);
        if (isEmpty())
            first = newNode;
        else
            last.setNext(newNode);
        last = newNode;
    }

    @Override
    // O(N) operation
    public T deleteLast() {
        if (!isEmpty()) {
            Node<T> currentNode = first;
            if (first != last) {
                while (currentNode.getNext() != last) {
                    currentNode = currentNode.getNext();
                }
                Node<T> lastNode = currentNode.getNext();
                currentNode.setNext(null);
                last = currentNode;
                return lastNode.getData();
            } else {
                first = null;
                last = null;
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
