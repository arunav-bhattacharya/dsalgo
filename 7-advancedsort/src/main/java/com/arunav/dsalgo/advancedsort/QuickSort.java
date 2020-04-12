package com.arunav.dsalgo.advancedsort;

public class QuickSort {

    public QuickSort() {
    }

    public void display(int array[]) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println("");
    }

    public void sort(int[] array) {
        System.out.println("Array Length= " + array.length);
        qsort(array, 0, array.length - 1);
    }

    private void qsort(int[] array, int low, int high) {
        if (low >= high)
            return;
        System.out.println("Iteration ");
        //int k = partition(array, low, high);
        int k = partition(array, low, high);
        System.out.println("k" + k);
        qsort(array, low, k - 1);
        qsort(array, k + 1, high);
    }

    private int partition(int[] array, int low, int high) {
        int i = low - 1;
        int pivot = array[high];
        for (int j = low; j <= high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }
        return i;
    }

    private void swap(int[] array, int low, int high) {
        //System.out.println("Swap Low " + low + " High " + high);
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }
}
