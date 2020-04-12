package com.arunav.dsalgo.recursion;

public class BinarySearch {

    private static int[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

    public static void main(String[] args) {
        System.out.println(binarySearch(0, array.length - 1, 80));
    }

    private static boolean binarySearch(int lo, int hi, int element) {

        if (lo > hi)
            return false;

        int mid = (lo + hi) / 2;

        if (element > array[mid])
            return binarySearch(mid + 1, hi, element);
        else if (element < array[mid])
            return binarySearch(lo, mid - 1, element);
        else
            return true;
    }
}
