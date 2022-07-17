package Leetcode2._2202;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maximumTop(int[] nums, int k) {
        int top = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = k; i >= 0; i--) {
            if (deque.isEmpty()) {
                
            }
        }


        if (top == -1) {
            return -1;
        }
        return nums[top];
    }
}