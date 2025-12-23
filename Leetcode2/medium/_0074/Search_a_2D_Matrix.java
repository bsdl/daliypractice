package medium._0074;

class Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0 || matrix[0].length == 0) {
            return false;
        }
        int left = 0;
        int right = rows - 1;
        while(left < right) {
            int mid = (left + right) >> 1;
            if(matrix[mid][matrix[mid].length - 1] > target) {
                right = mid;
            } else if(matrix[mid][matrix[mid].length - 1] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        int row;
        if (matrix[left][matrix[left].length - 1] < target) {
            if (left == matrix.length - 1) {
                return false;
            }
            row = left + 1;
        } else if (matrix[left][matrix[left].length - 1] > target){
            row = left;
        } else {
            return true;
        }
        left = 0;
        right = matrix[left].length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if(matrix[row][mid] > target) {
                right = mid;
            } else if(matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = new int[1][1];
        matrix[0] = new int[] {1};
        // matrix[1] = new int[] {10,11,16,20};
        // matrix[2] = new int[] {23,30,34,50};
        Search_a_2D_Matrix s = new Search_a_2D_Matrix();
        s.searchMatrix(matrix, 1);
    }
}