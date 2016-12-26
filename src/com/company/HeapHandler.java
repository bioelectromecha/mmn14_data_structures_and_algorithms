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

    public int getNthSon(int[] arr, int i, int son) {
        return arr[i * mNumOfChildren + son];
    }

    public int[] buildMaxHeap(int[] arr) {
        for (int i = arr.length/2; i >= 0; i--) {
            // TODO call the real max heapify
            maxHeapify(arr,i);
        }
        return arr;
    }

    public int getRightSon(int [] arr, int i) {
        return arr[(mNumOfChildren * i) + 1];
    }

    public int getLeftSon(int [] arr, int i) {
        return arr[(mNumOfChildren * i) - (mNumOfChildren - 2)];
    }

    private void swap(int a, int b)
    {
        int temp = a;
        a = b;
        b = temp;
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

    /*
    AMIT IA GEVER ♡♡♡
     */
    public void maxHeapify(int [] arr, int i) {
        int largest;
        int l = getLeftSon(arr, i);
        int r = getRightSon(arr, i);
        if (l <= arr.length && arr[l] > arr[i]){
            largest = l;
         }else {
            largest = i;
        }

        if (r <= arr.length && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest > i) {
            swap(arr[i], arr[largest]);
        }
        maxHeapify(arr,largest);
    }
}
