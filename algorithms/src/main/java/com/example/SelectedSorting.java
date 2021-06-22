package com.example;

import java.util.Arrays;

public class SelectedSorting {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 55, 0 , 4};

        int[] sorted = sort(arr);

        System.out.println(Arrays.toString(sorted));
    }

    public static int[] sort(int[] arr) {
        for (int left = 0; left < arr.length; left++) {
            int minInd = left;
            for (int i = left; i < arr.length; i++) {
                if (arr[i] < arr[minInd]) {
                    minInd = i;
                }
            }
            swap(arr, left, minInd);
        }

        return arr;
    }

    public static int[] swap(int[] arr, int a, int b) {
        int swap = arr[a];
        arr[a] = arr[b];
        arr[b] = swap;
        return arr;
    }

}
