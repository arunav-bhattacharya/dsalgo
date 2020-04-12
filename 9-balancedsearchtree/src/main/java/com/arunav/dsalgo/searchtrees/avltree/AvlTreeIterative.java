package com.arunav.dsalgo.searchtrees.avltree;

import com.arunav.dsalgo.linkedlists.Queue;
import com.arunav.dsalgo.linkedlists.Stack;

public class AvlTreeIterative<T extends Comparable<T>, U> {

    private AvlNode<T, U> root;

    public AvlTreeIterative() {
        this.root = null;
    }

    public AvlNode<T, U> getRoot() {
        return this.root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(T key, U value) {
        AvlNode<T, U> newNode = new AvlNode<T, U>(key, value);

        if (isEmpty())
            root = newNode;
        else {
            AvlNode<T, U> current = root;
            AvlNode<T, U> parent = root;
            boolean wasLeafNode = false;
            Stack<AvlNode<T, U>> stack = new Stack<AvlNode<T, U>>();

            // Find the appropriate position to insert the new AvlNode
            while (current != null) {
                parent = current;
                stack.push(current);
                if (key.compareTo(current.getKey()) < 0)
                    current = current.getLeftChild();
                else
                    current = current.getRightChild();
            }

            // Check if parent was a LeafNode or not
            if (parent.getHeight() == 0)
                wasLeafNode = true;

            // Once position found, link the new AvlNode to the parent
            if (key.compareTo(parent.getKey()) < 0)
                parent.setLeftChild(newNode);
            else
                parent.setRightChild(newNode);

            // If parent was a leaf node, update height of all nodes & check BF until any node has BF > 1 or < -1
            // or has reached root, i.e. stack is empty
            if (wasLeafNode) {
                current = stack.pop();
                while (!stack.isEmpty() || current == root) {
                    current.setHeight(current.getHeight() + 1);
                    int balanceFactor = getBalanceFactor(current);
                    if (balanceFactor < -1) {
                        if (current != root)
                            parent = stack.pop();
                        else
                            parent = null;
                        if (key.compareTo(current.getRightChild().getKey()) < 0)
                            doRLRotation(current, parent);
                        else
                            doRRRotation(current, parent);
                        break;
                    } else if (balanceFactor > 1) {
                        if (current != root)
                            parent = stack.pop();
                        else
                            parent = null;
                        if (key.compareTo(current.getLeftChild().getKey()) < 0)
                            doLLRotation(current, parent);
                        else
                            doLRRotation(current, parent);
                        break;
                    } else {
                        if (current != root)
                            current = stack.pop();
                        else
                            break;
                    }
                }
            }
        }
    }

    private void doLLRotation(AvlNode<T, U> nodeToRotate, AvlNode<T, U> parent) {

    /* Inserted F

        1    A                  A
            / \                / \
       2   B   C      ==>     E   C
          /     \            / \   \
      1  E       D          F   B   D
        / \                     /
     0 F   G                   G

    */

        AvlNode<T, U> topNode = nodeToRotate.getLeftChild();

        if (topNode.getRightChild() != null)
            nodeToRotate.setLeftChild(topNode.getRightChild());
        else
            nodeToRotate.setLeftChild(null);

        updateSingleRotationProps(nodeToRotate, parent, topNode);
        topNode.getLeftChild().setHeight(topNode.getHeight() + 1);
    }

    private void doRRRotation(AvlNode<T, U> nodeToRotate, AvlNode<T, U> parent) {

    /* Inserted G

        1    A      -1                 A
            / \                       / \
       2   B   C    -2    ==>        B   D
          /     \                   /   / \
      0  E       D   0             E   C   G
                / \                     \
               F   G 0                   F

    */
        AvlNode<T, U> topNode = nodeToRotate.getRightChild();
        if (topNode.getLeftChild() != null)
            nodeToRotate.setRightChild(topNode.getLeftChild());
        else
            nodeToRotate.setRightChild(null);

        updateSingleRotationProps(nodeToRotate, parent, topNode);
        topNode.getRightChild().setHeight(topNode.getHeight() + 1);
    }

    private void updateSingleRotationProps(AvlNode<T, U> nodeToRotate, AvlNode<T, U> parent, AvlNode<T, U> topNode) {

        if (parent != null) {
            if (parent.getLeftChild() == nodeToRotate)
                parent.setLeftChild(topNode);
            else
                parent.setRightChild(topNode);
        } else {
            root = topNode;
        }

        topNode.setHeight(topNode.getHeight() - 1);
        nodeToRotate.setHeight(topNode.getHeight() + 1);
    }

    private void doLRRotation(AvlNode<T, U> nodeToRotate, AvlNode<T, U> parent) {

    /* Inserted G

        1    A                  A
            / \                / \
       2   B   C       ==>    G   C
          /     \            / \   \
     -1  E       D          E   B   D
          \
     0     G

    */
        AvlNode<T, U> topNode = nodeToRotate.getLeftChild().getRightChild();
        AvlNode<T, U> topNodeRightChild = topNode.getRightChild();
        topNode.setRightChild(nodeToRotate);
        if (topNode.getLeftChild() == null) {
            topNode.setLeftChild(nodeToRotate.getLeftChild());
            topNode.getLeftChild().setRightChild(null);
        } else {
            nodeToRotate.getLeftChild().setRightChild(topNode.getLeftChild());
        }
        nodeToRotate.setLeftChild(topNodeRightChild);
        updateDoubleRotationProps(topNode, nodeToRotate, parent);
        if (nodeToRotate.getRightChild() != null)
            nodeToRotate.setHeight(nodeToRotate.getRightChild().getHeight() + 1);
        else
            nodeToRotate.setHeight(0);
    }

    private void doRLRotation(AvlNode<T, U> nodeToRotate, AvlNode<T, U> parent) {

    /* Inserted G

             A    -1                   A
            / \                       / \
           B   C  -2      ==>        B   G
          /     \                   /   / \
         E       D 1               E   C   D
                /
               G   0
    */
        AvlNode<T, U> topNode = nodeToRotate.getRightChild().getLeftChild();
        AvlNode<T, U> topNodeLeftChild = topNode.getLeftChild();
        topNode.setLeftChild(nodeToRotate);

        if (topNode.getRightChild() == null) {
            topNode.setRightChild(nodeToRotate.getRightChild());
            topNode.getRightChild().setLeftChild(null);
        } else {
            nodeToRotate.getRightChild().setLeftChild(topNode.getRightChild());
        }
        nodeToRotate.setRightChild(topNodeLeftChild);
        updateDoubleRotationProps(topNode, nodeToRotate, parent);

        if (nodeToRotate.getLeftChild() != null)
            nodeToRotate.setHeight(nodeToRotate.getLeftChild().getHeight() + 1);
        else
            nodeToRotate.setHeight(0);
    }

    private void updateDoubleRotationProps(AvlNode<T, U> topNode, AvlNode<T, U> nodeToRotate, AvlNode<T, U> parent) {
        topNode.setHeight(nodeToRotate.getHeight());

        if (parent != null) {
            if (parent.getLeftChild() == nodeToRotate)
                parent.setLeftChild(topNode);
            else
                parent.setRightChild(topNode);
        } else
            root = topNode;
    }

    private int getBalanceFactor(AvlNode<T, U> avlNode) {
        int leftSBTHeight;
        int rightSBTHeight;
        if (avlNode.getLeftChild() != null)
            leftSBTHeight = avlNode.getLeftChild().getHeight();
        else
            leftSBTHeight = -1;

        if (avlNode.getRightChild() != null)
            rightSBTHeight = avlNode.getRightChild().getHeight();
        else
            rightSBTHeight = -1;
        return leftSBTHeight - rightSBTHeight;
    }

    public boolean delete(int key) {
        return false;
    }

    public boolean find(int key) {
        return false;
    }

    public void inOrder(AvlNode<T, U> node) {
        if (node != null) {
            inOrder(node.getLeftChild());
            System.out.print(node.getKey() + " ");
            inOrder(node.getRightChild());
        }
    }


    void levelOrderTraversal() {
        AvlNode<T, U> current = root;
        Queue<AvlNode<T, U>> queue = new Queue<AvlNode<T, U>>();
        queue.insert(current);

        while (!queue.isEmpty()) {
            current = queue.remove();
            System.out.print(current.getKey() + " ");
            if (current.getLeftChild() != null)
                queue.insert(current.getLeftChild());
            if (current.getRightChild() != null)
                queue.insert(current.getRightChild());
        }
    }
}
