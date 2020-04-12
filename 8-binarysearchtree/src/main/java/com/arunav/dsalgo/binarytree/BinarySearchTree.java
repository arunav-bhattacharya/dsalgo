package com.arunav.dsalgo.binarytree;

import com.arunav.dsalgo.linkedlists.Queue;
import com.arunav.dsalgo.linkedlists.Stack;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private Node root;
    private int nItems;

    public BinarySearchTree() {
        root = null;
        nItems = 0;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node getRoot() {
        return root;
    }

    public Node find(int key) {

        Node currentNode = root;
        while (currentNode != null) {
            if (key < currentNode.getKey())
                currentNode = currentNode.getLeftChild();
            else if (key > currentNode.getKey())
                currentNode = currentNode.getRightChild();
            else
                return currentNode;
        }
        return null;
    }

    public Node insert(Node node, int key, String value) {
        if (node == null) {
            node = new Node(key, value);
            if (this.root == null)
                this.root = node;
        } else {
            if (key < node.getKey())
                node.setLeftChild(insert(node.getLeftChild(), key, value));
            else
                node.setRightChild(insert(node.getRightChild(), key, value));
        }
        return node;
    }

    public void insert(int key, String value) {

        Node newNode = new Node(key, value);

        if (root == null)
            root = newNode;
        else {
            Node currentNode = root;
            Node parentNode;

            while (true) {
                parentNode = currentNode;
                if (key < currentNode.getKey()) {
                    currentNode = parentNode.getLeftChild();
                } else {
                    currentNode = parentNode.getRightChild();
                }

                if (currentNode == null) {
                    if (key < parentNode.getKey())
                        parentNode.setLeftChild(newNode);
                    else
                        parentNode.setRightChild(newNode);
                    break;
                }
            }
        }
        nItems++;
    }

    public boolean delete(int key) {
        Node currentNode = root;
        Node parentNode = root;
        boolean isLeftChild = false;

        while (currentNode.getKey() != key) {
            parentNode = currentNode;
            if (key < currentNode.getKey()) {
                currentNode = currentNode.getLeftChild();
                isLeftChild = true;
            } else {
                currentNode = currentNode.getRightChild();
                isLeftChild = false;
            }
            if (currentNode == null)
                return false;
        }
        /* Delete a node that is a leaf node */
        if (null == currentNode.getRightChild() && null == currentNode.getLeftChild()) {
            if (currentNode == root)
                root = null;
            else if (isLeftChild)
                parentNode.setLeftChild(null);
            else
                parentNode.setRightChild(null);
            return true;
        }
        /* Delete a node that has one child */
        /* When no right child, replace with left subtree */
        if (null == currentNode.getRightChild() && null != currentNode.getLeftChild()) {
            if (currentNode == root)
                root.setLeftChild(currentNode.getLeftChild());
            else if (isLeftChild)
                parentNode.setLeftChild(currentNode.getLeftChild());
            else
                parentNode.setRightChild(currentNode.getLeftChild());
            return true;
        }
        /* When no left child, replace with right subtree */
        if (null != currentNode.getRightChild() && null == currentNode.getLeftChild()) {
            if (currentNode == root)
                root.setRightChild(currentNode.getRightChild());
            else if (isLeftChild)
                parentNode.setLeftChild(currentNode.getRightChild());
            else
                parentNode.setRightChild(currentNode.getRightChild());
            return true;
        }
        /* Delete a node that has two children */
        if (null != currentNode.getRightChild() && null != currentNode.getLeftChild()) {
            Node successor = getSuccessor(currentNode);
            if (currentNode == root)
                root = successor;
            else if (isLeftChild)
                parentNode.setLeftChild(successor);
            else
                parentNode.setRightChild(successor);
            successor.setLeftChild(currentNode.getLeftChild());
            return true;
        }
        return false;
    }

    private Node getSuccessor(Node nodeToDelete) {
        Node successorParentNode = nodeToDelete;
        Node successor = nodeToDelete;
        Node currentNode = nodeToDelete.getRightChild();
        while (currentNode != null) {
            successorParentNode = successor;
            successor = currentNode;
            currentNode = currentNode.getLeftChild();
        }
        /* If the successor is not the right child of the nodeToDelete */
        if (nodeToDelete.getRightChild() != successor) {
            successorParentNode.setLeftChild(successor.getRightChild());
            successor.setRightChild(nodeToDelete.getRightChild());
        }
        return successor;
    }

    public void display() {

        Node currentNode = root;
        System.out.println("\t\t\t" + root.getKey());
        System.out.println("\t" + ((currentNode.getLeftChild() == null) ? "--" : currentNode.getLeftChild().getKey())
                + "\t\t\t\t" + ((currentNode.getRightChild() == null) ? "--" : currentNode.getRightChild().getKey()));

        Node secondLevelLeftNode = currentNode.getLeftChild();
        Node secondLevelRightNode = currentNode.getRightChild();

        System.out.println(((secondLevelLeftNode.getLeftChild() == null) ? "--" :
                secondLevelLeftNode.getLeftChild().getKey())
                + "\t\t" + ((secondLevelLeftNode.getRightChild() == null) ? "--" :
                secondLevelLeftNode.getRightChild().getKey())
                + "\t\t" + ((secondLevelRightNode.getLeftChild() == null) ? "--" :
                secondLevelRightNode.getLeftChild().getKey())
                + "\t\t" + ((secondLevelRightNode.getRightChild() == null) ? "--" :
                secondLevelRightNode.getRightChild().getKey()));
    }

    void displayTree() {

        boolean isLastLevel = false;

        List<Node> currentNodes = new ArrayList<>();
        List<Node> nextNodes = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();

        Node dummyNode = new Node(Integer.MAX_VALUE, "Dummy");
        Node leftChild, rightChild;
        currentNodes.add(root);

        while (!isLastLevel) {
            for (Node currentNode : currentNodes) {
                if (currentNode != null) {
                    leftChild = currentNode.getLeftChild();
                    rightChild = currentNode.getRightChild();
                } else {
                    leftChild = null;
                    rightChild = null;
                }
                nextNodes.add(leftChild);
                nextNodes.add(rightChild);
                nodes.add(leftChild);
                nodes.add(rightChild);
            }

            for (Node node : nextNodes) {
                if (node != null && (node.getLeftChild() != null || node.getRightChild() != null)) {
                    isLastLevel = false;
                    break;
                } else
                    isLastLevel = true;
            }
            nodes.add(dummyNode);
            currentNodes = nextNodes;
            nextNodes = new ArrayList<>();
        }

        long level = nodes
                .stream()
                .filter(node -> node != null && node.getKey() == Integer.MAX_VALUE)
                .count();

        double currentLevel = getInitialSpaces(level);
        printSpaces(currentLevel * 1.75);
        System.out.println(root.getKey());

        for (Node node : nodes) {
            if (node != dummyNode) {
                printSpaces(currentLevel - 2);
                System.out.print((node != null) ? node.getKey() + "" : "--");
                printSpaces(currentLevel / 2);
            } else {
                System.out.println();
                currentLevel /= 2;
            }
        }
        System.out.println();
    }

    private int getInitialSpaces(double level) {

        int i = 0;
        int spaces = 1;
        while (i < level) {
            spaces = spaces * 2;
            i++;
        }
        return spaces;
    }

    private void printSpaces(double currentLevel) {

        while (currentLevel > 0) {
            System.out.print(" ");
            currentLevel--;
        }
    }

    void preOrderTraversal(Node node) {
        if (node != null) {
            System.out.println(node.getKey());
            preOrderTraversal(node.getLeftChild());
            preOrderTraversal(node.getRightChild());
        }
    }

    void preOrderIterative() {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                System.out.println(current.getKey());
                stack.push(current);
                current = current.getLeftChild();
            } else {
                current = stack.pop();
                current = current.getRightChild();
            }
        }
    }

    void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.getLeftChild());
            System.out.println(node.getKey());
            inOrderTraversal(node.getRightChild());
        }
    }

    void inOrderIterative() {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.getLeftChild();
            } else {
                current = stack.pop();
                System.out.println(current.getKey());
                current = current.getRightChild();
            }
        }
    }

    void postOrderTraversal(Node node) {
        if (node != null) {
            postOrderTraversal(node.getLeftChild());
            postOrderTraversal(node.getRightChild());
            System.out.println(node.getKey());
        }
    }

    void postOrderIterative() {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        Node previous = null;
        if (!isEmpty())
            stack.push(current);
        while (!stack.isEmpty()) {
            current = stack.peek();
            if (previous == null || previous.getLeftChild() == current || previous.getRightChild() == current) {
                if (current.getLeftChild() != null) {
                    stack.push(current.getLeftChild());
                } else if (current.getRightChild() != null)
                    stack.push(current.getRightChild());
                else {
                    System.out.println(stack.pop().getKey());
                }
            } else if (current.getLeftChild() == previous) {
                if (current.getRightChild() != null)
                    stack.push(current.getRightChild());
                else
                    System.out.println(stack.pop().getKey());
            } else if (current.getRightChild() == previous) {
                System.out.println(stack.pop().getKey());
            }
            previous = current;
        }
    }

    void levelOrderTraversal() {
        Node current = root;
        Queue<Node> queue = new Queue<>();
        queue.insert(current);

        while (!queue.isEmpty()) {
            current = queue.remove();
            System.out.println(current.getKey());
            if (current.getLeftChild() != null)
                queue.insert(current.getLeftChild());
            if (current.getRightChild() != null)
                queue.insert(current.getRightChild());
        }
    }
}
