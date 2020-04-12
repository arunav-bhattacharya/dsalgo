package com.arunav.dsalgo.arrays;

/*
 * 2.4 Modify the orderedArray.java program (Listing 2.4) so that the insert() and delete() routines, as well as find
 * (), use a binary search, as suggested in the text.
 *
 * 2.5 Add a merge() method to the OrdArray class in the orderedArray.java program (Listing 2.4) so that you can
 * merge two ordered source arrays into an ordered destination array. Write code in main() that inserts some random
 * numbers into the two source arrays, invokes merge(), and displays the contents of the resulting destination array.
 * The source arrays may hold different numbers of data items. In your algorithm you will need to compare the keys
 * of the source arrays, picking the smallest one to copy to the destination. You’ll also need to handle the
 * situation when one source array exhausts its contents before the other.
 *
 */

public class OrderedArray {

    private long[] arr;
    private int noOfElements;
    private int size;
    private int currIndex;

    public OrderedArray(int size) {
        this.size = size;
        arr = new long[size];
        noOfElements = 0;
    }

    public long[] getArr() {
        return arr;
    }

    public int getNoOfElements() {
        return noOfElements;
    }

    public boolean find(long searchKey) {
        int lowerBound = 0;
        int upperBound = noOfElements - 1;
        int currIndex = 0;

        while (true) {
            currIndex = (lowerBound + upperBound) / 2;
            if (arr[currIndex] == searchKey) {
                this.currIndex = currIndex;
                return true;
            } else if (lowerBound > upperBound)
                return false;
            else {
                if (arr[currIndex] < searchKey)
                    lowerBound = currIndex + 1;
                else
                    upperBound = currIndex - 1;
            }
        }
    }

    public void insert(long value) {
        int lowerBound = 0;
        int upperBound = noOfElements - 1;
        int currIndex = 0;
        while (true) {
            currIndex = (lowerBound + upperBound) / 2;
            if (lowerBound > upperBound) {
                currIndex = lowerBound;
                break;
            } else {
                if (arr[currIndex] < value) {
                    lowerBound = currIndex + 1;
                    currIndex++;
                } else
                    upperBound = currIndex - 1;
            }
        }
        for (int i = noOfElements; i > currIndex; i--)
            arr[i] = arr[i - 1];
        arr[currIndex] = value;
        noOfElements++;
    }

    public boolean delete(long value) {
        boolean valueFound = find(value);
        while (find(value)) {
            for (int i = this.currIndex; i < noOfElements; i++) {
                arr[i] = arr[i + 1];
            }
            noOfElements--;
        }
        return valueFound;
    }

    public long[] mergeArrays(OrderedArray arr1, OrderedArray arr2) {
        long finalArr[] = new long[arr1.getNoOfElements() + arr2.getNoOfElements()];
        int j = 0;
        int k = 0;
        int i = 0;

        while (j < arr1.getNoOfElements() && k < arr2.getNoOfElements()) {
            if (arr1.getArr()[j] < arr2.getArr()[k]) {
                finalArr[i] = arr1.getArr()[j];
                j++;
                i++;
            } else {
                finalArr[i] = arr2.getArr()[k];
                k++;
                i++;
            }
        }

        while (j < arr1.getNoOfElements()) {
            finalArr[i] = arr1.getArr()[j];
            i++;
            j++;
        }

        while (k < arr2.getNoOfElements()) {
            finalArr[i] = arr2.getArr()[j];
            i++;
            k++;
        }
        return finalArr;
    }

    public void display() {
        System.out.println("Elements in the Array: ");
        for (int i = 0; i < noOfElements; i++)
            System.out.println(arr[i]);
    }

    public void display(long array[]) {
        System.out.println("Elements in the Array: ");
        for (int i = 0; i < array.length; i++)
            System.out.println(array[i]);
    }
}
