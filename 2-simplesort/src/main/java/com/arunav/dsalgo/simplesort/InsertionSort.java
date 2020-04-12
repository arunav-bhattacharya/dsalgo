package com.arunav.dsalgo.simplesort;

public class InsertionSort {

    private int noOfElements = 0;

    public InsertionSort(long arr[]) {
        this.noOfElements = arr.length;
    }

    public void insertionSort(long arr[]) {
        int j = 0;
        long temp = 0;
        /* Loop over each element until end of array */
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            /* Loop until the current element in outer loop (stored in temp) is smaller than the previous element. In
             each of this iteration shift the elements from the left to right */
            for (j = i; (j > 0) && (arr[j - 1] > temp); j--)
                arr[j] = arr[j - 1];
            /* Once all the elements are the larger elements in the current loop is shifted to the right, then move
            the current element from the outer loop (temp) to the vacant position in the left that is created after
            shifting the elements */
            arr[j] = temp;
        }
    }

    /* 3.3 To the insertSort.java program (Listing 3.3), add a method called noDups() that removes duplicates from a
    previously sorted array without disrupting the order. (You can use the insertionSort() method to sort the data,
    or you can simply use main() to insert the data in sorted order.) One can imagine schemes in which all the items
    from the place where a duplicate was discovered to the end of the array would be shifted down one space every
    time a duplicate was discovered, but this would lead to slow O(N2) time, at least when there were a lot of
    duplicates. In your algorithm, make sure no item is moved more than once, no matter how many duplicates there are.
    This will give you an algorithm with O(N) time. */

    public void noDups(long arr[]) {
        noOfElements = arr.length;
        int total = noOfElements;
        long currItem = noOfElements >= 1 ? arr[1] : 0;
        int dupCount = 0;
        for (int i = 0; i < total; i++) {
            if (arr[i] == currItem) {
                dupCount++;
                noOfElements--;
            } else {
                currItem = arr[i];
                arr[i - dupCount] = arr[i];
            }
        }
    }

    /* 3.2 Add a method called median() to the ArrayIns class in the insertSort.java program (Listing 3.3). This
    method should return the median value in the array. (Recall that in a group of numbers half are larger than the
    median and half are smaller.) Do it the easy way.*/

    public long median(long arr[]) {
        int totalElements = arr.length;
        int medianIndex = totalElements / 2;
        if (totalElements % 2 == 0) {
            return (arr[medianIndex] + arr[medianIndex - 1]) / 2;
        } else
            return arr[medianIndex];
    }


    /*
     * 3.6 Here’s an interesting way to remove duplicates from an array. The insertion sort uses a loop-within-a-loop
     * algorithm that compares every item in the array with every other item. If you want to remove duplicates, this
     * is one way to start. (See also Exercise 2.6 in Chapter 2.) Modify the insertionSort() method in the
     * insertSort.java program so that it removes duplicates as it sorts. Here’s one approach: When a duplicate is
     * found, write over one of the duplicated items with a key value less than any normally used (such as –1, if
     * all the normal keys are positive). Then the normal insertion sort algorithm, treating this new key like any
     * other item, will put it at index 0. From now on the algorithm can ignore this item. The next duplicate will
     * go at index 1, and so on. When the sort is finished, all the removed dups (now represented by –1 values)
     * will be found at the beginning of the array. The array can then be resized and shifted down so it starts at 0.
     *
     * */

    public void insertionSortNoDups(long[] arr) {
        int j = 0;
        long temp = 0;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (j = i; j > 0; j--) {
                if (arr[j - 1] > temp)
                    arr[j] = arr[j - 1];
                else if (arr[j - 1] == temp) {
                    temp = -1;
                    arr[j] = arr[j - 1];
                } else
                    break;
            }
            arr[j] = temp;
        }

        j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
            } else {
                arr[j] = arr[i];
                j++;
            }
        }
        noOfElements = j;
    }
}
