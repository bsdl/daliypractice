package medium._0015;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            int target = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(nums[j])) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],map.get(nums[j]),nums[j])));
                } else {
                    map.put(-target - nums[j], nums[j]);
                }
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        var res = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.print(res);
    }
}
