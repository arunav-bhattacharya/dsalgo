package com.arunav.dsalgo.arrays;

public class ArrayApp {

    public static void main(String[] args) {

        testArray();
        testHighArray();
        testOrderedArray();
    }

    private static void testArray() {
        long[] arr;                  // reference to array
        arr = new long[100];         // make array
        int nElems = 0;              // number of items
        int j;                       // loop counter
        long searchKey;              // key of item to search for

        arr[0] = 77;
        arr[1] = 99;
        arr[2] = 44;
        arr[3] = 55;
        arr[4] = 22;
        arr[5] = 88;
        arr[6] = 11;
        arr[7] = 00;
        arr[8] = 66;
        arr[9] = 33;
        nElems = 10;

        for (j = 0; j < nElems; j++)
            System.out.print(arr[j] + " ");
        System.out.println("");

        searchKey = 66;              // find item with key 66
        for (j = 0; j < nElems; j++)          // for each element,
            if (arr[j] == searchKey)       // found item?
                break;                     // yes, exit before end

        if (j == nElems)                  // at the end?
            System.out.println("Can't find " + searchKey); // yes
        else
            System.out.println("Found " + searchKey);      // no

        searchKey = 55;              // delete item with key 55
        for (j = 0; j < nElems; j++)           // look for it
            if (arr[j] == searchKey)
                break;

        for (int k = j; k < nElems - 1; k++)       // move higher ones down
            arr[k] = arr[k + 1];

        for (j = 0; j < nElems; j++)      // display items
            System.out.print(arr[j] + " ");
        System.out.println("");
    }

    private static void testHighArray() {
        HighArray highArray = new HighArray(20);

        highArray.insert(11);
        highArray.insert(103);
        highArray.insert(23);
        highArray.insert(37);
        highArray.insert(3);
        highArray.insert(11);
        highArray.insert(11);
        highArray.insert(11);
        highArray.insert(72);
        highArray.insert(103);
        highArray.insert(11);
        highArray.insert(5);
        highArray.insert(3);
        highArray.insert(99);
        highArray.insert(21);
        highArray.insert(3);
        highArray.insert(11);
        highArray.insert(103);

        highArray.display();
        System.out.println("Max Element: " + highArray.getMax());

        highArray.noDups();
        highArray.display();

        highArray.delete(72);
        highArray.sort();
        System.out.println("Sorted Array");
        highArray.display();
        int searchKey = 22;
        if (highArray.find(searchKey))
            System.out.println("Record Found: " + searchKey);

        searchKey = 11;
        if (highArray.find(searchKey))
            System.out.println("Record Found: " + searchKey);

        //int value = 103;
        if (highArray.removeMax())
            System.out.println("Max Record Deleted ");
        highArray.display();
        System.out.println("Max Element: " + highArray.getMax());

        //value = 99;
        if (highArray.removeMax())
            System.out.println("Max Record Deleted ");
        highArray.display();
        System.out.println("Max Element: " + highArray.getMax());

        //value = 72;
        if (highArray.removeMax())
            System.out.println("Max Record Deleted ");
        highArray.display();
        System.out.println("Max Element: " + highArray.getMax());

    }

    private static void testOrderedArray() {
        OrderedArray orderedArray1 = new OrderedArray(20);
        OrderedArray orderedArray2 = new OrderedArray(20);

        orderedArray1.insert(11);
        orderedArray1.insert(103);
        orderedArray1.insert(23);
        orderedArray1.insert(37);
        orderedArray1.insert(3);
        orderedArray1.insert(11);
        orderedArray1.insert(62);
        orderedArray1.insert(11);
        orderedArray1.insert(21);
        orderedArray1.insert(3);
        orderedArray1.insert(11);
        orderedArray1.insert(103);

        orderedArray2.insert(11);
        orderedArray2.insert(72);
        orderedArray2.insert(103);
        orderedArray2.insert(11);
        orderedArray2.insert(5);
        orderedArray2.insert(3);
        orderedArray2.insert(99);

        orderedArray1.display();
        orderedArray2.display();

        OrderedArray orderedArray = new OrderedArray(40);
        long mergedArray[] = orderedArray.mergeArrays(orderedArray1, orderedArray2);

        orderedArray.display(mergedArray);
/*

        int searchKey = 22;
        if (orderedArray1.find(searchKey))
            System.out.println("Value Found: " + searchKey);
        else
            System.out.println("Value Not Found: " + searchKey);

        searchKey = 62;
        if (orderedArray1.find(searchKey))
            System.out.println("Value Found: " + searchKey);
        else
            System.out.println("Value Not Found: " + searchKey);

        searchKey = 103;
        if (orderedArray1.find(searchKey))
            System.out.println("Value Found: " + searchKey);
        else
            System.out.println("Value Not Found: " + searchKey);

        searchKey = 98;
        if (orderedArray1.find(searchKey))
            System.out.println("Value Found: " + searchKey);
        else
            System.out.println("Value Not Found: " + searchKey);

        int deleteValue = 83;
        if (orderedArray1.delete(deleteValue))
            System.out.println("Value Found: " + deleteValue);
        else
            System.out.println("Value Not Found: " + deleteValue);

        orderedArray1.display();

        deleteValue = 99;
        if (orderedArray1.delete(deleteValue))
            System.out.println("Value Found: " + deleteValue);
        else
            System.out.println("Value Not Found: " + deleteValue);

        orderedArray1.display();

        deleteValue = 11;
        if (orderedArray1.delete(deleteValue))
            System.out.println("Value Found: " + deleteValue);
        else
            System.out.println("Value Not Found: " + deleteValue);

        orderedArray1.display();

        deleteValue = 5;
        if (orderedArray1.delete(deleteValue))
            System.out.println("Value Found: " + deleteValue);
        else
            System.out.println("Value Not Found: " + deleteValue);

        orderedArray1.display();

        deleteValue = 103;
        if (orderedArray1.delete(deleteValue))
            System.out.println("Value Found: " + deleteValue);
        else
            System.out.println("Value Not Found: " + deleteValue);

        orderedArray1.display();
*/

    }
}