package com.company;

import java.util.Random;

/**
 * Created by roman on 12/26/16.
 */
public class RandomGenerator {
    private static final int MAX_INT_SIZE = 1024;
    public static int[] generateRandomizedArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(MAX_INT_SIZE);
        }
        return arr;
    }
}
