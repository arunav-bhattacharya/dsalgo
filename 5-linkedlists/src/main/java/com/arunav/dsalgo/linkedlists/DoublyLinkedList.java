package com.arunav.dsalgo.linkedlists;

public class DoublyLinkedList<T> implements LinkedList<T> {

    private DNode<T> first;
    private DNode<T> last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public T getFirstData() {
        return first.getData();
    }

    public T getLastData() {
        return last.getData();
    }

    @Override
    // O(1) operation
    public void insertFirst(T t) {
        DNode<T> newNode = new DNode<>();
        newNode.setData(t);
        newNode.setNext(first);
        if (!isEmpty())
            first.setPrev(newNode);
        else
            last = newNode;
        first = newNode;
    }

    @Override
    // O(1) operation
    public void insertLast(T t) {
        DNode<T> newNode = new DNode<>();
        newNode.setData(t);
        newNode.setPrev(last);
        if (!isEmpty())
            last.setNext(newNode);
        else
            first = newNode;
        last = newNode;
    }

    @Override
    public T deleteFirst() {
        DNode<T> nodeToDelete = first;
        if (!isEmpty()) {
            if (first.getNext() != null)
                first.getNext().setPrev(null);
            first = first.getNext();
            return nodeToDelete.getData();
        }
        return null;
    }

    @Override
    public T deleteLast() {
        DNode<T> nodeToDelete = last;
        if (!isEmpty()) {
            if (last.getPrev() != null)
                last.getPrev().setNext(null);
            last = last.getPrev();
            return nodeToDelete.getData();
        }
        return null;
    }

    @Override
    public boolean find(T t) {
        DNode<T> currentNode = first;
        while (currentNode != null) {
            if (currentNode.getData() == t)
                break;
            currentNode = currentNode.getNext();
        }
        return (currentNode != null);
    }

    @Override
    public boolean isEmpty() {
        return (first == null);
    }

    @Override
    public void displayLinkedList() {
        displayLinkedList(first);
    }
}
