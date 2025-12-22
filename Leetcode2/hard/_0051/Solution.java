package com.bsdl.hard._0051;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int n;
    List<List<String>> nQueens;
    int[] queenPos;
    int[] cols;
    // 两个方向的对角线
    int[] dial1;
    int[] dial2;


    public List<List<String>> solveNQueens(int n) {
        nQueens = new ArrayList<>();
        this.n = n;
        cols = new int[n];
        dial1 = new int[n * 2 - 1];
        dial2 = new int[n * 2 - 1];
        queenPos = new int[n];
        helper(0);
        return nQueens;
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
                    List<String> oneRes = new ArrayList<>();
                    for (int pos : queenPos) {
                        StringBuilder sb = new StringBuilder();
                        int index = 0;
                        while (index < pos) {
                            sb.append(".");
                            index++;
                        }
                        sb.append("Q");
                        index++;
                        while (index < n) {
                            sb.append(".");
                            index++;
                        }
                        oneRes.add(sb.toString());
                    }
                    nQueens.add(oneRes);
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
