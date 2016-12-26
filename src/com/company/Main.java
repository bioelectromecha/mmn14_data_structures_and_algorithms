package com.company;

/**
 *
 * a program that generates random arrays, sorts them using heapSort and prinst out the number of comparisons performed
 *
 * @author  Amit Nissan
 * @author Roman Smirnov
 * 26/12/2016
 */
public class Main {

    /**
     * do stuff
     * @param args not used
     */
    public static void main(String[] args) {

        //initialize arrays of random ints
        int[] arr1 = RandomGenerator.generateRandomizedArray(10);
        int[] arr2 = RandomGenerator.generateRandomizedArray(100);
        int[] arr3 = RandomGenerator.generateRandomizedArray(200);

        //each handler is create to handle a different d-nary heap size
        HeapUtils binaryHeapUtils = new HeapUtils(2);
        HeapUtils trinaryHeapUtils = new HeapUtils(3);
        HeapUtils quternaryHeapUtils = new HeapUtils(4);
        HeapUtils pantanaryHeapUtils = new HeapUtils(5);

        binaryHeapUtils.buildMaxHeap(arr1);
        printArray(arr1);
        System.out.println();
        binaryHeapUtils.heapSort(arr1);
        printArray(arr1);
//        printArray(arr2);
//        printArray(arr3);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }


}
