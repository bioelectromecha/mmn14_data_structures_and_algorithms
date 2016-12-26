package com.company;

/**
 * This class is used to construct and perform operations on arrays
 */
public class HeapUtils {

    private int mNumOfChildren;

    /**
     * construct a HeapUtils to handle trees with numOfChildren
     * @param numOfChildren the number of chidlren of each heap member
     */
    public HeapUtils(int numOfChildren) {
        mNumOfChildren = numOfChildren;
    }

    /**
     * returns the nth child (zero indexed) of the ith element in the array
     * @param arr
     * @param i
     * @param son
     * @return
     */
    private int getNthSon(int[] arr, int i, int son) {
        int sonIndex = mNumOfChildren * i + son+1;
        if (sonIndex >= arr.length) {
            return -1;
        }
        return sonIndex;
    }

    public int[] buildMaxHeap(int[] arr) {
        for (int i = (arr.length-1)/2; i >= 0; i--) {
            maxHeapify(arr,i);
        }
        return arr;
    }
    private void swap(int[] arr, int posA, int posB) {
        int temp = arr[posA];
        arr[posA] = arr[posB];
        arr[posB]= temp;
    }


    private int maxSon(int[] arr,int i) {
        int maxPos = 0;
        for (int j = 1; j < mNumOfChildren; j++) {
            if (arr[j] > arr[maxPos]) {
                maxPos = j;
            }
        }
        return maxPos;
    }
    private void maxHeapify(int [] arr, int i){
        maxHeapify(arr,i,arr.length);
    }

    private void maxHeapify(int [] arr, int i, int size) {
        int largest;
        for (int j = 0; j <= mNumOfChildren; j++) {
            int nthSon = getNthSon(arr, i, j);
            if (nthSon == -1 || nthSon>=size || i>=size) {
                return;
            }
            if (arr[i] < arr[nthSon]){
                largest = nthSon;
            }else {
                largest = i;
            }

            if (largest > i) {
                swap(arr, i, nthSon);
                maxHeapify(arr,largest,size);
            }
        }
    }

    public void heapSort(int[] arr) {
        for(int i = arr.length-1; i >= 1; i--) {
            swap(arr,0,i);
            maxHeapify(arr,0, i-1);
        }
    }
//
//    /**
//     * print out the received array
//     * @param arr
//     */
//    public void printArray(int[] arr) {
//        int treeDepth = calcLogarithm(mNumOfChildren, arr.length);
//        for (int i = 0; i < ; i++) {
//            System.out.print(arr[i]+" ");
//        }
//    }
//
//    private int calcLogarithm(int base, int num) {
//        return (int)(Math.log(num) / Math.log(base));
//    }
}

