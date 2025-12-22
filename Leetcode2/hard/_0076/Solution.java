package com.bsdl.hard._0076;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (s.length() < t.length()) {
            return "";
        }
        if (s.equals(t)) {
            return s;
        }
        // memo记录所有t中出现的字符，key不会remove
        Map<Character, Integer> memo = new HashMap<>();
        // window记录当前窗口中存在的t中的字符数量，窗口划走字符数变成0则remove对应的key
        Map<Character, Integer> window = new HashMap<>();
        String minWindowStr = "";
        for (int i = 0; i < tLen; i++) {
            memo.put(t.charAt(i), memo.getOrDefault(t.charAt(i), 0) + 1);
            window.put(t.charAt(i), window.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 注意窗口的两侧一定是t中的字符
        int l = 0;
        while (l <= sLen - tLen && !memo.containsKey(s.charAt(l))) {
            l++;
        }
        for (int r = 0; l <= sLen - tLen; ) {
            // 窗口的左侧一定是t中的字符，开始挪动窗口的右侧
            while (r < sLen && !window.isEmpty()) {
                char letter = s.charAt(r);
                if (memo.containsKey(letter)) {
                    if (window.containsKey(letter)) {
                        window.put(letter, window.get(letter) - 1);
                        if (window.get(letter) == 0) {
                            window.remove(letter);
                        }
                    }
                    memo.put(letter, memo.get(letter) - 1);
                }
                r++;
            }
            // 窗口满足条件则记录新的字符串
            if (window.isEmpty() && (minWindowStr.equals("") || minWindowStr.length() > r - l)) {
                minWindowStr = s.substring(l, r);
            }
            // 窗口左侧向左移动，当memo中存在的左侧对应的键值小于0时说明当前窗口还有多余的和左侧相同的字符，window里就不需要添加
            if (memo.get(s.charAt(l)) >= 0) {
                window.put(s.charAt(l), 1);
            }
            memo.put(s.charAt(l), memo.get(s.charAt(l)) + 1);
            l++;
            // 左侧一直挪到下一个存在于t中的字符
            while (l <= sLen - tLen && !memo.containsKey(s.charAt(l))) {
                l++;
            }
        }
        return minWindowStr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(str);
    }
}
