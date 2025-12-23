package hard._0126;

import java.util.*;

public class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> isVisited = new HashSet<>();
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return res;
        }
        Queue<List<String>> que = new LinkedList<>();
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        que.offer(list);
        boolean isEnd = false;
        while (!que.isEmpty() && !isEnd) {
            int size = que.size();
            Set<String> subVisited = new HashSet<>();
            while (size > 0) {
                List<String> curList = que.poll();
                assert curList != null;
                String curStr = curList.get(curList.size() - 1);
                char[] chs = curStr.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char tmp = chs[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chs[i] = ch;
                        if (tmp == ch) {
                            continue;
                        }
                        String str = new String(chs);
                        if (words.contains(str) && !isVisited.contains(str)) {
                            List<String> newList = new ArrayList<>(curList);
                            newList.add(str);
                            if (str.equals(endWord)) {
                                res.add(newList);
                                isEnd = true;
                            }
                            que.offer(newList);
                            subVisited.add(str);
                        }
                    }
                    chs[i] = tmp;
                }
                size--;
            }
            isVisited.addAll(subVisited);
        }
        return res;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> res =
                solution.findLadders("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(res);
    }
}
