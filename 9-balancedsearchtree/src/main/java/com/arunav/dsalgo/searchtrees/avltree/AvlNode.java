package com.arunav.dsalgo.searchtrees.avltree;

public class AvlNode<T extends Comparable<T>, U> {

    private T key;
    private U value;
    private int height;
    private AvlNode<T, U> leftChild;
    private AvlNode<T, U> rightChild;

    public AvlNode(T key, U value) {
        this.key = key;
        this.value = value;
        this.height = 1;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void setData(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public U getValue() {
        return value;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AvlNode<T, U> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AvlNode<T, U> leftChild) {
        this.leftChild = leftChild;
    }

    public AvlNode<T, U> getRightChild() {
        return rightChild;
    }

    public void setRightChild(AvlNode<T, U> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "AvlNode{" +
                "key=" + key +
                ", value='" + value + '\'' +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
