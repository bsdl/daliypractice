package _1441;


import java.util.*;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<String> res = new ArrayList<>();
        int index = 0;
        for (int num = 1; (num <= n) && (index < target.length); num++) {
            if (num < target[index]) {
                res.add("Push");
                res.add("Pop");
            } else {
                res.add("Push");
                stack.push(num);
                index++;
            }
        }
        return res;
    }
}