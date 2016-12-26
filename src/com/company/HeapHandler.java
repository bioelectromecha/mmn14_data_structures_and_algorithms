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

    public int getRightSon(int [] arr, int i)
    {
        return arr[(mNumOfChildren * i) + 1];
    }

    public int getLeftSon(int [] arr, int i)
    {
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



    public void MAX_HEAPIFY(int [] arr, int i)
    {
        int largest = 0;
        int l = getLeftSon(arr,i);
        int r = getRightSon(arr,i);
        if (l <= arr.length && arr[l] > arr[i])
            largest = l;
        else
            largest = i;
        if (r <= arr.length && arr[r] > arr[largest])
            largest = r;
        if (largest > i)
            swap(arr[i],arr[largest]);
        MAX_HEAPIFY(arr,largest);
    }
}
