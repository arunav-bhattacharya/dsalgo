package com.arunav.dsalgo.substringsearch;

import java.util.ArrayList;
import java.util.List;

public class BruteForce implements SubstringSearch {
    @Override
    public List<Integer> substring(String text, String pattern) {

        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
                if (j == pattern.length() - 1)
                    indices.add(i);
            }
        }
        return indices;
    }
}
