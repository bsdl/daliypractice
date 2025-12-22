package com.bsdl.medium._0227;

import java.util.Stack;


class Basic_Calculator_II {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> opers = new Stack<>();
        for (int i = 0; i < s.length();) {
            // if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
            //     StringBuilder str = new StringBuilder();
            //     while (i < s.length() && s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
            //         str.append(s.charAt(i++));
            //     }
            //     nums.push(Integer.valueOf(str.toString()));
            // }
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int j = i;
                while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                    j++;
                }
                String str = s.substring(i, j);
                nums.push(Integer.valueOf(str));
                i = j;
            } else if (s.charAt(i) != ' ') {
                char ch = s.charAt(i);
                if (opers.isEmpty())
                    opers.push(ch);
                else {
                    char top = opers.peek();
                    if ((ch == '*' || ch == '/') && (top == '+' || top == '-'))
                        opers.push(ch);
                    else if (ch == '*' || ch == '/') {
                        while (!opers.isEmpty() && (opers.peek() == '*' || opers.peek() == '/')) {
                            nums.push(calTwoNums(nums.pop(), nums.pop(), opers.pop()));
                        }
                        opers.push(ch);
                    }else {
                        while (!opers.empty()) {
                            nums.push(calTwoNums(nums.pop(), nums.pop(), opers.pop()));
                        }
                        opers.push(ch);
                    }
                }
                i++;
            } else
                i++;
        }
        while (!opers.isEmpty()) {
            nums.push(calTwoNums(nums.pop(), nums.pop(), opers.pop()));
        }
        String str = "";
        while (!nums.isEmpty()) {
            str = nums.pop() + str;
        }
        return Integer.valueOf(str);
    }

    public int calTwoNums(int num1, int num2, char op) {
        int result = 0;
        switch(op) {
            case '+' :
                result = num1 + num2;
                break;
            case '-' :
                result = num2 - num1;
                break;
            case '*' :
                result = num2 * num1;
                break;
            case '/' :
                try {
                    result = num2 / num1;
                    break;
                } catch (ArithmeticException e) {
                    System.out.println(e);
                    break;
                } 
            default:
        }
        return result;
    }

    public static void main(String args[]) {
        Basic_Calculator_II b = new Basic_Calculator_II();
        b.calculate("2 + 0");
    }
}