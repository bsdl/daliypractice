package medium._0036;

class Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (rows[i][num] || cols[j][num] || boxes[i / 3 * 3 + j / 3][num])
                        return false;
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[i / 3 * 3 + j / 3][num] = true;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        
    }
}