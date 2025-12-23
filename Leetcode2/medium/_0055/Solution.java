package medium._0055;

public class Solution {

    // backtraking 超时
//    public boolean canJump(int[] nums) {
//        return backTracking(0, nums);
//    }
//    private boolean backTracking(int position, int[] nums) {
//        if(position == nums.length - 1) {
//            return true;
//        }
//        int farthestPosition = Math.min(nums[position] + position, nums.length - 1);
//        for(int nextPosition = position + 1; nextPosition <= farthestPosition; nextPosition++) {
//            if(backTracking(nextPosition, nums)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean canJump(int[] nums) {
        if(nums.length == 1) {
            return true;
        }
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && j + nums[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
}
