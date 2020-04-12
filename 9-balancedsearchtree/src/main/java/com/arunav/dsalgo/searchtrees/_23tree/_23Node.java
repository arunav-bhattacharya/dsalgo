package com.arunav.dsalgo.searchtrees._23tree;

public class _23Node {

    private static final int TREE_DEGREE = 3;
    private int[] keys = new int[TREE_DEGREE - 1];
    private _23Node parent;
    private _23Node[] _23Nodes = new _23Node[TREE_DEGREE];
    private int nItems;

    public static int getTreeDegree() {
        return TREE_DEGREE;
    }

    public boolean isFull() {
        return (this.nItems >= TREE_DEGREE - 1);
    }

    public boolean isEmpty() {
        return (this.nItems == 0);
    }

    public void insert(int data) {
        this.nItems++;
        if (isEmpty())
            keys[0] = data;
        else if (data < keys[0]) {
            keys[1] = keys[0];
            keys[0] = data;
        }
    }

    public int[] getKeys() {
        return keys;
    }

    public void setKeys(int[] keys) {
        this.keys = keys;
    }

    public _23Node getParent() {
        return parent;
    }

    public void setParent(_23Node parent) {
        this.parent = parent;
    }

    public _23Node[] get_23Nodes() {
        return _23Nodes;
    }

    public void set_23Nodes(_23Node[] _23Nodes) {
        this._23Nodes = _23Nodes;
    }
}
