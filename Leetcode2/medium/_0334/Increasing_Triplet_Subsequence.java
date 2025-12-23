package medium._0334;

class Increasing_Triplet_Subsequence {
    public boolean increasingTriplet(int[] nums) {
        int left = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= left)
                left = num;
            else if (num <= mid)
                mid = num;
            else
                return true;
        }
        return false;
    }
}