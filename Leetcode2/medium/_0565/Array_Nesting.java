package medium._0565;

import java.util.*;

class Array_Nesting {
    public int arrayNesting(int[] nums) {
        int maxLen = 0;
        boolean[] isExists = new boolean[nums.length];
        Arrays.fill(isExists, false);
        for(int i = 0; i < nums.length; i++) {
            if(isExists[i]) {
                continue;
            }         
            int len = 1;
            int index = nums[i];
            while(index != i) {
                len++;
                isExists[index] = true;
                index = nums[index];
            }
            maxLen = Math.max(maxLen, len);     
        }
        return maxLen;
    }
}