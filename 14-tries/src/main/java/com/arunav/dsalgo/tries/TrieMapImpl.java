package com.arunav.dsalgo.tries;

import java.util.*;

public class TrieMapImpl<T> implements Trie<T> {

    private TrieNode<T> root;
    private int nItems;

    private static class TrieNode<T> {
        private Map<Character, TrieNode<T>> child = new HashMap<>();
        private T value;
    }

    public TrieMapImpl() {
        this.root = new TrieNode<T>();
        this.nItems = 0;
    }

    public void put(String key, T value) {
        TrieNode<T> curr = root;
        for (int i = 0; i < key.length(); i++) {
            TrieNode<T> next = curr.child.get(key.charAt(i));
            if (next == null) {
                next = new TrieNode<>();
                curr.child.put(key.charAt(i), next);
            }
            curr = next;
        }
        curr.value = value;
        nItems++;
    }

    public T get(String key) {
        TrieNode<T> curr = root;
        for (int i = 0; i < key.length(); i++) {
            TrieNode<T> next = curr.child.get(key.charAt(i));
            if (next == null)
                return null;
            curr = next;
        }
        return curr.value;
    }

    public boolean contains(String key) {
        TrieNode<T> curr = root;
        for (int i = 0; i < key.length(); i++) {
            TrieNode<T> next = curr.child.get(key.charAt(i));
            if (next == null)
                return false;
            curr = next;
        }
        return true;
    }

    public void delete(String key) {
        nItems--;
        delete(key, root, 0);
    }

    private boolean delete(String key, TrieNode<T> curr, int charIdx) {
        if (key.length() == charIdx) {
            if (curr.value == null)
                return false;
            curr.value = null;
            return !hasChildren(curr);
        }
        char c = key.charAt(charIdx);
        if (curr.child.get(c) == null)
            return false;
        boolean toBeDeleted = delete(key, curr.child.get(c), charIdx + 1);

        if (toBeDeleted) {
            if (curr.child.get(c).value == null)
                curr.child.remove(c);
            return !hasChildren(curr.child.get(c));
        }
        return false;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public Iterable<String> startsWith(String prefix) {

        TrieNode<T> curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            TrieNode<T> next = curr.child.get(prefix.charAt(i));
            curr = next;
            if (next == null)
                break;
        }
        if (curr == null)
            return new ArrayDeque<>();

        Queue<String> queue = new ArrayDeque<>();
        collect(queue, prefix, curr);
        return queue;
    }


    public String longestKeyOfPrefix(String prefix) {
        TrieNode<T> curr = root;
        String key = "";
        for (int i = 0; i < prefix.length(); i++) {
            if (curr.value != null)
                key = prefix.substring(0, i);
            TrieNode<T> next = curr.child.get(prefix.charAt(i));
            if (next == null)
                break;
            curr = next;
        }
        return key;
    }

    @Override
    public Iterable<String> keys() {
        Queue<String> queue = new ArrayDeque<>();
        collect(queue, "", root);
        return queue;
    }

    public int size() {
        return nItems;
    }

    private void collect(Queue<String> queue, String prefix, TrieNode<T> curr) {
        if (curr.value != null)
            queue.add(prefix);
        for (Character c : curr.child.keySet())
            collect(queue, prefix + c, curr.child.get(c));
    }

    private boolean hasChildren(TrieNode<T> node) {
        return node.child.size() > 0;
    }
}
