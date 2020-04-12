package com.arunav.dsalgo.simplesort;

public class SimpleSortApp {

    public static void main(String[] args) {
        testInsertionSort();
    }

    private static void testInsertionSort() {

        long arr[] = {84, 2, 54, 13, 63, 74, 96, 2, 9, 96, 13, 18, 2, 96, 63, 13, 23, 37};
        InsertionSort insertionSort = new InsertionSort(arr);
        insertionSort.insertionSortNoDups(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
        System.out.println("No Dups");

        for (long element : arr)
            System.out.println(element);

        insertionSort.insertionSort(arr);
        System.out.println("Median: " + insertionSort.median(arr));

        for (long element : arr)
            System.out.println(element);

        System.out.println("Removing Duplicates");
        insertionSort.noDups(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }
}
