package com.example;

import java.util.HashMap;
import java.util.Map;

public class ArraySum {

    public static void main(String[] args) {
        printMaxElements(new int[]{2, 1, 3}, 5);
    }

    public static void printMaxElements(int[] arr, int val) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            map.put(val - arr[i], arr[i]);

            int current = arr[i];

            if (map.containsKey(current)) {
                Integer value = map.get(current);
                System.out.println(value + " " + current);
            }


        }


    }


}
