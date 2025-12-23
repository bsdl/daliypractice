package esay._0448;

import java.util.LinkedList;
import java.util.List;


class Find_All_Numbers_Disappeared_in_an_Array {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            nums[(nums[i] - 1) % len] += len;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] <= len) {
                result.add(i + 1);
            }
        }
        return result;
    }
}