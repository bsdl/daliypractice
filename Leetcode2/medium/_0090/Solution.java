package medium._0090;

import java.util.*;

public class Solution {
    List<List<Integer>> subSet = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 排序为了去重
        Arrays.sort(nums);
        generatesAll(nums, new LinkedList<>(), 0);
        return subSet;
    }

    private void generatesAll(int[] nums, LinkedList<Integer> sub, int start) {
        subSet.add(new LinkedList<>(sub));
        for(int i = start; i < nums.length; i++) {
            // 去重
            if(i != start && nums[i] == nums[i - 1]) {
                continue;
            }
            sub.add(nums[i]);
            generatesAll(nums, sub, i + 1);
            sub.removeLast();
        }
    }
}
