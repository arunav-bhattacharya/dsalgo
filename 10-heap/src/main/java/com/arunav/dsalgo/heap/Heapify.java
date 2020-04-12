package com.arunav.dsalgo.heap;

public class Heapify {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 60, 50, 90, 40, 80, 70};

        for (int i = arr.length / 2; i >= 0; i--)
            heapfiy(arr, i);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    private static void heapfiy(int[] arr, int idx) {
        int currIdx = idx;
        int leftIdx, rightIdx, largerIdx = -1;

        while (idx < arr.length / 2) {
            leftIdx = 2 * currIdx + 1;
            rightIdx = leftIdx + 1;

            if (leftIdx < arr.length - 1 && arr[leftIdx] > arr[rightIdx])
                largerIdx = leftIdx;

            if (rightIdx < arr.length && arr[leftIdx] < arr[rightIdx])
                largerIdx = rightIdx;

            if (largerIdx > -1 && arr[currIdx] < arr[largerIdx]) {
                swap(arr, currIdx, largerIdx);
                currIdx = largerIdx;
            } else
                break;
        }
    }

    private static void swap(int[] arr, int currIdx, int largerIdx) {
        int temp = arr[currIdx];
        arr[currIdx] = arr[largerIdx];
        arr[largerIdx] = temp;
    }
}
