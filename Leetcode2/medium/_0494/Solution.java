package medium._0494;

public class Solution {
    int num = 0;
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        dfs(nums, S, sum, 0);
        return num;
    }

    private void dfs(int[] nums, int S, int sum, int pos) {
        if(pos == nums.length) {
            if(sum == S) {
                num++;
            }
            return;
        }
        dfs(nums, S, sum + nums[pos], pos + 1);
        dfs(nums, S, sum - nums[pos], pos + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findTargetSumWays(new int[]{1,1,1,1,1}, 3);
    }

}
