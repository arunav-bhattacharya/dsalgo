package com.arunav.dsalgo.hashtable;

public class QuadProbeHashTable<K, V> extends OpenAddressingHashTable<K, V> {

    QuadProbeHashTable() {
        super();
    }

    protected int hashFunc2(K key, int i) {
        return i * i;
    }
}