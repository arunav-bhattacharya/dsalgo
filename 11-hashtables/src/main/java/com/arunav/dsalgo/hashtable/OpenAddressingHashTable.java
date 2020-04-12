package com.arunav.dsalgo.hashtable;

public abstract class OpenAddressingHashTable<K, V> implements HashTable<K, V> {

    private static final int INITIAL_CAPACITY = 10;
    private static final double LOAD_FACTOR = 0.75;
    protected boolean hasBucketSizeChanged;
    private HashNode<K, V>[] hashNodes;
    private int bucketSize;
    private int nItems;
    private double loadFactor;

    OpenAddressingHashTable() {
        this.nItems = 0;
        this.bucketSize = INITIAL_CAPACITY;
        this.loadFactor = LOAD_FACTOR;
        this.hashNodes = (HashNode<K, V>[]) new HashNode[bucketSize];
        this.hasBucketSizeChanged = true;
    }

    public void add(K key, V value) {
        this.nItems++;
        insert(key, value);
    }

    public boolean contains(K key) {
        return search(key) != -1;
    }

    protected abstract int hashFunc2(K key, int i);

    private void insert(K key, V value) {
        HashNode<K, V> newNode = new HashNode<>(key, value);
        int idx = hashFunc1(key);
        if (this.hashNodes[idx] == null) // If key not present in the table, add the key
            this.hashNodes[idx] = newNode;
        else {
            int i = search(key);
            if (i != -1) // If key already present in the table, then update it
                this.hashNodes[i] = newNode;
            else { // If key is not present and the calculated position is occupied
                i = 1;
                int newIdx;
                while (i < bucketSize) {
                    newIdx = hashFunc(idx, key, i);
                    if (this.hashNodes[newIdx] == null) {
                        this.hashNodes[newIdx] = newNode;
                        break;
                    }
                    i++;
                }
            }
        }
        if (this.nItems >= this.bucketSize * this.loadFactor)
            grow();
    }

    private int search(K key) {
        int idx = hashFunc1(key);
        if (this.hashNodes[idx] != null && this.hashNodes[idx].getKey().equals(key))
            return idx;
        int i = 1;
        int newIdx;
        while (i < this.nItems) {
            newIdx = hashFunc(idx, key, i);
            if (this.hashNodes[newIdx] == null)
                break;
            if (this.hashNodes[newIdx].getKey().equals(key))
                return newIdx;
            i++;
        }
        return -1;
    }

    private int hashFunc1(K key) {
        return Math.abs(key.hashCode() % (this.bucketSize));
    }

    private int hashFunc(int hashFunc1, K key, int i) {
        return (hashFunc1 + hashFunc2(key, i)) % (this.bucketSize);
    }

    private void rehash(int newBSize, int currentBSize) {
        this.hasBucketSizeChanged = true;
        HashNode<K, V>[] tempArray = new HashNode[newBSize];
        int j = 0;
        for (int i = 0; i < currentBSize; i++)
            if (this.hashNodes[i] != null)
                tempArray[j++] = this.hashNodes[i];

        //System.out.println("No of elements copied in tempArray = " + j);
        this.hashNodes = new HashNode[newBSize];
        int i;
        for (i = 0; i < j; i++)
            if (tempArray[i] != null)
                insert(tempArray[i].getKey(), tempArray[i].getValue());
        //System.out.println("No of elements copied in hashArray = " + i);
    }

    private void grow() {
        this.bucketSize = this.bucketSize * 2;
        rehash(this.bucketSize, this.bucketSize / 2);
    }

    public int getBucketSize() {
        return this.bucketSize;
    }

    public int getnItems() {
        return this.nItems;
    }

    public HashNode<K, V>[] getHashNodes() {
        return this.hashNodes;
    }

    public boolean remove(K key) {
        int idx = search(key);
        if (idx != -1) {
            hashNodes[idx] = null;
            rehash(this.bucketSize, this.bucketSize);
            return true;
        }
        return false;
    }
}
