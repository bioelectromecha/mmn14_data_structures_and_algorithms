package com.company;

/**
 * Created by roman on 1/1/17.
 */
public class Tester {
    public static void test() {
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
        printStats(binaryHeapifier.heapSort(arr1),50);
        printStats(binaryHeapifier.heapSort(arr2),100);
        printStats(binaryHeapifier.heapSort(arr3),200);

        //print trinary heaps
        System.out.println("\r\n ///////////Trinary Heaps\\\\\\\\\\\\");
        printStats(trinaryHeapifier.heapSort(arr1),50);
        printStats(trinaryHeapifier.heapSort(arr2),100);
        printStats(trinaryHeapifier.heapSort(arr3),200);


        //print quaternary heaps
        System.out.println("\r\n ///////////Quaternary Heaps\\\\\\\\\\\\");
        printStats(quternaryHeapifier.heapSort(arr1),50);
        printStats(quternaryHeapifier.heapSort(arr2),100);
        printStats(quternaryHeapifier.heapSort(arr3),200);

        //print pantanary heaps
        System.out.println("\r\n ///////////Pentanary Heaps\\\\\\\\\\\\");
        printStats(pentanaryHeapifier.heapSort(arr1),50);
        printStats(pentanaryHeapifier.heapSort(arr2),100);
        printStats(pentanaryHeapifier.heapSort(arr3),200);

        System.out.println("\r\n DONE!");
    }
    private static void printStats(StatKeeper statKeeper, int i) {
        System.out.println("For " + i + " nodes:  the number of comparisons was: " + statKeeper.numberOfComparisons+" , "+"The number of assignments was: " + statKeeper.numberOfAssignments);
    }
}
