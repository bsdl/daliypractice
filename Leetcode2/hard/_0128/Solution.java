package com.bsdl.hard._0128;

import java.util.*;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums
        ) {
            set.add(num);
        }
        int longestSeq = 1;
        for (int num : nums
        ) {
            if (set.contains(num - 1)) {
                continue;
            }
            int startNum = num;
            int curLongSeq = 1;
            while (set.contains(startNum + 1)) {
                startNum++;
                curLongSeq++;
            }
            longestSeq = Math.max(longestSeq, curLongSeq);
        }
        return longestSeq;
    }
}
