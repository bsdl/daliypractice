package hard._0044;

public class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        int i = 0;
        int j = 0;
        int start = -1;
        int matchPos = 0;
        while (i < sLen) {
            if (j < pLen && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                j++;
                i++;
            } else if (j < pLen && p.charAt(j) == '*') {
                start = j;
                j++;
                matchPos = i;
            } else if (start != -1) {
                j = start + 1;
                matchPos++;
                i = matchPos;
            } else {
                return false;
            }
        }
        for (; j < pLen; j++) {
            if (p.charAt(j) != '*') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isMatch("acdcb", "a*c?b");
    }
}
