package hard._0140;

import java.util.*;

public class Solution {
    //    List<String> sentences = new ArrayList<>();
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        if(s.length() == 1 && wordDict.contains(s)) {
//            sentences.add(s);
//            return sentences;
//        }
//        search(s, wordDict, 0, "");
//        return sentences;
//    }
//
//    private void search(String s, List<String> wordDict, int start, String sentence) {
//        if(start == s.length()) {
//            sentence = sentence.trim();
//            sentences.add(sentence);
//        }
//        for (int i = start + 1; i <= s.length(); i++) {
//            if(wordDict.contains(s.substring(start, i))) {
//                String tmp = sentence;
//                tmp += s.substring(start, i) + " ";
//                search(s, wordDict, i, tmp);
//            }
//        }
//    }
//    Map<Integer, List<String>> map = new HashMap<>();
//
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        return search(s, wordDict, 0);
//    }
//
//    private List<String> search(String s, List<String> wordDict, int start) {
//        if (map.containsKey(start)) {
//            return map.get(start);
//        }
//        List<String> res = new ArrayList<>();
//        if (start == s.length()) {
//            res.add("");
//        }
//        for (int i = start + 1; i <= s.length(); i++) {
//            if (wordDict.contains(s.substring(start, i))) {
//                List<String> list = search(s, wordDict, i);
//                for (String str : list
//                ) {
//                    res.add(s.substring(start, i) + (str.equals("") ? "" : " ") + str);
//                }
//            }
//        }
//        return res;
//    }

    private boolean canBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        if(canBreak(s, wordDict)) {
            List<String>[] dp = new ArrayList[s.length() + 1];
            Arrays.fill(dp, new ArrayList<>());
            dp[0].add("");
            for(int i = 1; i <= s.length(); i++) {
                List<String> list = new ArrayList<>();
                for(int j = 0; j < i; j++) {
                    if(dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                        for(String str: dp[j]) {
                            list.add(str + (str.equals("")? "": " ") + s.substring(j, i));
                        }
                    }
                }
                dp[i] = list;
            }
            return dp[s.length()];
        }else {
            return new ArrayList<>();
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> arg = new ArrayList<>();
        arg.add("cat");
        arg.add("cats");
        arg.add("and");
        arg.add("sand");
        arg.add("dog");
        solution.wordBreak("catsanddog", arg);
    }
}
