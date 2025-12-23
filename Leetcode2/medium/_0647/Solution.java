package medium._0647;

public class Solution {
    public int countSubstrings(String s) {
        int cnt = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i - 1][j + 1])) {
                    cnt++;
                    dp[i][j] = true;
                }
            }
        }
        return cnt;
    }
}
