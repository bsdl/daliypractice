package com.bsdl.medium._0221;

class Maximal_Square {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int i, j;
        int maxLen = 0;
        for (i = 0; i < matrix.length; i++) {
            for (j = 0; j < matrix[0].length; j++) {
                if (i != 0 && j != 0 && matrix[i][j] != '0') {
                   
                    // if (matrix[i - 1][j] == matrix[i - 1][j - 1] && matrix[i][j - 1] == matrix[i - 1][j - 1])
                    //     matrix[i][j] = (char) (matrix[i - 1][j] + 1);
                    // else {
                    //     char temp = (char) Math.max(matrix[i][j - 1], matrix[i - 1][j]);
                    //     matrix[i][j] = (char) Math.max(matrix[i - 1][j - 1], temp);
                    // }
                    matrix[i][j] = (char) (Math.min((char) Math.min(matrix[i - 1][j], matrix[i][j - 1]), matrix[i - 1][j - 1]) + 1);
                    maxLen = Math.max(maxLen, matrix[i][j] - '0');                   
                }                
            }
        }
        return maxLen * maxLen;
    }

    public static void main(String arg[]) {
        Maximal_Square m = new Maximal_Square();
        char matrix[][] = new char[4][5];
        matrix[0] = new char[]{'1','0','1','0','0'};
        matrix[1] = new char[]{'1','0','1','1','1'};
        matrix[2] = new char[]{'1','1','1','1','1'};
        matrix[3] = new char[]{'1','0','0','1','0'};
        // matrix[4] = new char[]{'0','1','1','1'};
        m.maximalSquare(matrix);
    }
}