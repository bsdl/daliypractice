package medium._0695;


public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + dfs(grid, i + 1, j) +
                dfs(grid, i - 1, j) +
                dfs(grid, i, j + 1) +
                dfs(grid, i, j - 1);
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[5][5];
        grid[0] = new int[]{0, 1, 1, 1, 1};
        grid[1] = new int[]{0, 1, 0, 0, 0};
        grid[2] = new int[]{0, 1, 1, 1, 1};
        grid[3] = new int[]{0, 0, 1, 0, 1};
        grid[4] = new int[]{0, 0, 0, 0, 1};
        int area = solution.maxAreaOfIsland(grid);
        System.out.println(area);

    }

}
