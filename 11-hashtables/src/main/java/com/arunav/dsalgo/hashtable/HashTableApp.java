package com.arunav.dsalgo.hashtable;

import org.apache.commons.lang.RandomStringUtils;

import java.util.Random;

public class HashTableApp {

    private static final int SIZE = 19;

    public static void main(String[] args) {
        testLinearProbeHT();
        testQuadraticProbeHT();
        testDoubleHashingHT();
        testSeparateChainingHT();
    }

    private static void testSeparateChainingHT() {
        HashTable<String, Integer> hashTable = new SeparateChainingHashTable<>();
        System.out.println("\n\n----------------------------------------------");
        System.out.println("      S E P A R A T E    C H A I N I N G      ");
        System.out.println("----------------------------------------------");
        testHashTable(hashTable);
    }

    private static void testDoubleHashingHT() {
        HashTable<String, Integer> hashTable = new DoubleHashingHashTable<>();
        System.out.println("\n\n------------------------------------------");
        System.out.println("      D O U B L E    H A S H I N G        ");
        System.out.println("------------------------------------------");
        testHashTable(hashTable);
    }

    private static void testQuadraticProbeHT() {
        HashTable<String, Integer> hashTable = new QuadProbeHashTable<>();
        System.out.println("\n\n----------------------------------------------");
        System.out.println("      Q U A D R A T I C    P R O B I N G      ");
        System.out.println("----------------------------------------------");
        testHashTable(hashTable);
    }

    private static void testLinearProbeHT() {
        HashTable<String, Integer> hashTable = new LinearProbeHashTable<>();
        System.out.println("\n\n----------------------------------------");
        System.out.println("      L I N E A R    P R O B I N G      ");
        System.out.println("----------------------------------------");
        testHashTable(hashTable);
    }

    private static void testHashTable(HashTable<String, Integer> hashTable) {
        String random;
        String[] keys = new String[SIZE];

        System.out.println("\nAdding Elements");
        System.out.println("=================");
        for (int i = 0; i < SIZE; i++) {
            random = RandomStringUtils.random(5, true, false);
            keys[i] = random;
            hashTable.add(random, new Random().nextInt(100));
        }
        System.out.println("Bucket Size : " + hashTable.getBucketSize());
        System.out.println("No. of Items: " + hashTable.getnItems());

        System.out.println("\nDisplay All Elements");
        System.out.println("====================");
        for (HashNode hashNode : hashTable.getHashNodes())
            if (hashNode != null)
                System.out.println("Key = " + hashNode.getKey() + " Value = " + hashNode.getValue());

        System.out.println("\nRemoving Elements");
        System.out.println("=================");
        int i = 0;
        for (HashNode<String, Integer> hashNode : hashTable.getHashNodes()) {
            if (hashNode != null) {
                i++;
                if (i % 2 == 0) {
                    System.out.println("Removed Key : " + hashNode.getKey());
                    hashTable.remove(hashNode.getKey());
                }
            }
        }

        System.out.println("\nDisplay all the keys which was originally present in the hashTable");
        System.out.println("==================================================================");
        for (String key : keys)
            System.out.println(key + " : " + hashTable.contains(key));
    }
}
