package com.arunav.dsalgo.tries;

import java.util.ArrayDeque;
import java.util.Queue;

public class TrieArrayImpl<T> implements Trie<T> {

    private static final int radix = 26; // Assuming only lower case alphabets are allowed in the trie
    private TrieNode root;
    private int nItems;

    private static class TrieNode {
        private Object value;
        private TrieNode[] next = new TrieNode[radix];
    }

    public TrieArrayImpl() {
        this.root = new TrieNode();
        this.nItems = 0;
    }

    public void put(String key, T value) {
        if (key == null || value == null)
            throw new RuntimeException("Input key/value cannot be null");

        TrieNode curr = root;
        key = key.toLowerCase();
        for (int i = 0; i < key.length(); i++) {
            int charIdx = getIdx(key.charAt(i));
            if (curr.next[charIdx] == null) {
                TrieNode node = new TrieNode();
                curr.next[charIdx] = node;
            }
            curr = curr.next[charIdx];
        }
        curr.value = value;
        nItems++;
    }

    public T get(String key) {
        if (!contains(key))
            return null;

        TrieNode curr = root;
        key = key.toLowerCase();
        for (int i = 0; i < key.length(); i++)
            curr = curr.next[getIdx(key.charAt(i))];
        return (T) curr.value;
    }

    /*
     *  1. Start traversing from root to find the string to be deleted
     *  2. If the node is found, update the value for the word as null.
     *  3. Check if there are any children on that node.
     *  4. If children present, then don't do anything else
     *  5. If children not present, then recurse back by marking the child of the current node as null until a point
     *     where there is a path to a valid word or a valid word itself.
     */
    public void delete(String key) {
        delete(key.toLowerCase(), root, 0);
    }

    private boolean delete(String key, TrieNode node, int keyIdx) {

        if (node == null)
            return false;
        // When the word is found, then check for any children from that node.
        // If no children are there, then return true to delete the node
        // If children are there, then return false, so that the node is not deleted.
        if (keyIdx == key.length()) {
            /* If the string pattern is found, but it is not defined as a word in the trie, then return false */
            if (node.value == null)
                return false;
            node.value = null;
            nItems--;
            return !hasChildren(node);
        }
        int idx = getIdx(key.charAt(keyIdx));
        /* When unable to find the word */
        if (node.next[idx] == null)
            return false;
        /* If no child - return true, else return false */
        boolean tobeDeleted = delete(key, node.next[idx], keyIdx + 1);


        /* If the child is to be deleted, then mark the child as null and
         * then check if there are any more child from the current node
         */
        if (tobeDeleted) {
            /* If there is no word on the child then delete the child */
            if (node.next[idx].value == null)
                node.next[idx] = null;
            return !hasChildren(node);
        }
        return false;
    }

    private boolean hasChildren(TrieNode node) {
        for (int i = 0; i < radix; i++)
            if (node.next[i] != null)
                return true;
        return false;
    }

    public boolean contains(String key) {

        if (key == null)
            throw new RuntimeException("Input key cannot be null");

        key = key.toLowerCase();
        TrieNode curr = root;
        for (int i = 0; i < key.length(); i++) {
            int charIdx = getIdx(key.charAt(i));
            if (curr.next[charIdx] == null)
                return false;
            curr = curr.next[charIdx];
        }
        return curr.value != null;
    }

    public Iterable<String> startsWith(String prefix) {
        TrieNode curr = root;
        prefix = prefix.toLowerCase();
        /* Find the node with the last character on prefix */
        for (int i = 0; i < prefix.length(); i++) {
            int idx = getIdx(prefix.charAt(i));
            if (curr.next[idx] == null)
                throw new RuntimeException("Invalid prefix");
            curr = curr.next[idx];
        }
        Queue<String> queue = new ArrayDeque<>();
        collect(queue, curr, prefix);
        return queue;
    }

    /*
     * Returns the longest key for a given prefix
     */
    public String longestKeyOfPrefix(String prefix) {
        prefix = prefix.toLowerCase();
        TrieNode curr = root;
        String key = "";
        for (int i = 0; i < prefix.length(); i++) {
            int idx = getIdx(prefix.charAt(i));
            if (curr.value != null)
                key = prefix.substring(0, i);
            if (curr.next[idx] == null)
                break;
            curr = curr.next[idx];
        }
        return key;
    }

    @Override
    public Iterable<String> keys() {
        Queue<String> queue = new ArrayDeque<>();
        collect(queue, root, "");
        return queue;
    }

    public int size() {
        return nItems;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    private int getIdx(char c) {
        // Subtracting the ASCII value of 'a' from input char. Let i/p char is 'x', then idx of x = Ascii value of ('x' - 'a')
        return c - 'a';
    }

    private void collect(Queue<String> queue, TrieNode curr, String prefix) {
        if (curr.value != null)
            queue.add(prefix);
        for (int i = 0; i < radix; i++) {
            if (curr.next[i] != null)
                collect(queue, curr.next[i], prefix + (char) (i + 'a'));
        }
    }
}
