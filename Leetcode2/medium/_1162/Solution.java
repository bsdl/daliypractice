package medium._1162;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int maxDistance(int[][] grid) {
        int[] moves1 = {-1, 0, 1, 0};
        int[] moves2 = {0, -1, 0, 1};
        Queue<int[]> que = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    que.offer(new int[]{i, j});
                }
            }
        }
        int[] point = null;
        boolean hasOcean = false;
        while (!que.isEmpty()) {
            point = que.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + moves1[i];
                int newY = y + moves2[i];
                if (newX < 0 || newY < 0 || newX >= row || newY >= col || grid[newX][newY] != 0) {
                    continue;
                }
                hasOcean = true;
                grid[newX][newY] = grid[x][y] + 1;
                que.offer(new int[]{newX, newY});
            }
        }
        if (point == null || !hasOcean) {
            return -1;
        }
        return grid[point[0]][point[1]] - 1;
    }


    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        Solution solution = new Solution();
        int res = solution.maxDistance(grid);
        System.out.println(res);
    }
}
