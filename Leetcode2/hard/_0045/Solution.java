package com.bsdl.hard._0045;

public class Solution {
    public int jump(int[] nums) {
        int edge = 0;
        int farthestPos = 0;
        int steps = 0;
        for(int i = 0; i < nums.length - 1; i++){
            farthestPos = Math.max(farthestPos, nums[i] + i);
            if(edge == i) {
                edge = farthestPos;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int steps = solution.jump(new int[] {2,3,1,1,4});
        System.out.println(steps);
    }
}
