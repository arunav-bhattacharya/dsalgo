package com.arunav.dsalgo.heap;

public class Heapify {

    public static void main(String[] args) {
//        int[] arr = {10, 20, 30, 60, 50, 90, 40, 80, 70};

        int[] arr1 = {9, 4, 7, 1, -2, 6, 5, -8, -11, -9, -3, -6};
        for (int i = arr1.length / 2; i >= 0; i--)
            heapifyMin(arr1, i);

        for (int j : arr1) System.out.print(j + " ");

        System.out.println();
        int[] arr2 = {-11, -9, -6, 1, -8, 6, 5, 4, 9, -2, -3, 7};
        for (int i = arr2.length / 2; i >= 0; i--)
            heapifyMax(arr2, i);

        for (int j : arr2) System.out.print(j + " ");
    }

    private static void heapifyMax(int[] arr, int idx) {
        int currIdx = idx;

        while (currIdx < arr.length / 2) {
            int leftIdx = 2 * currIdx + 1;
            int rightIdx = leftIdx + 1;
            int maxIdx = -1;

            if (leftIdx < arr.length && rightIdx < arr.length)
                maxIdx = arr[leftIdx] > arr[rightIdx] ? leftIdx : rightIdx;
            else if (leftIdx < arr.length) maxIdx = leftIdx;

            if (maxIdx > -1 && arr[maxIdx] > arr[currIdx]) {
                swap(arr, currIdx, maxIdx);
                currIdx = maxIdx;
            } else break;
        }
    }

    private static void heapifyMin(int arr[], int idx){

        while (idx < arr.length/2){
            int left = 2 * idx + 1;
            int right = left + 1;
            int minIdx = -1;

            if (left < arr.length && right < arr.length)
                minIdx = arr[left] < arr[right] ? left : right;
            else if (left < arr.length) minIdx = left;

            if(minIdx > -1 && arr[minIdx] <= arr[idx]){
                swap(arr, idx, minIdx);
                idx = minIdx;
            } else break;
        }
    }

    private static void swap(int[] arr, int currIdx, int largerIdx) {
        int temp = arr[currIdx];
        arr[currIdx] = arr[largerIdx];
        arr[largerIdx] = temp;
    }
}
