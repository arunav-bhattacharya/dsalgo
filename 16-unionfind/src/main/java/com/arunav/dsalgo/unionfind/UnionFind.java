package com.arunav.dsalgo.unionfind;

import java.util.HashMap;
import java.util.Map;

public class UnionFind<T> {

    private Map<T, Node> map = new HashMap<>();

    private class Node {
        private Node parent;
        private int rank;
        private T data;
    }

    public void add(T data) {
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.rank = 0;
        map.put(data, node);
    }

    public void union(T data1, T data2) {
        if (!isConnected(data1, data2)) {
            Node root1 = getRoot(map.get(data1));
            Node root2 = getRoot(map.get(data2));
            if (root1.rank >= root2.rank) {
                root1.rank = (root1.rank == root2.rank) ? root1.rank + 1 : root1.rank;
                root2.parent = root1;
            } else {
                root1.parent = root2;
            }
        }
    }

    public T find(T data) {
        return root(data);
    }

    public boolean isConnected(T data1, T data2) {
        return root(data1).equals(root(data2));
    }

    private T root(T data1) {
        Node root = getRoot(map.get(data1));
        return root.data;
    }

    private Node getRoot(Node node) {
        if (node.parent == node)
            return node.parent;
        node.parent = getRoot(node.parent);
        return node.parent;
    }
}
