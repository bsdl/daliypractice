package medium._0306;

public class Solution {
    long[] sums;

    public boolean isAdditiveNumber(String num) {
        char[] nums = num.toCharArray();
        sums = new long[10000];
        return helper(nums, 0, 0);
    }

    private boolean helper(char[] nums, int start, int idx) {
        if (start == nums.length) {
            return idx > 2;
        }
        long sum = 0;
        int numLen = 0;
        for (int i = start; i < nums.length; i++) {
            sum = sum * 10 + (nums[i] - '0');
            numLen++;
            if (numLen != String.valueOf(sum).length()) {
                return false;
            }
            sums[idx] = sum;
            if (idx < 2) {
                if (helper(nums, i + 1, idx + 1)) {
                    return true;
                }
            } else {
                long total = sums[idx - 1] + sums[idx - 2];
                if (total == sum) {
                    if (helper(nums, i + 1, idx + 1)) {
                        return true;
                    }
                } else if (total < sum) {
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isAdditiveNumber("0");
    }
}


