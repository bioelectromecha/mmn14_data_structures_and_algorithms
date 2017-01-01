package com.company;

/**
 * This class is used to construct and perform operations on arrays
 */
public class Heapifier {

    //holds the max number of children of a node
    private int mNumOfChildren;

    /**
     * construct a Heapifier to handle trees with numOfChildren
     * @param numOfChildren the number of children of each heap member
     */
    public Heapifier(int numOfChildren) {
        mNumOfChildren = numOfChildren;
    }

    /**
     * sorts an array by converting it into a heap and performing a heap sort on it
     * @param arr
     */
    public StatKeeper heapSort(int[] arr) {
        //this will hold the number of swaps and comparisons performed during the sort
        StatKeeper statKeeper = new StatKeeper();
        //construct a heap out of the array
        buildMaxHeap(arr,statKeeper);
        for(int i = arr.length-1; i >= 0; i--) {
            swap(arr,statKeeper,0,i);
            maxHeapify(arr,statKeeper,0, i);
        }
        return statKeeper;
    }

    /**
     * given an array, constructs a max heap
     * @param arr
     * @return
     */
    private void buildMaxHeap(int[] arr, StatKeeper statKeeper) {
        //half of the nodes are leafs, so start from floor(length/2), i.e first node that's not a leaf
        for (int i = (arr.length-1)/2; i >= 0; i--) {
            maxHeapify(arr,statKeeper,i);
        }
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



    /**
     * swap the values of two elements in a given array
     * @param arr
     * @param posA
     * @param posB
     */
    private void swap(int[] arr, StatKeeper statKeeper, int posA, int posB) {
        int temp = arr[posA];
        arr[posA] = arr[posB];
        arr[posB]= temp;
        statKeeper.numberOfSwaps += 3;
    }


    /**
     * take the currentNode down the heap to its proper place in the heap
     * overloads the private void maxHeapify(int [] arr, StatKeeper statKeeper, int currentNode, int arrayBound) method
     * @param arr
     * @param statKeeper
     * @param currentNode
     */
    private void maxHeapify(int[] arr,StatKeeper statKeeper, int currentNode){
        maxHeapify(arr,statKeeper, currentNode,arr.length);
    }

    /**
     * take the currentNode down the heap to its proper place in the heap
     * @param arr
     * @param statKeeper
     * @param currentNode
     * @param arrayBound
     */
    private void maxHeapify(int [] arr, StatKeeper statKeeper, int currentNode, int arrayBound) {
        int largest = currentNode;
        statKeeper.numberOfSwaps++;
        //iterate over the direct children of the current node
        for (int j = 0; j < mNumOfChildren; j++) {
            int nthSon = getNthSon(arr, currentNode, j);
            statKeeper.numberOfSwaps++;
            /* check for recursion terminating conditions:
            1) there are no children to the node
            2) the child is outside the scope of the array we defined
            3) the current node is outside the scope of the array
             */
            if (nthSon == -1 || nthSon>= arrayBound) {
                break;
            }
            //compare to find the largest child of the current node
            if (arr[largest] < arr[nthSon]) {
                statKeeper.numberOfComparisons++;
                largest = nthSon;
                statKeeper.numberOfSwaps++;
            }
        }

        // if the current node is smaller than one of it's children
        if (arr[currentNode] < arr[largest]) {
            statKeeper.numberOfComparisons++;
            swap(arr,statKeeper, currentNode, largest);
            //rinse and repeat until you get a valid max heap
            maxHeapify(arr,statKeeper,largest, arrayBound);
        }
    }
}

