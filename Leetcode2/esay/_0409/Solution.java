package esay._0409;


public class Solution {

    public int longestPalindrome(String s) {
        int[] map = new int[26 + 26];
        for (char ch : s.toCharArray()) {
            if (ch >= 'a') {
                map[ch - 'a']++;
            } else {
                map[ch - 'A' + 26]++;
            }
        }
        int len = 0;
        int oddNum = 0;
        for (int num : map) {
            if (num % 2 == 0) {
                len += num;
            } else {
                len += num - 1;
                oddNum++;
            }
        }
        return len + (oddNum == 0 ? 0 : 1);
    }


    public static void main(String[] args) {

    }

}
