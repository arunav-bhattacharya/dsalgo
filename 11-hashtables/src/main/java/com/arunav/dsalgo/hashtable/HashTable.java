package com.arunav.dsalgo.hashtable;

public interface HashTable<K, V> {

    public void add(K key, V value);

    public boolean contains(K key);

    public boolean remove(K key);

    public int getBucketSize();

    public int getnItems();

    public HashNode<K, V>[] getHashNodes();
}
