package com.arunav.dsalgo.substringsearch;

import java.util.List;

public class SubstringSearchApp {

    private static final String text = "AAGCTTTAAGCTSTATAAGGTTTAACCCTTAAGGT";
    private static final String pattern = "AAGGT";

    public static void main(String[] args) {
        testBruteForce();
        testKMP();
        testRabinKarp();
    }

    private static void testBruteForce() {
        System.out.println("\nBrute Force");
        printIndices(new BruteForce());
    }

    private static void testKMP() {
        System.out.println("\nKnutt-Morris-Pratt");
        printIndices(new KnuttMorrisPratt());
    }

    private static void testRabinKarp() {
        System.out.println("\nRabin Karp");
        printIndices(new RabinKarp());
    }

    private static void printIndices(SubstringSearch search) {
        List<Integer> substring = search.substring(text, pattern);
        for (int i : substring)
            System.out.println(i);
    }
}
