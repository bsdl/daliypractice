package com.bsdl.medium._0240;

class Search_a_2D_Matrix_II {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        for(int i = 0; i < rows; ++i) {
            int left = 0;
            int right = matrix[i].length;
            while(left < right) {
                int mid = (left + right) >> 1;
                if(matrix[i][mid] > target) {
                    right = mid;
                } else if(matrix[i][mid] < target) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }   
        }
        return false;
    }
}