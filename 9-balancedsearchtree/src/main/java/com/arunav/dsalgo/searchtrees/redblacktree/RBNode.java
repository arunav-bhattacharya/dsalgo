package com.arunav.dsalgo.searchtrees.redblacktree;

public class RBNode {

    private int data;
    private boolean isRed;
    private boolean isLeftChild;
    private RBNode left;
    private RBNode right;
    private RBNode parent;

    public RBNode(int data) {
        this.data = data;
        this.isRed = true;
        this.isLeftChild = false;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }

    public RBNode getLeft() {
        return left;
    }

    public void setLeft(RBNode left) {
        this.left = left;
    }

    public RBNode getRight() {
        return right;
    }

    public void setRight(RBNode right) {
        this.right = right;
    }

    public RBNode getParent() {
        return parent;
    }

    public void setParent(RBNode parent) {
        this.parent = parent;
    }

    public boolean isLeftChild() {
        return isLeftChild;
    }

    public void setLeftChild(boolean leftChild) {
        isLeftChild = leftChild;
    }
}
