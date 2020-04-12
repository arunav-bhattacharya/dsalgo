package com.arunav.dsalgo.advancedsort;

public class ShellSort {

    public void sort(int[] array) {
        int size = array.length;
        int h = 1;

        /* Find the increment sequence based on the input size. The increment sequence needs to be in the multiple of
         3*incrSeq + 1 */
        while (h < size / 3)
            h = 3 * h + 1;

        while (h >= 1) {
            for (int i = h; i < size; i++) {
                for (int j = i; j >= h; j = j - h) {
                    if (array[j] < array[j - h])
                        swap(array, j, j - h);
                    else
                        break;
                }
                display(array);
            }
            System.out.println("");
            h = h / 3;
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void display(int array[]) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + " ");
        System.out.println("");
    }
}
