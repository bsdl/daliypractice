package com.bsdl.medium._0324;

import java.util.*;

class Wiggle_Sort_II {
    // 这种方法是将数组排序后分半，如果数组长度为奇数则前半段长度要比后半段多1
    // 分半后将前后数组倒序再间隔插入原数组
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int mid = len / 2;
        if (len % 2 == 0) {
            mid--;
        }
        List<Integer> firstHalf = new ArrayList<>();
        List<Integer> secondHalf = new ArrayList<>();
        for (int i = mid; i >= 0; --i) {
            firstHalf.add(nums[i]);
        }
        for (int i = len - 1; i > mid; --i) {
            secondHalf.add(nums[i]);
        }
        int fir = 0, sec = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                nums[i] = firstHalf.get(fir++);
            } else {
                nums[i] = secondHalf.get(sec++);
            }
        }
    }

    public static void main(String[] args) {
        Wiggle_Sort_II wiggle_sort_ii = new Wiggle_Sort_II();
        wiggle_sort_ii.wiggleSort(new int[]{1, 5, 1, 1, 6, 4});
    }
}