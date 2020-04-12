package com.arunav.dsalgo.searchtrees.redblacktree;

public class RedBlackTree {

    private RBNode root;

    RedBlackTree() {
        root = null;
    }

    public RBNode getRoot() {
        return root;
    }

    public void insert(int data) {

        // If root is null, create a new Node and assign to it
        if (root == null) {
            root = new RBNode(data);
            root.setRed(false);
        } else {
            RBNode current = root;
            RBNode parent = root;

            // Traverse to the appropriate location as per BST
            while (current != null) {
                parent = current;
                if (data < current.getData())
                    current = current.getLeft();
                else
                    current = current.getRight();
            }

            // Create a new Node and assign the parent to it
            current = new RBNode(data);
            current.setParent(parent);
            if (data < parent.getData()) {
                parent.setLeft(current);
                current.setLeftChild(true);
            } else {
                current.setLeftChild(false);
                parent.setRight(current);
            }

            // Check if the parent of the new Node is red
            while (parent.isRed() && current.isRed() && parent != root) {
                // If parent is red, get the color of parent's sibling
                boolean isRed = isSiblingRed(parent);

                // If color of parent's sibling is red, then flip the colors until Red-Black Tree is balanced
                if (isRed)
                    flipColors(parent);
                    // If color of parent's sibling is not red, then perform rotations to balance the Red-Black Tree
                else
                    doRotations(parent, current.getData());

                /* Update grandparent as the new current */
                current = parent.getParent();

                if (current != root && current != null) {
                    parent = current.getParent();
                } else {
                    if (current == root)
                        current.setRed(false);
                    break;
                }
            }
            if (root.isRed())
                root.setRed(false);
        }
    }

    private boolean isSiblingRed(RBNode parent) {

        RBNode grandParent = parent.getParent();

        // Return the color of parent's sibling
        if (parent.isLeftChild() && grandParent.getRight() != null)
            return grandParent.getRight().isRed();
        else if (!parent.isLeftChild() && grandParent.getLeft() != null)
            return grandParent.getLeft().isRed();
        //When parent does not have sibling, then return color of null child, i.e. black
        return false;
    }

    private void flipColors(RBNode parent) {
        RBNode grandParent = parent.getParent();
        grandParent.setRed(true); // Flips color of grandparent

        /* Flips color of parent's sibling */
        if (grandParent.getLeft() != null)
            grandParent.getLeft().setRed(false);

        if (grandParent.getRight() != null)
            grandParent.getRight().setRed(false);
    }

    private void doRotations(RBNode parent, int data) {

        RBNode grandParent = parent.getParent();
        RBNode topNode;

        if (parent.isLeftChild()) {
            if (data < parent.getData())
                topNode = doLLRotation(grandParent);
            else
                topNode = doLRRotation(grandParent);
        } else {
            if (data > parent.getData())
                topNode = doRRRotation(grandParent);
            else
                topNode = doRLRotation(grandParent);
        }

        if (grandParent == root)
            root = topNode;
    }

    private RBNode doLLRotation(RBNode grandParent) {

        RBNode parent = grandParent.getLeft();
        RBNode siblingOfChild = parent.getRight();
        RBNode parentOfGrandParent = grandParent.getParent();

        parent.setRight(grandParent);

        doZigZigRotation(parent, grandParent, parentOfGrandParent);
        grandParent.setLeftChild(false);
        grandParent.setLeft(siblingOfChild);
        return parent;
    }

    private RBNode doRRRotation(RBNode grandParent) {
        RBNode parent = grandParent.getRight();
        RBNode siblingOfChild = parent.getLeft();
        RBNode parentOfGrandParent = grandParent.getParent();

        parent.setLeft(grandParent);

        doZigZigRotation(parent, grandParent, parentOfGrandParent);
        grandParent.setLeftChild(true);
        grandParent.setRight(siblingOfChild);
        return parent;
    }

    private void doZigZigRotation(RBNode parent, RBNode grandParent, RBNode parentOfGrandParent) {
        parent.setParent(parentOfGrandParent);
        if (parentOfGrandParent != null) {
            if (grandParent.isLeftChild()) {
                parentOfGrandParent.setLeft(parent);
                parent.setLeftChild(true);
            } else {
                parentOfGrandParent.setRight(parent);
                parent.setLeftChild(false);
            }
        }
        grandParent.setParent(parent);
        parent.setRed(false);
        grandParent.setRed(true);
    }

    private RBNode doLRRotation(RBNode grandParent) {

        RBNode parent = grandParent.getLeft();
        RBNode child = parent.getRight();

        RBNode childLeft = child.getLeft();
        RBNode childRight = child.getRight();
        RBNode parentOfGrandParent = grandParent.getParent();

        /* Update child, parent, grandparent nodes' relationship during rotation */
        child.setLeft(parent);
        child.setRight(grandParent);
        child.setParent(grandParent.getParent());

        if (grandParent.isLeftChild())
            child.setLeftChild(true);
        else
            child.setLeftChild(false);
        parent.setParent(child);
        grandParent.setParent(child);

        if (parentOfGrandParent != null) {
            if (grandParent.isLeftChild())
                parentOfGrandParent.setLeft(child);
            else
                parentOfGrandParent.setRight(child);
        }

        /* Update children of child's relationship with parent and grandparent nodes */
        parent.setRight(childLeft);
        grandParent.setLeft(childRight);

        grandParent.setLeftChild(false);
        parent.setLeftChild(true);
        if (childLeft != null) {
            childLeft.setParent(parent);
            childLeft.setLeftChild(false);
        }

        if (childRight != null) {
            childRight.setParent(grandParent);
            childRight.setLeftChild(true);
        }

        child.setRed(false);
        grandParent.setRed(true);

        return child;
        //return child;
    }

    private RBNode doRLRotation(RBNode grandParent) {

        RBNode parent = grandParent.getRight();
        RBNode child = parent.getLeft();
        RBNode childLeft = child.getLeft();
        RBNode childRight = child.getRight();
        RBNode parentOfGrandParent = grandParent.getParent();

        /* Update child, parent, grandparent nodes' relationship during rotation */
        child.setLeft(grandParent);
        child.setRight(parent);
        child.setParent(parentOfGrandParent);
        if (grandParent.isLeftChild())
            child.setLeftChild(true);
        else
            child.setLeftChild(false);

        parent.setParent(child);
        grandParent.setParent(child);

        if (parentOfGrandParent != null) {
            if (grandParent.isLeftChild())
                parentOfGrandParent.setLeft(child);
            else
                parentOfGrandParent.setRight(child);
        }

        //Update children of child's relationship with parent and grandparent nodes

        parent.setLeft(childRight);
        grandParent.setRight(childLeft);
        grandParent.setLeftChild(true);
        parent.setLeftChild(false);
        if (childLeft != null) {
            childLeft.setParent(grandParent);
            childLeft.setLeftChild(false);
        }

        if (childRight != null) {
            childRight.setParent(parent);
            childRight.setLeftChild(true);
        }

        child.setRed(false);
        grandParent.setRed(true);

        return child;
    }

    public void preOrder(RBNode rbNode) {
        if (rbNode != null) {
            String color;
            if (rbNode.isRed()) color = "red";
            else color = "black";
            System.out.print(rbNode.getData() + " " + color + ", ");
            preOrder(rbNode.getLeft());
            preOrder(rbNode.getRight());
        }
    }
}
