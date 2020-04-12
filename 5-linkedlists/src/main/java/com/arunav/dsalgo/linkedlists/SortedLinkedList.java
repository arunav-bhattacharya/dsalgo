package com.arunav.dsalgo.linkedlists;

public class SortedLinkedList<T extends Comparable<T>> {

    DNode<T> first;
    DNode<T> last;

    public SortedLinkedList() {
        first = null;
        last = null;
    }

    public void insert(T t) {
        DNode<T> newNode = new DNode<>();
        newNode.setData(t);
        if (!isEmpty()) {
            DNode<T> currentNode = first;
            while (currentNode != null) {
                //Check t < currentNode.getData()
                if (currentNode.getData().compareTo(t) >= 0) {
                    if (currentNode.getPrev() != null) {
                        currentNode.getPrev().setNext(newNode);
                        newNode.setPrev(currentNode.getPrev());
                    } else
                        first = newNode;
                    newNode.setNext(currentNode);
                    currentNode.setPrev(newNode);
                    break;
                }
                currentNode = currentNode.getNext();
            }
            if (currentNode == null) {
                last.setNext(newNode);
                newNode.setPrev(last);
                last = newNode;
            }
        } else {
            first = newNode;
            last = newNode;
        }
    }

    public boolean delete(T t) {
        DNode<T> currentNode = first;
        while (currentNode != null) {
            if (currentNode.getData().equals(t)) {
                if (currentNode.getNext() != null && currentNode.getPrev() != null) {
                    currentNode.getPrev().setNext(currentNode.getNext());
                    currentNode.getNext().setPrev(currentNode.getPrev());
                } else if (currentNode.getNext() != null) {
                    currentNode.getNext().setPrev(null);
                    first = currentNode.getNext();
                } else {
                    currentNode.getPrev().setNext(null);
                    last = currentNode.getPrev();
                }
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    public boolean find(T t) {
        DNode<T> currentNode = first;
        while (currentNode != null) {
            if (currentNode.getData() == t)
                break;
            currentNode = currentNode.getNext();
        }
        return (currentNode != null);
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void displayLinkedList() {
        DNode<T> currentNode = first;
        System.out.print("Linked List= { ");
        while (currentNode != null) {
            if (currentNode.getNext() != null)
                System.out.print(currentNode.getData() + " -> ");
            else
                System.out.print(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        System.out.print(" }\n");
    }
}
