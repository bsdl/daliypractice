package _剑指II4;

public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((mask & nums[j]) != 0) {
                    cnt++;
                }
            }
            if (cnt % 3 != 0) {
                res |= mask;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{2,2,3,2})); 
    }
}
