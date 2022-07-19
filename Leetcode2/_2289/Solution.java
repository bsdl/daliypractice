package Leetcode2._2289;

import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int totalSteps(int[] nums) {
        Deque<int[]> deque = new LinkedList<>();
        int maxT = 0;
        int cnt = 0;
        for (int num: nums) {
            maxT = 0;
            while (!deque.isEmpty() && deque.peek()[0] <= num) {
                maxT = Math.max(maxT, deque.pop()[1]);
            }
            maxT = deque.isEmpty() ? 0 : maxT + 1;
            cnt = Math.max(cnt, maxT);
            deque.push(new int[]{num, maxT});
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] nums=  {4,5,7,7,13};
        int ret = solution.totalSteps(nums);
        System.out.println(ret);
    }
}