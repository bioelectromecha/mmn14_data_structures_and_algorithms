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


}
