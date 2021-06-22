package com.example;
import java.util.Arrays;

// O(N^2)
public class BubbleSorting {

    public static void main(String[] args) {
        int[] arr = new int[]{1000, 3, 10, -1, 1, 6};
        int[] sorted = sort(arr);
        String s = Arrays.toString(sorted);
        System.out.println(s);
    }

    public static int[] sort(int[] arr) {
        boolean isSorted = false;
        int j = 0;
        while (!isSorted) {
            System.out.println(j++);
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int swap = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = swap;
                    isSorted = false;
                }
            }
        }
        return arr;
    }
}
