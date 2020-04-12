package com.arunav.dsalgo.substringsearch;

import java.util.ArrayList;
import java.util.List;

public class KnuttMorrisPratt implements SubstringSearch {

    @Override
    public List<Integer> substring(String text, String pattern) {

        List<Integer> indexList = new ArrayList<>();
        int[] lps = new int[pattern.length()];

        computeLps(pattern, lps);

        int i = 0, j = 0;
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) // Go back to the previous prefix
                    j = lps[j - 1];
                else // Continue comparison from the beginning of the lps
                    i++;
            }
            if (j == pattern.length()) {
                indexList.add(i - j);
                j = lps[j - 1];
            }
        }
        return indexList;
    }

    private void computeLps(String pattern, int[] lps) {
        lps[0] = 0;
        int i = 1, j = 0;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0)
                    j = lps[j - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
