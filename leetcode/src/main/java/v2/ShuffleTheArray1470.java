package v2;

import java.util.ArrayList;
import java.util.Arrays;

public class ShuffleTheArray1470 {


  //  1 1 2 2


    public int[] shuffle(int[] nums, int n) {

        int[] result = new int[nums.length];

        int j = 0;

        for (int i = 0; i < nums.length / 2; i++) {

            int first = nums[i];
            int second = nums[i + n];

            result[j] = first;
            result[j + 1] = second;

            j = j + 2;

        }




        return result;
    }

    public static void main(String[] args) {
        int[] shuffle = new ShuffleTheArray1470().shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3);


        System.out.println(Arrays.toString(shuffle));
    }


}
