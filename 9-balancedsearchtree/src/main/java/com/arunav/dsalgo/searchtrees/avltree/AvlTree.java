package com.arunav.dsalgo.searchtrees.avltree;

import com.arunav.dsalgo.linkedlists.Queue;

public class AvlTree<T extends Comparable<T>, U> {

    AvlNode<T, U> root;

    AvlTree() {
        root = null;
    }

    public AvlNode<T, U> getRoot() {
        return root;
    }

    public AvlNode<T, U> insert(AvlNode<T, U> avlNode, T key, U value) {
        // Insert as an appropriate leaf node, by doing left and right traversal recursively
        if (avlNode == null) {
            root = new AvlNode<>(key, value);
            return root;
        } else {
            if (key.compareTo(avlNode.getKey()) < 0)
                avlNode.setLeftChild(insert(avlNode.getLeftChild(), key, value));
            else
                avlNode.setRightChild(insert(avlNode.getRightChild(), key, value));
        }

        avlNode.setHeight(Integer.max(height(avlNode.getLeftChild()), height(avlNode.getRightChild())) + 1);
        root = avlNode;
        int balanceFactor = getBalanceFactor(avlNode);
        if (balanceFactor > 1 || balanceFactor < -1)
            root = doRotationsForInsert(avlNode, balanceFactor, key);
        return root;
    }

    public AvlNode<T, U> delete(AvlNode<T, U> avlNode, T key) {

        if (avlNode == null)
            return avlNode;
        else if (key.compareTo(avlNode.getKey()) < 0)
            avlNode.setLeftChild(delete(avlNode.getLeftChild(), key));
        else if (key.compareTo(avlNode.getKey()) > 0)
            avlNode.setRightChild(delete(avlNode.getRightChild(), key));
        else {
            // If avlNode is a leaf Node
            if (avlNode.getHeight() == 1)
                avlNode = null;
                // If avlNode has only leftChild
            else if (avlNode.getLeftChild() != null && avlNode.getRightChild() == null)
                avlNode = avlNode.getLeftChild();
                // If avlNode has only rightChild
            else if (avlNode.getLeftChild() == null && avlNode.getRightChild() != null)
                avlNode = avlNode.getRightChild();
                // If avlNode has both right and left children
            else {
                // Find the InOrder successor
                AvlNode<T, U> successor = getInOrderSuccessor(avlNode.getRightChild());
                // Once successor found, overwrite the data on the current node with the data on successor node
                avlNode.setData(successor.getKey(), successor.getValue());
                // Delete the successor Node, as it has either a single child or it is a leaf node
                avlNode.setRightChild(delete(avlNode.getRightChild(), successor.getKey()));
            }
        }
        if (avlNode == null)
            return avlNode;

        avlNode.setHeight(Integer.max(height(avlNode.getLeftChild()), height(avlNode.getRightChild())) + 1);
        int balanceFactor = getBalanceFactor(avlNode);
        if (balanceFactor > 1 || balanceFactor < -1)
            avlNode = doRotationsForDelete(avlNode, balanceFactor);
        return avlNode;
    }

    private AvlNode<T, U> doRotationsForInsert(AvlNode<T, U> avlNode, int balanceFactor, T key) {
        if (balanceFactor > 1) {
            if (key.compareTo(avlNode.getLeftChild().getKey()) < 0)
                return doLLRotation(avlNode);
            else
                return doLRRotation(avlNode);
        } else if (balanceFactor < -1) {
            if (key.compareTo(avlNode.getRightChild().getKey()) > 0)
                return doRRRotation(avlNode);
            else
                return doRLRotation(avlNode);
        }

        return avlNode;
    }

