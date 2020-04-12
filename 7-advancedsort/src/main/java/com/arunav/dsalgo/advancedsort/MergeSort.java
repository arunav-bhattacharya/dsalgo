package com.arunav.dsalgo.advancedsort;

public class MergeSort {

    private int[] array;

    public MergeSort() {
    }

    public void sort(int[] array) {
        this.array = array;
        int temp[] = new int[array.length];
        mSort(array, temp, 0, array.length - 1);
    }

    private void mSort(int[] array, int[] temp, int start, int end) {
        /* Return to the previous call, if the start index >= end index */
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        /* Sort the left sub-array until one element is present in the left sub-array. When there is one element in
        array it is considered to be sorted. */
        mSort(array, temp, start, mid);
        /* Sort the right sub-array until one element is present in the right sub-array. When there is one element in
        array it is considered to be sorted. */
        mSort(array, temp, mid + 1, end);
        /* When two sub-arrays are sorted, then both needs to be merged in a sorted manner */
        merge(array, temp, start, mid, end);
    }

    /* In the merge method the following steps are done -
     * 1. Copy the input array to the temp array
     * 2. Treat the temp array as 2 sub-arrays with start, mid & end indices as passed in from the calling method
     * 3. Compare the values in the sub-arrays of the temp array (as the sub-arrays are sorted recursively) and mSort
     * and put the values in the main array
     * */
    private void merge(int[] array, int[] temp, int start, int mid, int end) {

        /*Copy input array[] to temp[] between start and end indices*/
        for (int i = start; i <= end; i++)
            temp[i] = array[i];

        int i = start; // The starting index of left sub-array is maintained by i
        int j = mid + 1; // The starting index of right sub-array is maintained by j
        /* k is the index of the temp array. The comparison of the values at the two sub-array indexes (i & j) will
         commence from start index till end index as passed inside the method */
        for (int k = start; k <= end; k++) {
            if (i > mid) // completed traversing the left sub-array, then copy contents from right sub-array
                array[k] = temp[j++];
            else if (j > end) //completed traversing the right sub-array, then copy contents from left sub-array
                array[k] = temp[i++];
            else if (temp[i] > temp[j]) // left sub-array index value > right sub-array index value, copy from right
                // sub-array
                array[k] = temp[j++];
            else // left sub-array index value <= right sub-array index value, copy from left sub-array
                array[k] = temp[i++];
        }
    }

    public void displayArray(int[] array) {
        System.out.println();
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}