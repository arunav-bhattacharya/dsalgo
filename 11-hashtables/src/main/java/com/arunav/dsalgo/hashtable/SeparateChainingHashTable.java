package com.arunav.dsalgo.hashtable;

public class SeparateChainingHashTable<K, V> implements HashTable<K, V> {

    private static final int DEFAULT_SIZE = 10;
    private static final double LOAD_FACTOR = 0.75;
    private HashNode<K, V>[] hashNodes;
    private int bucketSize;
    private int nItems;
    private int runningBucketSize;

    SeparateChainingHashTable() {
        this.bucketSize = DEFAULT_SIZE;
        this.nItems = 0;
        this.hashNodes = new HashNode[bucketSize];
    }

    @Override
    public void add(K key, V value) {
        nItems++;
        insert(key, value);
    }

    private void insert(K key, V value) {
        HashNode<K, V> newNode = new HashNode<>(key, value);
        int idx = hashFunc(key);

        if (hashNodes[idx] == null) {
            hashNodes[idx] = newNode;
            runningBucketSize++;
        } else {
            HashNode<K, V> current = hashNodes[idx].getNext();
            if (current != null) {
                while (current.getNext() != null)
                    current = current.getNext();
                current.setNext(newNode);
            } else
                hashNodes[idx].setNext(newNode);
        }
        if (runningBucketSize >= bucketSize * LOAD_FACTOR) {
            runningBucketSize = 0;
            grow();
        }
    }

    private void grow() {
        this.bucketSize = this.bucketSize * 2;
        rehash(this.bucketSize);
    }

    private void rehash(int bSize) {
        HashNode<K, V>[] tempHashNodes = new HashNode[this.nItems];
        int i = 0;
        int idx = 0;
        while (idx < bucketSize / 2) {
            if (hashNodes[idx] != null) {
                HashNode<K, V> current = hashNodes[idx];
                while (current != null) {
                    tempHashNodes[i++] = current;
                    current = current.getNext();
                }
            }
            idx++;
        }

        hashNodes = new HashNode[bSize];
        idx = 0;
        while (idx < i) {
            insert(tempHashNodes[idx].getKey(), tempHashNodes[idx].getValue());
            idx++;
        }
    }

    @Override
    public boolean contains(K key) {
        int idx = hashFunc(key);
        if (hashNodes[idx] == null)
            return false;
        else {
            HashNode<K, V> current = hashNodes[idx];
            while (current != null) {
                if (current.getKey().equals(key))
                    return true;
                current = current.getNext();
            }
            return false;
        }
    }

    @Override
    public boolean remove(K key) {
        int idx = hashFunc(key);
        if (hashNodes[idx] == null)
            return false;
        else {
            HashNode<K, V> current = hashNodes[idx].getNext();
            HashNode<K, V> previous = hashNodes[idx];

            if (previous.getKey().equals(key)) {
                hashNodes[idx] = current;
                return true;
            }

            while (current != null) {
                if (current.getKey().equals(key)) {
                    previous.setNext(current.getNext());
                    return true;
                }
                previous = current;
                current = current.getNext();
            }
            return false;
        }
    }

    @Override
    public int getBucketSize() {
        return this.bucketSize;
    }

    @Override
    public int getnItems() {
        return this.nItems;
    }

    @Override
    public HashNode<K, V>[] getHashNodes() {
        HashNode<K, V>[] allNodes = new HashNode[nItems];
        int idx = 0;
        for (HashNode hashNode : hashNodes) {
            if (hashNode != null) {
                HashNode<K, V> current = hashNode;
                while (current != null) {
                    allNodes[idx] = current;
                    idx++;
                    current = current.getNext();
                }
            }
        }
        return allNodes;
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % (bucketSize));
    }
}
