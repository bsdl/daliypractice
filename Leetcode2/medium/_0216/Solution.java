package medium._0216;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    List<List<Integer>> combinations = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> ll = new LinkedList<>();
        backTracking(k, n, 1, new LinkedList<Integer>());
        return combinations;
    }

    private void backTracking(int k, int n, int start, LinkedList<Integer> combine) {
        if(combine.size() == k) {
            if(n == 0) {
                combinations.add(new LinkedList<>(combine));
            }
            return;
        }
        for(int i = start; i <= 9; i++) {
            combine.add(i);
            n -= i;
            backTracking(k, n, i + 1, combine);
            combine.removeLast();
            n += i;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combinationSum3(3, 7);
    }
}
