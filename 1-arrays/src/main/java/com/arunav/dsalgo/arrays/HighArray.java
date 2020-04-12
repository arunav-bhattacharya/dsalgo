package com.arunav.dsalgo.arrays;

/*
2.1 To the HighArray class in the highArray.java program (Listing 2.3), add arr method called getMax() that returns
the value of the highest key in the array, or –1 if the array is empty. Add some code in main() to exercise this
method. You can assume all the keys are positive numbers.

2.2 Modify the method in Programming Project 2.1 so that the item with the highest key is not only returned by the
method, but also removed from the array. Call the method removeMax().

2.3 The removeMax() method in Programming Project 2.2 suggests a way to sort the contents of an array by key value.
Implement a sorting scheme that does not require modifying the HighArray class, but only the code in main(). You’ll
need a second array, which will end up inversely sorted. (This scheme is a rather crude variant of the selection sort
in Chapter 3, “Simple Sorting.”)

2.6 Write a noDups() method for the HighArray class of the highArray.java program (Listing 2.3). This method should
remove all duplicates from the array. That is, if three items with the key 17 appear in the array, noDups() should
remove two of them. Don’t worry about maintaining the order of the items. One approach is to first compare every item
with all the other items and overwrite any duplicates with a null (or a distinctive value that isn’t used for real
keys). Then remove all the nulls. Of course, the array size will be reduced.
*/

public class HighArray {

    private long[] arr;
    private int noOfElements;
    private int size;

    public HighArray(int size) {
        this.size = size;
        arr = new long[size];
        noOfElements = 0;
    }

    public boolean find(long searchKey) {
        for (int i = 0; i < noOfElements; i++) {
            if (arr[i] == searchKey)
                return true;
        }
        return false;
    }

    public void insert(long value) {
        if (noOfElements < size)
            arr[noOfElements] = value;
        noOfElements++;
    }

    public boolean delete(long value) {
        boolean recordFound = false;
        int j = 0;
        int offset = 0;
        int totalElements = noOfElements;
        for (int i = 0; (i + offset) < totalElements; i++) {
            if (arr[i + offset] == value) {
                recordFound = true;
                j = i + offset;
                while (arr[j] == value) {
                    noOfElements--;
                    offset++;
                    j++;
                }
                arr[i] = arr[i + offset];
            } else {
                if (recordFound)
                    arr[i] = arr[i + offset];
            }
        }
        return recordFound;
    }

    public long getMax() {
        long maxValue = -1;
        for (int i = 0; i < noOfElements; i++) {
            if (arr[i] > maxValue)
                maxValue = arr[i];
        }
        return maxValue;
    }

    public boolean removeMax() {
        long maxValue = getMax();
        if (maxValue != -1)
            return delete(maxValue);
        return false;
    }

    public long[] sort() {
        for (int i = 0; i < noOfElements; i++) {
            for (int j = 0; j < noOfElements - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    /* Swap the variables */
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
                }
            }
        }
        return arr;
    }

    public long[] noDups() {
        /* Loop1 - Iterate each element to check for duplicates */
        for (int i = 0; i < noOfElements; i++) {
            /* Loop2 - For each each element in Loop1 check all the next elements in the array */
            for (int j = i + 1; j < noOfElements; j++) {
                /* Loop3 - If a duplicate record is found, delete that record and reduce the counter of j, so that it
                can again iterate on the same element. This is required because when the selected element is deleted
                and the next element that moved into its position is also again a duplicate element, that we need to
                check. Hence j-- */
                if (arr[i] == arr[j]) {
                    for (int k = j; k < noOfElements; k++)
                        arr[k] = arr[k + 1];
                    noOfElements--;
                    j--;
                }
            }
        }
        return arr;
    }

    public void delete(int index) {

    }

    public void display() {
        System.out.println("Elements in the Array: ");
        for (int i = 0; i < noOfElements; i++)
            System.out.println(arr[i]);
    }
}
