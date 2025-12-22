package com.bsdl.medium._0043;

public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length();
        int[] resInt = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                resInt[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                resInt[i + j] += resInt[i + j + 1] / 10;
                resInt[i + j + 1] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = resInt[0] == 0 ? 1 : 0; i < resInt.length; i++) {
            sb.append(resInt[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        var res = solution.multiply("123","456");
        System.out.print(res);
    }
}
