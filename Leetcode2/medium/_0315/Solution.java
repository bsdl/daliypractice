package com.bsdl.medium._0315;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        System.out.println(nums.length);
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int smallers= 0;
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[i]) {
                    smallers++;
                }
            }
            result.add(smallers);
        }
        return result;
    }
}
