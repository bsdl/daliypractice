package com.bsdl.medium._0078;

import java.util.*;

class Subset {
    // 位运算
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> res = new LinkedList<List<Integer>>();
    //     int len = 1 << nums.length;
    //     for (int i = 0; i < len; i++) {
    //         List<Integer> subset = new LinkedList<Integer>();
    //         for (int j = 0; j < nums.length; j++) {
    //             if ((i & (1 << j)) != 0) 
    //                 subset.add(nums[j]);
    //         }
    //         res.add(subset);
    //     } 
    //     return res;
    // }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        generatesAll(nums, res, new LinkedList<Integer>(), 0);
        return res;
    }

    public void generatesAll(int[] nums, List<List<Integer>> res, LinkedList<Integer> subset, int start) {
        res.add(new LinkedList<Integer>(subset));
        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            generatesAll(nums, res, subset, i + 1);
            subset.removeLast();
        }
    }
}