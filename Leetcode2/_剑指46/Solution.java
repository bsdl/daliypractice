package _剑指46;

class Solution {
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        String numStr = String.valueOf(num);
        int[] dp = new int[numStr.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= numStr.length(); i++) {
            if (numStr.charAt(i - 2) - '0' == 0 || Integer.parseInt(numStr.substring(i - 2, i)) > 25) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2]; 
            }
        }
        return dp[numStr.length()];           
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.translateNum(506);
        System.out.println(res);
    }
}