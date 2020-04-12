package com.arunav.dsalgo.linkedlists;

public interface LinkedList<T> {

    void insertFirst(T t);

    void insertLast(T t);

    T deleteFirst();

    T deleteLast();

    boolean find(T t);

    boolean isEmpty();

    void displayLinkedList();

    default void displayLinkedList(Node<T> first) {
        Node<T> currentNode = first;
        System.out.print("Linked List= { ");
        while (currentNode != null) {
            if (currentNode.getNext() != null)
                System.out.print(currentNode.getData() + " -> ");
            else
                System.out.print(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        System.out.print(" }");
    }

    default void displayLinkedList(DNode<T> first) {
        DNode<T> currentNode = first;
        System.out.print("Linked List= { ");
        while (currentNode != null) {
            if (currentNode.getNext() != null)
                System.out.print(currentNode.getData() + " -> ");
            else
                System.out.print(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        System.out.print(" }");
    }
}
