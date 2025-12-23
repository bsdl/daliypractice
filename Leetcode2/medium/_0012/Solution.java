package medium._0012;


public class Solution {
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        while (num != 0) {
            if (num >= 1000) {
                int tmp = num / 1000;
                roman.append("M".repeat(tmp));
                num -= tmp * 1000;
            } else if (num >= 500) {
                int tmp = num / 100;
                if (tmp == 9) {
                    roman.append("CM");
                    num -= 900;
                } else {
                    roman.append("D");
                    num -= 500;
                }
            } else if (num >= 100) {
                int tmp = num / 100;
                if (tmp == 4) {
                    roman.append("CD");
                    num -= 400;
                } else {
                    roman.append("C".repeat(tmp));
                    num -= 100 * tmp;
                }
            } else if (num >= 50) {
                int tmp = num / 10;
                if (tmp == 9) {
                    roman.append("XC");
                    num -= 90;
                } else {
                    roman.append("L");
                    num -= 50;
                }
            } else if (num >= 10) {
                int tmp = num / 10;
                if (tmp == 4) {
                    roman.append("XL");
                    num -= 40;
                } else {
                    roman.append("X".repeat(tmp));
                    num -= 10 * tmp;
                }
            } else if (num >= 5) {
                if (num == 9) {
                    roman.append("IX");
                    break;
                } else {
                    roman.append("V");
                    num -= 5;
                }
            } else if (num >= 1) {
                if (num == 4) {
                    roman.append("IV");
                } else {
                    roman.append("I".repeat(num));
                }
                break;
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = solution.intToRoman(2415);
        System.out.println(str);
    }
}
