package esay._0665;

public class Solution {
    public boolean checkPossibility(int[] nums) {
        // 数组长度小于3一定为true
        if(nums.length < 3) {
            return true;
        }

        int modifyNum = 0;
        for(int i = 1; i < nums.length; i++) {
            // 当当前元素小于前一个元素时，前两个元素和当前元素比大小
            // 从而判断是挪动当前元素还是前一个元素，从而不影响后面的判断
            if(nums[i - 1] > nums[i]) {
                if(i > 1 && nums[i - 2] > nums[i]) {
                    nums[i] =nums[i - 1];
                }else {
                    nums[i - 1] = nums[i];
                }
                modifyNum++;
                if(modifyNum == 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
