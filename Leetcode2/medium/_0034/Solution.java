package com.bsdl.medium._0034;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] pos = new int[2];
        int left = 0, right = nums.length - 1;
        boolean isFound = false;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                isFound = true;
                int idx = mid;
                while (idx > 0 && nums[idx - 1] == nums[idx]) {
                    idx--;
                }
                pos[0] = idx;
                idx = mid;
                while (idx < nums.length - 1 && nums[idx] == nums[idx + 1]) {
                    idx++;
                }
                pos[1] = idx;
                break;
            }
        }
        if (!isFound) {
            return new int[]{-1, -1};
        }
        return pos;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        var res = solution.searchRange(new int[]{5,7,7,8,8,10}, 6);
        System.out.print(res);
    }
}
