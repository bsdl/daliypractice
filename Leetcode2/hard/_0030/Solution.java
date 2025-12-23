package hard._0030;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indexes = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words
        ) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        if (map.isEmpty()) {
            return indexes;
        }
        int wordLen = words[0].length();
        int windowLen = wordLen * words.length;
        if (windowLen > s.length()) {
            return indexes;
        }
        // 外层循环！！！
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, cnt = 0;
            Map<String, Integer> tmp = new HashMap<>();
            while (right + wordLen <= s.length()) {
                String str = s.substring(right, right + wordLen);
                right += wordLen;
                if (!map.containsKey(str)) {
                    cnt = 0;
                    left = right;
                    tmp.clear();
                } else {
                    tmp.put(str, tmp.getOrDefault(str, 0) + 1);
                    cnt++;
                    while (tmp.getOrDefault(str, 0) > map.getOrDefault(str, 0)) {
                        String fromLeft = s.substring(left, left + wordLen);
                        left += wordLen;
                        tmp.put(fromLeft, tmp.get(fromLeft) - 1);
                        cnt--;
                    }
                }
                if (cnt == words.length) {
                    indexes.add(left);
                }
            }
        }
        return indexes;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> res = solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"});
        int pp = 3;
    }
}
