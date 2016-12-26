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
        int sonIndex = mNumOfChildren * (i - 1) + son + 1;
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

//    TODO get rid of the right/left sons
    private int getRightSon(int [] arr, int i) {
        return arr[(mNumOfChildren * i) + 1];
    }
//    TODO get rid of the right/left sons
    private int getLeftSon(int [] arr, int i) {
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

    private void maxHeapify(int [] arr, int i) {
        int largest;
        for (int j = 1; j <= mNumOfChildren; j++) {
            int nthSon = getNthSon(arr, i, j);
            if (nthSon == -1) {
                return;
            }
            if (j < arr.length &&  arr[i] < arr[nthSon]){
                largest = j;
            }else {
                largest = i;
            }

            if (largest > i) {
                swap(arr[i], arr[largest]);
                maxHeapify(arr,largest);
            }
        }

    }
}
