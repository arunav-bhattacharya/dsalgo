package com.arunav.dsalgo.searchtrees.redblacktree;

public class RBTreeApp {
    public static void main(String[] args) {
        RedBlackTree rbTree = new RedBlackTree();
/*        rbTree.insert(22);
        rbTree.insert(13);
        rbTree.insert(33);
        rbTree.insert(15);
        rbTree.insert(11);
        rbTree.insert(20);
        rbTree.insert(42);
        rbTree.insert(73);
        rbTree.insert(80);
        rbTree.insert(60);
        rbTree.insert(5);
        rbTree.insert(12);
        rbTree.insert(99);
        rbTree.insert(96);
        rbTree.insert(21);
        rbTree.insert(101);*/

        rbTree.insert(10);
        rbTree.insert(20);
        rbTree.insert(30);
        rbTree.insert(50);
        rbTree.insert(40);
        rbTree.insert(60);
        rbTree.insert(70);
        rbTree.insert(80);
        rbTree.insert(4);
        rbTree.insert(8);
        rbTree.insert(5);
        rbTree.insert(12);
        rbTree.insert(99);
        rbTree.insert(96);
        rbTree.insert(21);
        rbTree.insert(101);

        for (int i = 100; i <= 300; i += 10) {
            rbTree.insert(i);
        }

        System.out.println("\n\nAfter insertions");
        displayTree(rbTree);
    }

    private static void displayTree(RedBlackTree rbTree) {
        System.out.println("\nPre-Order");
        rbTree.preOrder(rbTree.getRoot());
    }
}
