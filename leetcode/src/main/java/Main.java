import java.util.*;

public class Main {

    public static void main(String[] args) {

        final String str1 = new String("string");
        final String str2 = new String("string");

        System.out.println(str1.equals(str2));



//        int[] ints = new Solution_1().twoSum(new int[]{2, 3, 4}, 6);
//        int reverse = new Solution_7().reverse(123);
//        boolean isPalindrome = new Solution_9().isPalindrome(-121);
//        int iii = new Solution_13().romanToInt("MCMXCIV");
//        String s = new Solution_14().longestCommonPrefix(new String[]{"flower", "flow", "flight"});
//        int[] result = new Solution_66().plusOne(new int[]{2, 4, 9, 3, 9});
//        String s1 = new Solution_14_2().longestCommonPrefix(new String[]{"flower", "flow", "flight"});


        int[] ints1 = new int[]{1, 1, 2};

        new Solution_26().checneAray(ints1);

        System.out.println("");

//        int i = new Solution_26().removeDuplicates(ints1);
//
//        System.out.println("result " + i);
//        for (int j = 0; j < ints1.length; j++) {
//            System.out.println(ints1[j]);
//        }
    }
}


class Solution_26 {
    public int removeDuplicates(int[] nums) {
        Arrays.sort(nums);
        int [] arr = new int[0];

        for (int i = 0; i < nums.length; i++) {

            if (i == nums.length - 1){
                arr = Arrays.copyOf(arr, arr.length + 1);
                arr[arr.length- 1] = nums[i];
            }

            else if (nums[i] != nums[i + 1]) {
                arr = Arrays.copyOf(arr, arr.length + 1);
                arr[arr.length- 1] = nums[i];
            }

        }
        nums = arr;
        return arr.length;
    }


    void checneAray(int[] nums){

        nums = null;
    }
}

class Solution_204 {
    // null -> a -> b -> c
    public ListNode reverseList(ListNode head) {
        // current = 1
        ListNode current = head;
        // previous = null
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return current;
    }
}


class Solution_14_2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String result = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String stIPlusOne = strs[i];
            while (stIPlusOne.indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
            }
        }
        return result;
    }
}


//9 9 9
class Solution_66 {
    public int[] plusOne(int[] digits) {

        int i = digits.length - 1;

        if (digits[i] != 9) {
            digits[i]++;
        }

        if (digits.length == 1 && digits[i] == 9) {
            int[] ints = new int[digits.length + 1];
            ints[0] = 1;
            digits = ints;
        }

        while (i > 0 && digits[i] == 9) {
            digits[i] = 0;
//2,4,9,3,9
            if ((digits[i - 1] < 9) || (i == 1 && digits[i - 1] == 9)) {
                digits[i - 1]++;
            }

            i--;
        }

        if ((digits[0] == 10)) {
            int[] ints = new int[digits.length + 1];
            ints[0] = 1;
            digits = ints;
        }


        return digits;
    }
}

class Solution_14 {
    public String longestCommonPrefix(String[] strs) {
        int arrayLength = strs.length;

        String firstString = strs[0];

        String prefix = "";

        for (int i = 1; i < arrayLength; i++) {

            String nString = strs[i];
            int j = 0;

            for (; j < firstString.length() - 1; j++) {

                if (j >= nString.length()) {
                    break;
                }

                char charOne = firstString.charAt(j);
                char charTwo = nString.charAt(j);

                if (charOne != charTwo) {
                    break;
                }

            }

            prefix = firstString.substring(0, j);

        }

        return prefix;
    }
}

class Solution_13 {
    public int romanToInt(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char c = s.charAt(0);
        int result = getValue(c);

        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            char next = s.charAt(i + 1);
            int currentNum = getValue(current);
            int nextNum = getValue(next);
            if (currentNum < nextNum) {
                currentNum = nextNum - currentNum;
                i++;
            }
            result = result + currentNum;
        }
        return result;
    }

    //MCMXCIV 1994
    public int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}

//11, 7, 2, 15


class Solution_1 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int val1 = nums[i];
            int val2 = target - val1;
            if (map.containsKey(val2) && i != map.get(val2)) {
                return new int[]{i, map.get(val2)};
            }
        }
        throw new RuntimeException("VALUE NOT FOUND");
    }
}

class Solution_7 {
    public int reverse(int x) {
        boolean isNegative = x < 0;
        int result = 0;
        while (x != 0) {
            int val = x % 10;
            x = x / 10;

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && val > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && val < -8)) return 0;


            result = result * 10 + val;
        }
        return result;
    }
}

class Solution_9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int input = x;

        int result = 0;
        while (x != 0) {
            int val = x % 10;
            result = result * 10 + val;
            x /= 10;
        }
        return result == input;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

