package hard._0037;

class Solution {

    int[][] rows;
    int[][] cols;
    int[][] boxes;
    char[][] board;
    boolean isSolved;

    public void solveSudoku(char[][] board) {
        this.board = board;
        rows = new int[9][10];
        cols = new int[9][10];
        boxes = new int[9][10];
        isSolved = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rows[i][num]++;
                    cols[j][num]++;
                    int idx = (i / 3) * 3 + j / 3;
                    boxes[idx][num]++;
                }
            }
        }
        helper(0, 0);
    }

    private void helper(int row, int col) {
        if (this.board[row][col] != '.') {
            if (row == 8 && col == 8) {
                isSolved = true;
                return;
            }
            // 已有数字，直接回溯到下一个点
            if (col == 8) {
                helper(row + 1, 0);
            } else {
                helper(row, col + 1);
            }
        } else {
            for (int i = 1; i <= 9; i++) {
                int idx = (row / 3) * 3 + col / 3;
                if (rows[row][i] + cols[col][i] + boxes[idx][i] == 0) {
                    // 放置数字
                    rows[row][i]++;
                    cols[col][i]++;
                    boxes[idx][i]++;
                    this.board[row][col] = (char) (i + '0');
                    if (row == 8 && col == 8) {
                        isSolved = true;
                        return;
                    }
                    // 到下一个点
                    if (col == 8) {
                        helper(row + 1, 0);
                    } else {
                        helper(row, col + 1);
                    }
                    // 恢复数字
                    if (!isSolved) {
                        rows[row][i]--;
                        cols[col][i]--;
                        boxes[idx][i]--;
                        this.board[row][col] = '.';
                    }
                }
            }
        }
    }
}
