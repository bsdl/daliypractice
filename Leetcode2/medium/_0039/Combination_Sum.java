package medium._0039;

import java.util.*;

class Combination_Sum {
    List<List<Integer>> combinations = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> combine = new ArrayList<>();
        Arrays.sort(candidates);
        backTacking(candidates, target, combine, 0);
        return combinations;
    }

    private void backTacking(int[] candidates, int target, List<Integer> combine, int start) {
        if(target == 0) {
            combinations.add(combine);
            return;
        }
        if(target < candidates[start]) {
            return;
        }
        for(int i = start; i < candidates.length && target >= candidates[i]; i++) {
            List<Integer> tmp = new ArrayList<>(combine);
            tmp.add(candidates[i]);
            backTacking(candidates, target - candidates[i], tmp, i);
        }
    }
}