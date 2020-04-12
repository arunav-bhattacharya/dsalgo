package com.arunav.dsalgo.searchtrees._23tree;

public class _23Tree {

    _23Node root;

    _23Tree() {
        root = null;
    }

    public void insert(int data) {

        if (root == null) {
            _23Node node = new _23Node();
            node.insert(data);
            root = node;
        } else {
            _23Node current = root;
        }
    }
}
