package medium._0378;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    //    public int kthSmallest(int[][] matrix, int k) {
//        if(matrix.length == 0) {
//            return 0;
//        }
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//        for (int[] ints : matrix) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                pq.add(ints[j]);
//                if (pq.size() > k) {
//                    pq.poll();
//                }
//            }
//        }
//        return pq.peek();
//    }

    // 二分查找
    // 二分的左边是矩阵左上角成员，右边是矩阵右下角的成员
    // 每次计算矩阵每一行小于等于mid的成员的个数
    // 小于k的话就left = mid + 1, 大于k的话就right = mid
    // 左后返回left
//    public int kthSmallest(int[][] matrix, int k) {
//        if (matrix.length == 0) {
//            return 0;
//        }
//
//        int row = matrix.length, col = matrix[0].length;
//        int left = matrix[0][0], right = matrix[row - 1][col - 1];
//        while (left < right) {
//            int cnt = 0;
//            int mid = left + (right - left) / 2;
//            for (int[] ints : matrix) {
//                int rowCnt = binarySearch(ints, mid) + 1;
//                System.out.println(mid + "\t" + rowCnt);
//                cnt += rowCnt;
//            }
//            if (cnt < k) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        return left;
//    }
//
//
//    private int binarySearch(int[] arr, int num) {
//        int left = 0, right = arr.length - 1;
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (arr[mid] <= num) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        return arr[left] <= num ? left : left - 1;
////        return left;
//    }

    // 对上一种算法的优化，更改了计算小于等于mid的成员数量的方法
    // 因为矩阵每行每列递增
    // 所以可以从矩阵左下角开始搜索
    // 如果当前成员小于mid，那么整列都可以加上
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length;
        int left = matrix[0][0], right = matrix[row - 1][col - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = countLesThanMid(matrix, mid);
            if (cnt < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int countLesThanMid(int[][] matrix, int num) {
        int i = matrix.length - 1, j = 0;
        int cnt = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] <= num) {
                cnt += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = new int[7][];
        matrix[0] = new int[]{2, 6, 6, 7, 10, 14, 18};
        matrix[1] = new int[]{6, 11, 14, 14, 15, 20, 23};
        matrix[2] = new int[]{11, 11, 17, 21, 25, 30, 30};
        matrix[3] = new int[]{11, 12, 20, 25, 25, 35, 37};
        matrix[4] = new int[]{16, 16, 20, 29, 34, 35, 39};
        matrix[5] = new int[]{16, 18, 22, 33, 37, 37, 40};
        matrix[6] = new int[]{17, 23, 26, 36, 38, 41, 42};
        solution.kthSmallest(matrix, 32);
    }
}
