package com.company;

/**
 * This class is used to construct and perform operations on arrays
 */
public class HeapHandler {

    private int mNumOfChildren;

    /**
     * construct a HeapHandler to handle trees with numOfChildren
     * @param numOfChildren the number of chidlren of each heap member
     */
    public HeapHandler(int numOfChildren) {
        mNumOfChildren = numOfChildren;
    }

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

    private void maxHeapify(int [] arr, int i) {
        int largest;

        for (int j = 0; j <= mNumOfChildren; j++) {
            int nthSon = getNthSon(arr, i, j);
            if (nthSon == -1) {
                return;
            }
            if (j < arr.length &&  arr[i] < arr[nthSon]){
                largest = nthSon;
            }else {
                largest = i;
            }

            if (largest > i) {
                swap(arr, i, nthSon);
                maxHeapify(arr,largest);
            }
        }
    }

    public void heapSort(int [] arr)
    {
        int len = arr.length;
        buildMaxHeap(arr);
        for (int i = len - 1; i >= 1; i--) {
            swap(arr,0,i);
            len--;
            maxHeapify(arr,0);
        }
    }
}

