package hard._0010;

public class Solution {

//    public boolean isMatch(String s, String p) {
//        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
//        dp[0][0] = true;
//        for (int i = 0; i < p.length(); i++) {
//            if (p.charAt(i) == '*' && dp[0][i - 1]) {
//                dp[0][i + 1] = true;
//            }
//        }
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 0; j < p.length(); j++) {
//                if (p.charAt(j) == '*') {
//                    if ((s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.') &&
//                            (dp[i][j + 1] || dp[i + 1][j] || dp[i + 1][j - 1])) {
//                        dp[i + 1][j + 1] = true;
//                    }
//                    if (s.charAt(i) != p.charAt(j - 1) && dp[i + 1][j - 1]) {
//                        dp[i + 1][j + 1] = true;
//                    }
//                } else if (dp[i][j] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
//                    dp[i + 1][j + 1] = true;
//                }
//            }
//        }
//        return dp[s.length()][p.length()];
//    }

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean isCurMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (isCurMatch && isMatch(s.substring(1), p));
        } else {
            if (isCurMatch) {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isMatch("ab", ".*..");
    }
}
