package hard._0052;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int n;
    int[] queenPos;
    int[] cols;
    // 两个方向的对角线
    int[] dial1;
    int[] dial2;
    int totalNQueens;

    public int totalNQueens(int n) {
        this.n = n;
        cols = new int[n];
        dial1 = new int[n * 2 - 1];
        dial2 = new int[n * 2 - 1];
        queenPos = new int[n];
        helper(0);
        return this.totalNQueens;
    }

    private void helper(int row) {
        if (row >= n) {
            return;
        }
        for (int col = 0; col < n; col++) {
            //
            if (cols[col] + dial1[row - col + n - 1] + dial2[row + col] == 0) {
                // 放置皇后
                queenPos[row] = col;
                cols[col] = 1;
                dial1[row - col + n - 1] = 1;
                dial2[row + col] = 1;

                // 到最后一行时，将本次的解添加到结果集
                if (row == n - 1) {
                    this.totalNQueens++;
                }

                helper(row + 1);

                // 回溯，取消放置的皇后
                queenPos[row] = 0;
                cols[col] = 0;
                dial1[row - col + n - 1] = 0;
                dial2[row + col] = 0;
            }
        }
    }
}
