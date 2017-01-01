package com.company;

/**
 * Created by roman on 1/1/17.
 */
public class Tester {
    private static final int ARRAY_SIZE = 1000;
    private static final int MAX_NUM_OF_CHILDREN = 10000;
    public static void test() {
        for (int i = 2; i < MAX_NUM_OF_CHILDREN; i++) {
            Heapifier heapifier = new Heapifier(i);
            int[] arr = RandomGenerator.generateRandomizedArray(ARRAY_SIZE);
            StatKeeper stats = heapifier.heapSort(arr);
            System.out.print("d=" + i + "  n=" + ARRAY_SIZE + "  " + "  comparisons=" + stats.numberOfComparisons + "  swaps=" + stats.numberOfSwaps + "\r\n");
        }
    }
}
