package medium._0318;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); i++) {
                mask |= (1 << (word.charAt(i) - 'a'));
            }
            map.put(mask, Math.max(map.getOrDefault(mask, 0), word.length()));
        }
        int result = 0;
        for (int k1 : map.keySet()) {
            for (int k2 : map.keySet()) {
                if ((k1 & k2) == 0) {
                    result = Math.max(map.get(k1) * map.get(k2), result);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"});
    }
}
