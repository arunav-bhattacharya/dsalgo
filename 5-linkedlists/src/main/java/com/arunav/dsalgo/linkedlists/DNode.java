package com.arunav.dsalgo.linkedlists;

public class DNode<T> {

    private DNode prev;
    private T data;
    private DNode next;

    public DNode() {
        prev = null;
        next = null;
    }

    public DNode getPrev() {
        return prev;
    }

    public void setPrev(DNode prev) {
        this.prev = prev;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DNode getNext() {
        return next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }
}
