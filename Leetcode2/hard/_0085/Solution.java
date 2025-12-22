package com.bsdl.hard._0085;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] numOfContinueOne = new int[matrix.length][matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (j == 0) {
                        numOfContinueOne[i][j] = 1;
                    } else {
                        numOfContinueOne[i][j] = numOfContinueOne[i][j - 1] + 1;
                    }
                } else {
                    numOfContinueOne[i][j] = 0;
                }
                int width = numOfContinueOne[i][j];
                for (int k = i; k >= 0; k--) {
                    int height = i - k + 1;
                    width = Math.min(width, numOfContinueOne[k][j]);
                    maxArea = Math.max(maxArea, width * height);
                }
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {

    }
}
