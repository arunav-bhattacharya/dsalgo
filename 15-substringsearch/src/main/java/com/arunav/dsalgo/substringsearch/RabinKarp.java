package com.arunav.dsalgo.substringsearch;

import java.util.ArrayList;
import java.util.List;

public class RabinKarp implements SubstringSearch {

    private static final int prime = 3;

    @Override
    public List<Integer> substring(String text, String pattern) {

        List<Integer> indices = new ArrayList<>();
        int patternHash = createHash(pattern);
        int textPatternHash = createHash(text.substring(0, pattern.length()));

        for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
            if (i > 0) {
                char charToRemove = text.charAt(i - 1);
                char chatToAdd = text.charAt(i + pattern.length() - 1);
                textPatternHash = rollHash(textPatternHash, charToRemove, chatToAdd, pattern.length());
            }
            if (patternHash == textPatternHash) {
                String textSubstring = text.substring(i, i + pattern.length());
                if (textSubstring.equals(pattern))
                    indices.add(i);
            }
        }
        return indices;
    }

    private int createHash(String pattern) {
        int hash = 0;
        int exponent = 0;
        for (int i = 0; i < pattern.length(); i++) {
            hash += (int) (pattern.charAt(i) * Math.pow(prime, exponent));
            exponent++;
        }
        return hash;
    }

    private int rollHash(int hash, char deleteChar, char addChar, int patternLength) {
        hash -= deleteChar;
        hash /= prime;
        hash += (int) (addChar * Math.pow(prime, patternLength - 1));
        return hash;
    }
}
