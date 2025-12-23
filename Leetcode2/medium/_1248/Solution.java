package medium._1248;

public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0, right = 0;
        int numOfOdd = 0;
        int numOfArrHasKOdds = 0;
        while (right < nums.length) {
            if (nums[right++] % 2 != 0) {
                numOfOdd++;
            }

            if (numOfOdd == k) {
                int rightStart = right;
                while (right < nums.length && nums[right] % 2 == 0) {
                    right++;
                }
                int evenNumAfterRight = right - rightStart;
                int evenNumBeforeLeft = 0;
                while (nums[left] % 2 == 0) {
                    left++;
                    evenNumBeforeLeft++;
                }
                numOfArrHasKOdds += (evenNumAfterRight + 1) * (evenNumBeforeLeft + 1);
                // 此时左右指针指向奇数
                left++;
                numOfOdd--;
            }
        }
        return numOfArrHasKOdds;
    }
}
