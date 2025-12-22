package com.bsdl.esay._0892;

public class Solution {
    public int surfaceArea(int[][] grid) {
        int surfaceArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    surfaceArea += 2 + grid[i][j] * 4;
                }
                if (i > 0) {
                    surfaceArea -= Math.min(grid[i][j], grid[i - 1][j]);
                }
                if (j > 0) {
                    surfaceArea -= Math.min(grid[i][j], grid[i][j - 1]);
                }
                if (i < grid.length - 1) {
                    surfaceArea -= Math.min(grid[i][j], grid[i + 1][j]);
                }
                if (j < grid[0].length - 1) {
                    surfaceArea -= Math.min(grid[i][j], grid[i][j + 1]);
                }
            }
        }
        return surfaceArea;
    }
}

