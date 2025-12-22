package com.bsdl.medium._0209;

class Minimum_Size_Subarray_Sum {
    // public int minSubArrayLen(int s, int[] nums) {
    //     int left = 0, right = 0;
    //     int subArrayLen = Integer.MAX_VALUE;
    //     int val = 0;
    //     while(right < nums.length) {
    //         while(val < s && right < nums.length) {
    //             val += nums[right];
    //             right++;
    //         }
    //         while(val >= s) {
    //             subArrayLen = Math.min(subArrayLen, right - left);
    //             val -= nums[left];
    //             left++;
    //         }
    //     }
    //     if(subArrayLen == Integer.MAX_VALUE) {
    //         return 0;
    //     }
    //     return subArrayLen;
    // }

    public int minSubArrayLen(int s, int[] nums) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        int subArrayLen = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            int right = nums.length - 1;
            int left = i;
            if(i == nums.length - 1 && nums[left] < s) {
                break;
            } 
            int mid = left + (right - left) / 2;
            int sum = sums[mid] - sums[i] + nums[i];
            while(left <= right) {
                sum = sums[mid] - sums[i] + nums[i];
                if(sum < s) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
                mid = left + (right - left) / 2;
            }   
            if(sum >= s) {
                subArrayLen = Math.min(subArrayLen, mid - i + 1);
            }
            
        }
        if(subArrayLen == Integer.MAX_VALUE) {
            return 0;
        }
        return subArrayLen;
    }



    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        Minimum_Size_Subarray_Sum m = new Minimum_Size_Subarray_Sum();
        m.minSubArrayLen(15, arr);
    }
}