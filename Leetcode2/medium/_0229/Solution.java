package medium._0229;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int candidate1 = nums[0], cnt1 = 0;
        int candidate2 = nums[0], cnt2 = 0;
        for (int num : nums) {
            if (candidate1 == num) {
                cnt1++;
                continue;
            }
            if (candidate2 == num) {
                cnt2++;
                continue;
            }
            if (cnt1 == 0) {
                candidate1 = num;
                cnt1++;
                continue;
            }
            if (cnt2 == 0) {
                candidate2 = num;
                cnt2++;
                continue;
            }
            cnt1--;
            cnt2--;
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (candidate1 == num) {
                cnt1++;
            }else if (candidate2 == num) {
                cnt2++;
            }
        }
        if (cnt1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (cnt2 > nums.length / 3) {
            result.add(candidate2);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.majorityElement(new int[]{1,1,1,3,3,2,2,2}) ;

    }
}
