package _剑指II37;

import java.util.*;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid: asteroids) {
            boolean flag = true;
            while (!stack.isEmpty()) {
                int left = stack.peek();
                if (left > 0 && asteroid < 0) {
                    if (left < (-asteroid)) {
                        stack.pop();
                    } else if(left == (-asteroid)){
                        stack.pop();
                        flag = false;
                        break;
                    } else {
                        flag = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (flag) {
                stack.push(asteroid);
            }        
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {   
            res[i++] = stack.removeLast();          
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.asteroidCollision(new int[]{5,10,-5}));
    }
}
