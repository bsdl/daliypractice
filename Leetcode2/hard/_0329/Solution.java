package hard._0329;

public class Solution {
    static final int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int row, col;

    public int longestIncreasingPath(int[][] matrix) {
        row = matrix.length;
        if (row == 0) {
            return 0;
        }
        col = matrix[0].length;
        int[][] memo = new int[row][col];
        int longestPathLen = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                longestPathLen = Math.max(longestPathLen, dfs(matrix, i, j, memo));
            }
        }
        return longestPathLen;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        for (int[] move : moves) {
            int x = i + move[0];
            int y = j + move[1];
            if (x >= 0 && y >= 0 && x < row && y < col && matrix[x][y] > matrix[i][j]) {
                memo[i][j] = Math.max(memo[i][j], dfs(matrix, x, y, memo));
            }
        }
        return ++memo[i][j];
    }

}
