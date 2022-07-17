package Leetcode2._564;


public class Solution {
    public String nearestPalindromic(String n) {
        if (n.length() == 1) {
            return String.valueOf(Integer.valueOf(n) - 1);
        }
        String result;
        String leftHalfStr = n.substring(0, n.length() / 2);
        boolean isOdd = n.length() % 2 != 0;
        if (isOdd) {
            leftHalfStr = n.substring(0, n.length() / 2 + 1);
        }
        int leftHalf = Integer.valueOf(leftHalfStr);
        String leftHalf1 = String.valueOf(leftHalf - 1);
        String leftHalf2 = String.valueOf(leftHalf + 1);
        String leftHalf3 = String.valueOf(leftHalf);

        String paliLeftHalf1 = getPalindromic(leftHalf1);
        String paliLeftHalf2 = getPalindromic(leftHalf2);
        String paliLeftHalf3 = getPalindromic(leftHalf3);

        if (isOdd) {
            paliLeftHalf1 = paliLeftHalf1.substring(1);
            paliLeftHalf2 = paliLeftHalf2.substring(1);
            paliLeftHalf3 = paliLeftHalf3.substring(1);
        }
        String res1 = leftHalf1 + paliLeftHalf1; 
        String res2 = leftHalf2 + paliLeftHalf2;
        String res3 = leftHalf3 + paliLeftHalf3;
        if (leftHalf - 1 == 0 || leftHalf1.length() < leftHalfStr.length()) {
            res1 = String.valueOf(Math.round(Math.pow(10, n.length() - 1)) - 1);
        }
        if (leftHalf2.length() > leftHalfStr.length()) {
            res2 = String.valueOf(Math.round(Math.pow(10, n.length())) + 1);
        }
        long val1 = Long.valueOf(res1);
        long val2 = Long.valueOf(res2);
        long val3 = Long.valueOf(res3);
        long abs1 = Math.abs(val1 - Long.valueOf(n)); 
        long abs2 = Math.abs(val2 - Long.valueOf(n));
        long abs3 = Math.abs(val3 - Long.valueOf(n));
        if (isPalindromic(n)) {   
            if (abs1 == abs2) {
                result = val1 < val2  ? res1 : res2;
            } else {
                result = abs1 < abs2 ? res1 : res2;
            }
        } else {
            Long tmpAbs, tmpVal;
            String tmpRes;
            if (abs1 == abs2) {
                tmpAbs = val1 < val2  ? abs1 : abs2;
                tmpVal = val1 < val2  ? val1 : val2;
                tmpRes = val1 < val2  ? res1 : res2;
            } else {
                tmpAbs = abs1 < abs2  ? abs1 : abs2;
                tmpVal = abs1 < abs2 ? val1 : val2;
                tmpRes = abs1 < abs2  ? res1 : res2;
            }
            if (tmpAbs == abs3) {
                result = tmpVal < val3 ? tmpRes : res3;
            } else {
                result = tmpAbs < abs3 ? tmpRes : res3;
            }
            
        }
        return result;
    }

    public boolean isPalindromic(String n) {
        int left =  0, right = n.length() - 1;
        for (; left < right; left++, right--) {
            if (n.charAt(left) != n.charAt(right)) {
                return false;
            }
        }
        return true;
    }

    public String getPalindromic(String n) {
        char[] chars = n.toCharArray();
        String result = new String();
        for (int i = chars.length - 1; i >= 0; i--) {
            result += chars[i];
        }
        return result;
    }
 
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nearestPalindromic("111111111"));
    }
}
