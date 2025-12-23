package esay._0994;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> que = new LinkedList<>();
        Map<int[], Integer> map = new HashMap<>();
        int minutes =0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 2) {
                    int[] rear = new int[]{i,j};
                    que.add(rear);
                    map.put(rear, 0);
                }
            }
        }

        int[] moves1 = {-1, 0, 1, 0};
        int[] moves2 = {0, -1, 0, 1};
        while(!que.isEmpty()) {
            int[] front = que.remove();
            for(int i = 0; i < 4; i++) {
                int x = front[0] + moves1[i];
                int y = front[1] + moves2[i];
                if(x >= 0 && y >= 0 && x < row && y < col && grid[x][y] == 1) {
                    grid[x][y] = 2;
                    int[] rear = new int[]{x,y};
                    que.add(rear);
                    map.put(rear, map.get(front) + 1);
                    minutes = map.get(rear);
                }
            }
        }
        for (int[] ints: grid
             ) {
            for(int or: ints) {
                if(or==1) {
                    return -1;
                }
            }
        }
        return minutes;
    }

    public static void main(String[] args) {
        int[][] grid = new int[3][];
        grid[0] = new int[]{2,1,1};
        grid[1] = new int[]{1,1,0};
        grid[2] = new int[]{0,1,1};
        Solution solution = new Solution();
        solution.orangesRotting(grid);
    }
}
