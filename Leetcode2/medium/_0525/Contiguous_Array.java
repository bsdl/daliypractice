package medium._0525;

import java.util.*;

class Contiguous_Array {
    // public int findMaxLength(int[] nums) {
    //     int subLen = 0;
    //     for(int i = 0; i < nums.length; i++) {
    //         int zeros = 0, ones = 0;
    //         for(int j = i; j < nums.length; j++) {
    //             if(nums[j] == 0) {
    //                 zeros++;
    //             }else if(nums[j] == 1) {
    //                 ones++;
    //             }
    //             if(zeros == ones) {
    //                 subLen = Math.max(subLen, j - i + 1);
    //             }               
    //         }            
    //     }
    //     return subLen;
    // }

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0, subLen = 0;
        for(int i = 0; i < nums.length; i++) {
            count += (nums[i] == 1? 1: -1);
            if(map.containsKey(count)) {
                subLen = Math.max(subLen, i - map.get(count));
            }else {
                map.put(count, i);
            }
        }
        return subLen;
    } 
}