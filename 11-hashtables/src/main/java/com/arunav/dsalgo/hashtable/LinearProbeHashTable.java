package com.arunav.dsalgo.hashtable;

public class LinearProbeHashTable<K, V> extends OpenAddressingHashTable<K, V> {

    LinearProbeHashTable() {
        super();
    }

    protected int hashFunc2(K key, int i) {
        return i;
    }
}