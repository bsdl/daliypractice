package hard._0301;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> valids = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                left++;
            } else if (ch == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        backTracking(s, 0, left, right);
        if (valids.isEmpty()) {
            valids.add("");
        }
        return valids;
    }

    private void backTracking(String s, int start, int left, int right) {
        if (left == 0 && right == 0) {
            if (isValidExpression(s)) {
                valids.add(s);
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            String tmp = s.substring(0, i) + s.substring(i + 1);
            if (left > 0 && s.charAt(i) == '(') {
                backTracking(tmp, i, left - 1, right);
            }
            if (right > 0 && s.charAt(i) == ')') {
                backTracking(tmp, i, left, right - 1);
            }
        }
    }

    private boolean isValidExpression(String s) {
        int cnt = 0;
        for (char ch : s.toCharArray()
        ) {
            if (ch == '(') {
                cnt++;
            } else if (ch == ')') {
                cnt--;
                if (cnt < 0) {
                    return false;
                }
            }
        }
        return cnt == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.removeInvalidParentheses(")(f");
    }
}
