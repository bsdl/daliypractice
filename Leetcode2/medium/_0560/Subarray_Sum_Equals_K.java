package medium._0560;

import java.util.*;

class Subarray_Sum_Equals_K {
    // public int subarraySum(int[] nums, int k) {
    //     int len = nums.length;
    //     int[] sums = new int[len];
    //     int subarr = 0;
    //     sums[0] = nums[0];
    //     for(int i = 1; i < len; i++) {
    //         sums[i] = sums[i - 1] + nums[i];
    //     }
    //     for(int i = 0; i < len; i++) {
    //         for(int j = i; j < len; j++) {
    //             int sum = sums[j] - sums[i] + nums[i];
    //             if(sum == k) {
    //                 subarr++;
    //             }
    //         }
    //     }
    //     return subarr;
    // }
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int subarr = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int num: nums) {
            sum += num;
            if(map.containsKey(sum - k)) {
                subarr += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return subarr;
    }
    
    public static void main(String[] args) {
        
    }
}