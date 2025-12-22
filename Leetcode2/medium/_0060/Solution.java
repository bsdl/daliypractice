package com.bsdl.medium._0060;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    int count = 0;
    List<List<Integer>> permutation = new ArrayList<>();
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        boolean[] isVisited = new boolean[n];
        Arrays.fill(isVisited, false);
        for(int i = 1; i <= n; i++) {
            nums.add(i);
        }
        backTracking(new ArrayList<>(), nums, k, isVisited);
        List<Integer> list = new ArrayList<>(permutation.get(0));
        StringBuilder sb = new StringBuilder();
        for (int num: list) {
            sb.append(String.valueOf(num));
        }
        return sb.toString();
    }

    private void backTracking(ArrayList<Integer> permute, List<Integer> nums, int k, boolean[] isVisited) {
        if(permute.size() == nums.size()) {
            count++;
            if(count == k) {
                permutation.add(new ArrayList<>(permute));
            }
            return;
        }
        for(int i = 0; i < nums.size(); i++) {
            if(isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            permute.add(nums.get(i));
            backTracking(permute, nums, k, isVisited);
            isVisited[i] = false;
            permute.remove(permute.size() - 1);
        }
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.getPermutation(3, 3);
//    }
}
