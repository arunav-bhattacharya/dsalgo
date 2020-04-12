package com.arunav.dsalgo.tries;

import java.util.Queue;

public class TrieApp {

    private static Trie<Integer> trie;

    public static void main(String[] args) {
        //testTrieArrayImpl();
        testTrieMapImpl();
    }

    private static void testTrieArrayImpl() {
        System.out.println("Testing Array Implementation");
        trie = new TrieArrayImpl<>();
        testTrie();
    }

    private static void testTrieMapImpl() {
        System.out.println("Testing Map Implementation");
        trie = new TrieMapImpl<>();
        testTrie();
    }

    private static void testTrie() {
        testInsert();
        testSearch();
        testSelectAll();
        testDelete();
        testStartsWith("H");
        testLongestPrefix("Hiiii");
    }


    private static void testInsert() {
        System.out.println("Inserting in Trie");

        trie.put("Hello", 1);
        trie.put("Hellooo", 2);
        trie.put("Hell", 3);
        trie.put("Hiii", 4);
        trie.put("Hi", 5);
        trie.put("How", 6);
        trie.put("However", 7);
        trie.put("He", 8);
        System.out.println("Size after Insert: " + trie.size());
    }

    private static void testSearch() {
        System.out.println("Searching in Trie");

        System.out.println(trie.get("Hello"));
        System.out.println(trie.get("Hellooooo"));
        System.out.println(trie.get("Hellooo"));
        System.out.println(trie.get("Hell"));
        System.out.println(trie.get("Hel"));
        System.out.println(trie.get("Hi"));
        System.out.println(trie.get("Hiiiii"));
        System.out.println(trie.get("Hiii"));
        System.out.println(trie.get("How"));
        System.out.println(trie.get("However"));
    }

    private static void testSelectAll() {
        System.out.println("All keys in Trie");
        Queue<String> queue = (Queue<String>) trie.keys();
        while (!queue.isEmpty())
            System.out.println(queue.poll());
    }

    private static void testDelete() {
        System.out.println("Deleting in Trie");

        trie.delete("Hiiiiiiiiii");
        trie.delete("How");
        System.out.println("Size after Delete: " + trie.size());
    }

    private static void testStartsWith(String prefix) {
        System.out.println("Prefix search in Trie");

        Queue<String> queue = (Queue<String>) trie.startsWith(prefix);
        while (!queue.isEmpty())
            System.out.println(queue.poll());
    }

    private static void testLongestPrefix(String prefix) {
        System.out.println("Longest key for prefix '" + prefix + "' is " + trie.longestKeyOfPrefix(prefix));
    }
}
