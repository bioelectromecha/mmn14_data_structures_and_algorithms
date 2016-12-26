package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr1 = RandomGenerator.generateRandomizedArray(10);

        HeapHandler heapHandler = new HeapHandler(2);

        heapHandler.buildMaxHeap(arr1);

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]+" ");
        }
    }
}
