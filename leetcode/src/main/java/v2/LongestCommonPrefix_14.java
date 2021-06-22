package v2;

public class LongestCommonPrefix_14 {

    public static void main(String[] args) {

        boolean b = new Solution().checkZeroOnes("110100010");

   //     System.out.println(b);


    }



}

class Solution {
    public boolean checkZeroOnes(String s) {
    //    String[] split = s.split("");

        int zeroTotal = 0;
        int zeroCount = 0;

        int oneTotal = 0;
        int oneCount = 0;

        char current = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {

            char next = s.charAt(i);

            if (current == '0'){
                    zeroCount++;
                if (next == '1'){
                    zeroTotal = Math.max(zeroTotal, zeroCount);
                    zeroCount = 0;
                }
            }

            if (current == '1'){
                oneCount++;
                if (next == '0'){
                    oneTotal = Math.max(oneTotal, oneCount);
                    oneCount = 0;
                }
            }

            current = next;
        }

        if (current == '0'){
            zeroCount++;
        }
        if (current == '1'){
            oneCount++;
        }

        zeroTotal = Math.max(zeroTotal, zeroCount);
        oneTotal = Math.max(oneTotal, oneCount);

        return oneTotal > zeroTotal;
    }
}
