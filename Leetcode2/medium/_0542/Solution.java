package com.bsdl.medium._0542;

public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] dists = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    int dist = dfs(matrix, dists, i, j);
                    dists[i][j] = dist;
                }
            }
        }
        return dists;
    }

    private int dfs(int[][] matrix, int[][] dists, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] == 0) {
            return 0;
        }

        return 1 + Math.min(Math.min(dfs(matrix, dists, i + 1, j), dfs(matrix, dists, i, j + 1)),
                Math.min(dfs(matrix, dists, i - 1, j), dfs(matrix, dists, i, j - 1)));
    }
}
