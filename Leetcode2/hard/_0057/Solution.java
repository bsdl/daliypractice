package com.bsdl.hard._0057;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        List<int[]> ans = new ArrayList<>();
        boolean isIn = false;
        for (int[] interval : intervals
        ) {
            if (!isIn && interval[0] >= newInterval[0]) {
                list.add(newInterval);
                isIn = true;
            }
            list.add(interval);
        }
        if (!isIn) {
            list.add(newInterval);
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                ans.add(list.get(i));
            } else if (list.get(i)[1] <= list.get(i + 1)[1] && list.get(i)[1] >= list.get(i + 1)[0]) {
                list.get(i + 1)[0] = list.get(i)[0];
            } else if (list.get(i)[1] > list.get(i + 1)[1]) {
                list.get(i + 1)[0] = list.get(i)[0];
                list.get(i + 1)[1] = list.get(i)[1];
            } else {
                ans.add(list.get(i));
            }
        }
        return ans.toArray(new int[1][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ans = solution.insert(new int[][]{{2, 5}, {6, 7}, {8, 9}}, new int[]{0, 1});
        System.out.println(Arrays.deepToString(ans));
    }
}
