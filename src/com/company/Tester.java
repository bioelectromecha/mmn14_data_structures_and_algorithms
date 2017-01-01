package com.company;

/**
 * Created by roman on 1/1/17.
 */
public class Tester {
    public static void test() {
        for (int i = 2; i < 10; i++) {
            Heapifier heapifier = new Heapifier(i);
            for (int j = 50; j <= 1000; j+=50) {
                int[] arr = RandomGenerator.generateRandomizedArray(j);
                StatKeeper stats = heapifier.heapSort(arr);
                System.out.print("d="+i+"  n="+j+"  "+"  comparisons="+stats.numberOfComparisons+"  swaps="+stats.numberOfSwaps+"\r\n");
            }
        }
    }
}
