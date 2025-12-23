package medium._0820;

import java.util.Arrays;

public class Solution {
    public int minimumLengthEncoding(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String newWord = new StringBuilder(words[i]).reverse().toString();
            words[i] = newWord;
        }
        Arrays.sort(words);
        int len = 0;
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].length() <= words[i + 1].length() &&
                    words[i].equals(words[i + 1].substring(0, words[i].length()))) {
                continue;
            }
            len += words[i].length() + 1;
        }
        return len + words[words.length - 1].length() + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minimumLengthEncoding(new String[]{"atime", "aatime", "btime"});
    }
}
