package medium._0131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<String>> palindromes = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTracking(new ArrayList<>(), s, 0, s.length() - 1);
        return palindromes;
    }

    private void backTracking(List<String> palin, String s, int start, int end) {
        if(start > end) {
            palindromes.add(palin);
            return;
        }
        for(int i = 1; i <= end - start + 1; i++) {
            List<String> tmp = new ArrayList<>(palin);
            String str = s.substring(start, start + i);
            if(isPalindrome(str)) {
                tmp.add(str);
                backTracking(tmp, s, start + i, end);
            }
        }
    }

    private boolean isPalindrome(String str) {
        for(int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partition("aab"));
    }
}
