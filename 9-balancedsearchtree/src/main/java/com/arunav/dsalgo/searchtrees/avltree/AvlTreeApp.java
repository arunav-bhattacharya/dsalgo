package com.arunav.dsalgo.searchtrees.avltree;

public class AvlTreeApp {

    public static void main(String[] args) {
        AvlTree<Integer, String> avlTree = new AvlTree<>();
        avlTree.insert(avlTree.getRoot(), 22, "Twenty Two");
        avlTree.insert(avlTree.getRoot(), 13, "Ten");
        avlTree.insert(avlTree.getRoot(), 33, "Thirty Three");
        avlTree.insert(avlTree.getRoot(), 15, "Fifteen");
        avlTree.insert(avlTree.getRoot(), 11, "Eleven");
        avlTree.insert(avlTree.getRoot(), 20, "Twenty");
        avlTree.insert(avlTree.getRoot(), 42, "Forty Two");
        avlTree.insert(avlTree.getRoot(), 73, "Seventy Three");
        avlTree.insert(avlTree.getRoot(), 80, "Eighty");
        avlTree.insert(avlTree.getRoot(), 60, "Sixty");
        avlTree.insert(avlTree.getRoot(), 5, "Twelve");
        avlTree.insert(avlTree.getRoot(), 12, "Twelve");
        avlTree.insert(avlTree.getRoot(), 99, "Ninety Nine");
        avlTree.insert(avlTree.getRoot(), 96, "Ninety Six");

        System.out.println("\n\nAfter insertions");
        displayAvlTree(avlTree);
        System.out.println("\n\nAfter deletion 22");
        avlTree.delete(avlTree.getRoot(), 22);
        displayAvlTree(avlTree);
        System.out.println("\n\nAfter deletion 15");
        avlTree.delete(avlTree.getRoot(), 15);
        displayAvlTree(avlTree);
    }

    private static void displayAvlTree(AvlTree<Integer, String> avlTree) {
        System.out.println("In-Order");
        avlTree.inOrder(avlTree.getRoot());
        System.out.println("\nPre-Order");
        avlTree.preOrder(avlTree.getRoot());
        System.out.println("\nLevel-Order");
        avlTree.levelOrder();

    }
}