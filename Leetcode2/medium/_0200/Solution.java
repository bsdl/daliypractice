package com.bsdl.medium._0200;


import java.util.HashSet;
import java.util.Set;

public class Solution {
    Set<String> set = new HashSet<>();
    private int numOfIsland = 0;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                String str = i + "/" + j;
                if (grid[i][j] == '1' && !set.contains(str)) {
                    this.numOfIsland++;
                    dfs(grid, i, j);
                }
            }
        }
        return this.numOfIsland;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        String pos = i + "/" + j;
        if (set.contains(pos)) {
            return;
        }
        if (grid[i][j] == '1') {
            set.add(pos);
            dfs(grid, i + 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i - 1, j);
            dfs(grid, i, j - 1);
        }
    }

}
