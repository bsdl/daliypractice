package medium._0096;

public class Solution {
    public int numTrees(int n) {
         int[] dp = new int[n + 1];
         dp[0] = 1;
         dp[1] = 1;
         for(int i = 2; i <= n; i++) {
             for(int j = 0; j < i; j++) {
                 // f(0)*f(n - 1) + f(1)*f(n - 2) + ... + f(n - 1)*f(0)
                 dp[i] += dp[j] * dp[i - j - 1];
             }
         }
         return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(3));
    }
}
