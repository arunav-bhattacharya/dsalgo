package com.arunav.dsalgo.advancedsort;

public class AdvancedSortApp {

    private static int[] array = {99, 7, 8, 92, 23, 0, 23, 92, 56, 99, 7, 16};

    public static void main(String[] args) {
//        testShellSort();
        //testMergeSort();
        testQuickSort();
    }

    private static void testShellSort() {
        ShellSort shellSort = new ShellSort();
        System.out.print("Before Sort: \n");
        shellSort.display(array);
        shellSort.sort(array);
        System.out.print("After Sort: ");
        shellSort.display(array);
    }

    private static void testMergeSort() {
        MergeSort mergeSort = new MergeSort();
        System.out.print("Before Sort: ");
        mergeSort.displayArray(array);
        mergeSort.sort(array);
        System.out.print("After Sort: ");
        mergeSort.displayArray(array);
    }

    private static void testQuickSort() {
        QuickSort quickSort = new QuickSort();
        System.out.print("Before Sort: ");
        quickSort.display(array);
        quickSort.sort(array);
        System.out.print("\nAfter Sort: ");
        quickSort.display(array);
    }
}