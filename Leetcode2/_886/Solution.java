package _886;

import java.util.*;

public class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new List[n + 1];
        // 0, 1, 2
        int[] group = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] pair: dislikes) {
            graph[pair[0]].add(pair[1]);
            graph[pair[1]].add(pair[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (group[i] == 0) {
                Queue<Integer> que = new ArrayDeque<>();
                que.offer(i);
                group[i] = 1;
                while (!que.isEmpty()) {
                    int cur = que.poll();
                    for (int next: graph[cur]) {
                        if (group[next] > 0 && group[next] == group[cur]) {
                            return false;
                        }
                        if (group[next] == 0) {
                            group[next] = 3 ^ group[cur];
                            que.offer(next);
                        }
                    }
                }
            }  
        }
        return true;
    }
}
