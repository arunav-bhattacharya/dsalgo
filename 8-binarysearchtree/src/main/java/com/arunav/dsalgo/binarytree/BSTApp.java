package com.arunav.dsalgo.binarytree;

public class BSTApp {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
/*
        bst.insert(20, "Twenty");
        bst.insert(13, "Thirteen");
        bst.insert(30, "Thirty");
        bst.insert(15, "Fifteen");
        bst.insert(11, "Eleven");
        bst.insert(25, "Twenty Five");
        bst.insert(40, "Forty");
        bst.insert(73, "Seventy Three");
        bst.insert(84, "Eighty Four");
        bst.insert(62, "Sixty Two");
        bst.insert(12, "Twelve");
        bst.insert(99, "Ninety Nine");
        bst.insert(96, "Ninety Six");
        bst.insert(97, "Ninety Seven");
*/
        //bst.insert(100, "Forty");
        bst.insert(bst.getRoot(), 20, "Twenty");
        bst.insert(bst.getRoot(), 13, "Thirteen");
        bst.insert(bst.getRoot(), 30, "Thirty");
        bst.insert(bst.getRoot(), 15, "Fifteen");
        bst.insert(bst.getRoot(), 11, "Eleven");
        bst.insert(bst.getRoot(), 25, "Twenty Five");
        bst.insert(bst.getRoot(), 40, "Forty");
        bst.insert(bst.getRoot(), 73, "Seventy Three");
        bst.insert(bst.getRoot(), 84, "Eighty Four");
        bst.insert(bst.getRoot(), 62, "Sixty Two");
        bst.insert(bst.getRoot(), 12, "Twelve");
        bst.insert(bst.getRoot(), 99, "Ninety Nine");
        bst.insert(bst.getRoot(), 96, "Ninety Six");
        bst.insert(bst.getRoot(), 97, "Ninety Seven");

        System.out.println("\n\n\n");
        bst.displayTree();
        bst.delete(20);
        System.out.println("\n\n\n");
        bst.displayTree();
        bst.delete(110);
        bst.displayTree();

        System.out.println(bst.find(10));
        System.out.println(bst.find(20));
        System.out.println(bst.find(25));
        System.out.println(bst.find(30));
        System.out.println(bst.find(50));
    }
}
