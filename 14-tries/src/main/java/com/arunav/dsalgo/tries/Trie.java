package com.arunav.dsalgo.tries;

public interface Trie<T> {

    void put(String key, T value);

    T get(String key);

    void delete(String key);

    boolean contains(String key);

    boolean isEmpty();

    Iterable<String> startsWith(String prefix);

    String longestKeyOfPrefix(String prefix);

    Iterable<String> keys();

    int size();
}
