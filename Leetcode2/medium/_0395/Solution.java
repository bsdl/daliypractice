package medium._0395;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int longestSubstring(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        boolean isAllLessThanK = true, isAllGreaterThank = true;
        for(char key: map.keySet()) {
            if(map.get(key) >= k) {
                isAllLessThanK = false;
            }else {
                isAllGreaterThank = false;
            }
            if(!(isAllGreaterThank || isAllLessThanK)) {
                break;
            }
        }
        if(isAllLessThanK) {
            return 0;
        }
        if(isAllGreaterThank) {
            return s.length();
        }
        int subStringLen =0 ;
        List<String> validSubString = new ArrayList<>();
        for(int i = 0; i < s.length(); ) {
            while(i < s.length() && map.get(s.charAt(i)) < k) {
                i++;
            }
            int j = i + 1;
            for(; j < s.length(); j++) {
                if(map.get(s.charAt(j)) < k) {
                    validSubString.add(s.substring(i, j));
                    break;
                }
            }
            if(j == s.length()) {
                validSubString.add(s.substring(i));
            }
            i = j + 1;
        }
        for(String subStr: validSubString) {
            subStringLen = Math.max(subStringLen, longestSubstring(subStr, k));
        }
        return subStringLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestSubstring("bbaaacbd", 3);
    }
}
