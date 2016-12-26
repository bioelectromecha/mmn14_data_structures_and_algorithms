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
        int[] arr1 = RandomGenerator.generateRandomizedArray(50);
        int[] arr2 = RandomGenerator.generateRandomizedArray(100);
        int[] arr3 = RandomGenerator.generateRandomizedArray(200);

        //each handler is create to handle a different d-nary heap size
        Heapifier binaryHeapifier = new Heapifier(2);
        Heapifier trinaryHeapifier = new Heapifier(3);
        Heapifier quternaryHeapifier = new Heapifier(4);
        Heapifier pentanaryHeapifier = new Heapifier(5);

        //print binary heaps
        System.out.println("\r\n ///////////Binary Heaps\\\\\\\\\\\\");
        printStats(binaryHeapifier.heapSort(arr1));
        printStats(binaryHeapifier.heapSort(arr2));
        printStats(binaryHeapifier.heapSort(arr3));

        //print binary heaps
        System.out.println("\r\n ///////////Trinary Heaps\\\\\\\\\\\\");
        printStats(trinaryHeapifier.heapSort(arr1));
        printStats(trinaryHeapifier.heapSort(arr2));
        printStats(trinaryHeapifier.heapSort(arr3));

        //print quaternary heaps
        System.out.println("\r\n ///////////Quaternary Heaps\\\\\\\\\\\\");
        printStats(quternaryHeapifier.heapSort(arr1));
        printStats(quternaryHeapifier.heapSort(arr2));
        printStats(quternaryHeapifier.heapSort(arr3));

        //print pantanary heaps
        System.out.println("\r\n ///////////Pentanary Heaps\\\\\\\\\\\\");
        printStats(pentanaryHeapifier.heapSort(arr1));
        printStats(pentanaryHeapifier.heapSort(arr2));
        printStats(pentanaryHeapifier.heapSort(arr3));

        System.out.println("\r\n DONE!");
    }
    private static void printArray(int[] arr) {
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
    }

    private static void printStats(StatKeeper statKeeper) {
        System.out.println("The number of comparisons was: " + statKeeper.numberOfComparisons+" , "+"The number of swaps was: " + statKeeper.numberOfSwaps);
    }


}
