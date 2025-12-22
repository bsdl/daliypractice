package com.bsdl.hard._0239;


import java.util.*;

class Sliding_Window_Maximum {
    // O(n * k)
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums.length == 0) {
//            return new int[]{};
//        }
//        int[] maxes = new int[nums.length - k + 1];
//        for (int i = 0; i <= nums.length - k; i++) {
//            int max = Integer.MIN_VALUE;
//            for (int j = i; j < i + k; j++) {
//                max = Math.max(max, nums[j]);
//            }
//            maxes[i] = max;
//        }
//        return maxes;
//    }

//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums.length == 0) {
//            return new int[]{};
//        }
//        int[] maxes = new int[nums.length - k + 1];
//        Deque<Integer> deque = new LinkedList<>();
//        int i = 0;
//        while (i < k) {
//            if(!deque.isEmpty()) {
//                System.out.println(nums[deque.peekFirst()]);
//            }
//            while (!deque.isEmpty() && nums[deque.peekFirst()] < nums[i]) {
//                deque.pollFirst();
//            }
////            deque.offerFirst(nums[i++]);
//            deque.offerFirst(i++);
//        }
//        int index = 0;
//        maxes[index] = nums[deque.peekLast()];
//        for (; i < nums.length; i++) {
//
//            while (!deque.isEmpty() && nums[deque.peekFirst()] <= nums[i]) {
//                deque.pollFirst();
//            }
//            deque.offerFirst(i);
//            if(!deque.isEmpty() && deque.peekLast() == i - k) {
//                deque.pollLast();
//            }
//            maxes[index++] = nums[deque.peekLast()];
//        }
//        return maxes;
//    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        int[] maxes = new int[nums.length - k + 1];
        int windowRight = k - 1;
        int lastMaxIndex = -1;
        int windowLeft = 0;
        for(; windowRight < nums.length; windowRight++) {
            // 判断窗口是否已经删除了上一个最大的元素
            // 如果已经删除则重新在窗口内比较找出最大值的索引
            if(lastMaxIndex < windowLeft) {
                int max = Integer.MIN_VALUE;
                for(int i = windowLeft; i <= windowRight; i++) {
                    if(max < nums[i]) {
                        max = nums[i];
                        lastMaxIndex = i;
                    }
                }
            // 如果还在窗口内则只用和新进入的数进行比较
            }else if(nums[lastMaxIndex] < nums[windowRight]) {
                lastMaxIndex = windowRight;
            }
            maxes[windowLeft] = nums[lastMaxIndex];
            windowLeft++;
        }
        return maxes;
    }

    public static void main(String[] args) {
        Sliding_Window_Maximum s = new Sliding_Window_Maximum();
        s.maxSlidingWindow(new int[]{7,2,4}, 2);
    }
}