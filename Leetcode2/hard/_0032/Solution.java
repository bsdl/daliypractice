package com.bsdl.hard._0032;

import java.util.Stack;

public class Solution {
    //    public int longestValidParentheses(String s) {
//        int longest = 0;
//        for(int i = 0; i < s.length(); i++) {
//            for(int j = i + 2; j <= s.length(); j += 2) {
//                if(isValid(s.substring(i, j))) {
//                    longest = Math.max(longest, j - i);
//                }
//            }
//        }
//        return longest;
//    }
//
//    private boolean isValid(String substring) {
//        Stack<Character> stack = new Stack<>();
//        for (char ch : substring.toCharArray()) {
//            if (ch == '(') {
//                stack.push(ch);
//            } else {
//                if (!stack.isEmpty() && stack.peek() == '(') {
//                    stack.pop();
//                } else {
//                    return false;
//                }
//            }
//        }
//        return stack.isEmpty();
//    }
//
//
//    public int longestValidParentheses(String s) {
//        int longest = 0;
//        int[] dp = new int[s.length()];
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i) == ')') {
//                if (s.charAt(i - 1) == '(') {
//                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
//                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
//                    dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
//                }
//            }
//            longest = Math.max(longest, dp[i]);
//        }
//        return longest;
//    }

    public int longestValidParentheses(String s) {
        int longest = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') {
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(i);
                }else {
                    longest = Math.max(longest, i - stack.peek());
                }
            }
        }
        return longest;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {0,0,0};
        int[] B = {1,2,3};

        solution.longestValidParentheses("()(())");
    }
}