    private AvlNode<T, U> doRotationsForDelete(AvlNode<T, U> avlNode, int balanceFactor) {
        if (balanceFactor > 1) {
            if (getBalanceFactor(avlNode.getLeftChild()) >= 0)
                return doLLRotation(avlNode);
            else
                return doLRRotation(avlNode);
        } else {
            if (getBalanceFactor(avlNode.getRightChild()) <= 0)
                return doRRRotation(avlNode);
            else
                return doRLRotation(avlNode);
        }
    }

    private AvlNode<T, U> doLLRotation(AvlNode<T, U> avlNode) {
        return rotateRight(avlNode);
    }

    private AvlNode<T, U> doRRRotation(AvlNode<T, U> avlNode) {
        return rotateLeft(avlNode);
    }

    private AvlNode<T, U> doLRRotation(AvlNode<T, U> avlNode) {
        avlNode.setLeftChild(rotateLeft(avlNode.getLeftChild()));
        return rotateRight(avlNode);
    }

    private AvlNode<T, U> doRLRotation(AvlNode<T, U> avlNode) {
        avlNode.setRightChild(rotateRight(avlNode.getRightChild()));
        return rotateLeft(avlNode);
    }

    private AvlNode<T, U> rotateLeft(AvlNode<T, U> avlNode) {
        AvlNode<T, U> newTopNode = avlNode.getRightChild();

        /* Rotations */
        avlNode.setRightChild(newTopNode.getLeftChild());
        newTopNode.setLeftChild(avlNode);

        /* Update heights of newTopNode and the rotated node */
        updateHeights(avlNode, newTopNode);
        return newTopNode;
    }

    private AvlNode<T, U> rotateRight(AvlNode<T, U> avlNode) {
        //Copy the newTopNode (leftChild of node-to-rotate) in a temp variable
        AvlNode<T, U> newTopNode = avlNode.getLeftChild();

        /* Rotations */
        //Set left-child of node-to-rotate with the right child of newTopNode
        avlNode.setLeftChild(newTopNode.getRightChild());
        //Set right-child of newTopNode to the rotated node
        newTopNode.setRightChild(avlNode);

        //Update heights of the rotated node and the new TopNode
        updateHeights(avlNode, newTopNode);
        return newTopNode;
    }

    private void updateHeights(AvlNode<T, U> avlNode, AvlNode<T, U> newTopNode) {
        avlNode.setHeight(Integer.max(height(avlNode.getLeftChild()), height(avlNode.getRightChild())) + 1);
        newTopNode.setHeight(Integer.max(height(newTopNode.getLeftChild()), height(newTopNode.getRightChild())) + 1);
    }

    private int height(AvlNode<T, U> avlNode) {
        if (avlNode == null)
            return 0;
        return avlNode.getHeight();
    }

    private int getBalanceFactor(AvlNode<T, U> avlNode) {
        return height(avlNode.getLeftChild()) - height(avlNode.getRightChild());
    }

    public void inOrder(AvlNode<T, U> avlNode) {
        if (avlNode != null) {
            inOrder(avlNode.getLeftChild());
            System.out.print(avlNode.getKey() + " ");
            inOrder(avlNode.getRightChild());
        }
    }

    public void preOrder(AvlNode<T, U> avlNode) {
        if (avlNode != null) {
            System.out.print(avlNode.getKey() + " ");
            preOrder(avlNode.getLeftChild());
            preOrder(avlNode.getRightChild());
        }
    }

    public void levelOrder() {
        Queue<AvlNode<T, U>> queue = new Queue<>();
        AvlNode<T, U> current = root;
        queue.insert(current);
        while (!queue.isEmpty()) {
            current = queue.remove();
            if (current.getLeftChild() != null)
                queue.insert(current.getLeftChild());
            if (current.getRightChild() != null)
                queue.insert(current.getRightChild());
            System.out.print(current.getKey() + " ");
        }
    }

    private AvlNode<T, U> getInOrderSuccessor(AvlNode<T, U> current) {
        AvlNode<T, U> parent = current;
        while (current != null) {
            parent = current;
            current = current.getLeftChild();
        }
        return parent;
    }
}
