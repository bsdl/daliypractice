package esay._0944;

import java.util.*;

public class Solution {
    public int minDeletionSize(String[] strs) {
        int ret = 0;
        if (strs.length == 0 || strs.length == 1) {
            return ret;
        }
        int len = strs[0].length();
        for (int i = 0; i < len; i++) {
            boolean isIncrease = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) <= strs[j - 1].charAt(i)) {
                    isIncrease = false;
                    break;
                }
            }
            if (!isIncrease) {
                ret += 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String[] strs = { "rrjk","furt","guzm" };
        Solution solution = new Solution();
        int ret = solution.minDeletionSize(strs);
        System.out.println("\n=====>结果:" + ret);
    }
}
