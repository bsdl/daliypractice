package esay._0069;

public class Solution {
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int left = 0;
        int right = x;
        while (right > left + 1) {
            int mid = (left + right) >> 1;
            if (x / mid < mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.mySqrt(6);
    }
}
