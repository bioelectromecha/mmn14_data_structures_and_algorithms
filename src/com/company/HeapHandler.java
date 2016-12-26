package com.company;

/**
 * Created by roman on 12/26/16.
 */
public class HeapHandler {

    private int mNumOfChildren;

    public HeapHandler(int numOfChildren) {
        mNumOfChildren = numOfChildren;
    }

    public int[] maxHeapify(int[] arr) {
        return new int[1];
    }

    public int getNthSon(int[] arr, int i, int son) {
        return arr[i * mNumOfChildren + son];
    }

    public int[] buildMaxHeap(int[] arr) {
        for (int i = arr.length/2; i >= 0; i--) {
        }
        return new int[0];
    }

    public int getRightSon(int [] arr, int i)
    {
        return arr[(mNumOfChildren * i) + 1];
    }

    public int getLeftSon(int [] arr, int i)
    {
        return arr[(mNumOfChildren * i) - (mNumOfChildren - 2)];
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


}
