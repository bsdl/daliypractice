package com.bsdl.medium._0040;

import java.util.*;

public class Solution {
    // Solution 1
    Set<Integer> set = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(combinations, candidates, target, new ArrayList<>(), 0);
        return combinations;
    }

    private void backTracking(List<List<Integer>> combinations, int[] candidates, int target, List<Integer> combine, int i) {
        if(target == 0 && !combinations.contains(combine)) {
            combinations.add(combine);
            return;
        }
        if(target < candidates[i]) {
            return;
        }
        for(int start = i; start < candidates.length && target >= candidates[start]; ++start) {
            List<Integer> tmp = new ArrayList<>(combine);
            tmp.add(candidates[start]);
            backTracking(combinations, candidates, target - candidates[start], tmp, start + 1);
        }
    }


}
