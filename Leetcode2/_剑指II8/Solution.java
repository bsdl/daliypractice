package _剑指II8;

import java.util.*;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int minLen = 100000;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left);
                sum -= nums[left++];
            }
        }
        return minLen == 100000 ? 0 : minLen;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Deque<String> deque = new ArrayDeque<>();
        
        System.out.println(
            solution.minSubArrayLen(
                15, new int[]{5,1,3,5,10,7,4,9,2,8})); 
    }
}
