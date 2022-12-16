package _剑指II34;

import java.util.*;

public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int len = Math.max(word1.length(), word2.length());
            for (int j = 0; j < len; j++) {
                int num1 = j < word1.length() ? map.get(word1.charAt(j)): -1;
                int num2 = j < word2.length() ? map.get(word2.charAt(j)): -1;
                if (num1 > num2) {
                    return false;
                }
                if (num1 < num2) {
                    break;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }
}
