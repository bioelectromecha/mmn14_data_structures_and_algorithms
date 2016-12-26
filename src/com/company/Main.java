package com.company;

public class Main {

    public static void main(String[] args) {
        int[] arr1 = RandomGenerator.generateRandomizedArray(10);
        HeapHandler heapHandler = new HeapHandler(3);
        heapHandler.buildMaxHeap(arr1);
        printArray(arr1);



    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
