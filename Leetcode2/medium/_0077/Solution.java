package com.bsdl.medium._0077;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> combinations = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n < k) {
            return combinations;
        }
        backTracking(n, k, new ArrayList<>(), 1);
        return combinations;
    }

    private void backTracking(int n, int k, ArrayList<Integer> combine, int start) {
        if(combine.size() == k) {
            combinations.add(new LinkedList<>(combine));
            return;
        }
        for(int i = start; i <= n; i++) {
            combine.add(i);
            backTracking(n, k, combine, i + 1);
            combine.remove(combine.size() - 1);
        }
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.combine(4,2);
//    }
}
