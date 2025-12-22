package com.bsdl.medium._0416;

import java.util.Arrays;

// 这个问题可以看作是否可以从数组中选取一些正整数使得它们的和等于数组和的一半
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n: nums
             ) {
            sum += n;
        }
        if(sum % 2 != 0) {
            return false;
        }
        sum >>= 1;
        // 排序是为了更快的剪枝，并且要从后往前
        Arrays.sort(nums);
        return canPartition(nums, nums.length - 1, sum);
    }

    public boolean canPartition(int[] nums, int start, int sum) {
        if(start < 0 || sum < nums[start]) {
            return false;
        }
        if(nums[start] == sum) {
            return true;
        }
        return canPartition(nums, start - 1, sum - nums[start]) ||
                canPartition(nums, start - 1, sum);
    }
}
