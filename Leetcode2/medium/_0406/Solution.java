package medium._0406;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0]? p1[1] - p2[1]: p2[0] - p1[0]);
        LinkedList<int[]> lists = new LinkedList<>();
        for(int[] person: people) {
            lists.add(person[1], person);
        }
        return (int[][])lists.toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] p = new int[6][];
        p[0] = new int[]{7,1};
        p[1] = new int[]{7,0};
        p[2] = new int[]{4,4};
        p[3] = new int[]{5,0};
        p[4] = new int[]{5,2};
        p[5] = new int[]{6,1};
        solution.reconstructQueue(p);
    }
}
