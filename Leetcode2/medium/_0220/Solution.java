package com.bsdl.medium._0220;

import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer greater = set.ceiling(nums[i]);

            if (greater != null && (long) greater - (long) nums[i] <= t) {
                return true;
            }
            Integer smaller = set.floor(nums[i]);

            if (smaller != null && (long) nums[i] - (long) smaller <= t) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
