package com.bsdl.hard._0233;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
//    public int countDigitOne(int n) {
//        int cnt = 0;
//        for (int i = 1; i <= n; i++) {
//            int num = i;
//            while (num != 0) {
//                if (num % 10 == 1) {
//                    cnt++;
//                }
//                num /= 10;
//            }
//        }
//        return cnt;
//    }

//    public int countDigitOne(int n) {
//        int digit = 0;
//        int tmp = n;
//        while(tmp != 0) {
//            tmp /= 10;
//            digit++;
//        }
//        while(digit != 0) {
//
//        }
//    }

//    public int countCharacters(String[] words, String chars) {
//        Map<Character, Integer> map = new HashMap<>();
//        for (char ch : chars.toCharArray()) {
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//        int len = 0;
//        for (String word : words) {
//            boolean isMastered = true;
//            Map<Character, Integer> tmp = new HashMap<>(map);
//            for (char letter : word.toCharArray()) {
//                if (!tmp.containsKey(letter)) {
//                    isMastered = false;
//                    break;
//                }
//                tmp.put(letter, tmp.get(letter) - 1);
//                if (tmp.get(letter) == 0) {
//                    tmp.remove(letter);
//                }
//            }
//            len += isMastered ? word.length() : 0;
//        }
//        return len;
//    }
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }
        String str = String.valueOf(n);
        int size = str.length();
        int firstNum = str.charAt(0) - '0';
        int withoutHigh = n % (int)Math.pow(10, size - 1);
        int firstCnt = firstNum == 1 ? (withoutHigh + 1) : (int) Math.pow(10, size - 1);
        int secondCnt = firstNum * (size - 1) * (int) Math.pow(10, size - 2);
        return firstCnt + secondCnt + countDigitOne(withoutHigh);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        var a = solution.countDigitOne(13);
        System.out.println(a);
//        String[] words = {"cat", "bt", "hat", "tree"};
//        solution.countCharacters(words, "atach");
    }
}
