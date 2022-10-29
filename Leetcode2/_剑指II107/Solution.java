package _剑指II107;

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] res = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    if (i > 0) {
                        if (j > 0) {
                            res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + 1;
                        } else {
                            res[i][j] = res[i - 1][j] + 1;
                        }
                    } else {
                        if (j > 0) {
                            res[i][j] = res[i][j - 1] + 1;
                        } else {
                            res[i][j] = 20000;
                        }
                    }
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 1) {
                    if (i < m - 1) {
                        if (j < n - 1) {
                            res[i][j] = Math.min(Math.min(res[i + 1][j], res[i][j + 1]) + 1, res[i][j]);
                        } else {
                            res[i][j] = Math.min(res[i+1][j] + 1, res[i][j]);
                        }
                    } else {
                        if (j < n - 1) {
                            res[i][j] = Math.min(res[i][j + 1] + 1, res[i][j]);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        
    }
}