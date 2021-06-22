package v2;

public class MaximumSubArrayJava53 {

    public static void main(String[] args) {

        System.out.println(new MaximumSubArrayJava53().maxContiguousSubarraySum(new int[]{-2, 1, -3, 4}));

    }

    public int maxContiguousSubarraySum(int[] nums) {

        int max = nums[0]; //1
        int currentMax = nums[0]; //1

        for (int i = 1; i < nums.length; i++) {

            int next = nums[i]; //-3

            int sum = currentMax + next; //-2

            currentMax = Math.max(next, sum); //-2

            max = Math.max(max, currentMax); //1
        }




        return max;
    }
}
