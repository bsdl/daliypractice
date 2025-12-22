package com.bsdl.medium._0130;

public class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        if(row == 0) {
            return;
        }
        int col = board[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                boolean isEdge = i == 0 || j == 0 || i == row - 1 || j == col - 1;
                if(isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }else if(board[i][j] == '@') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '@') {
            return;
        }
        board[i][j] = '@';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
