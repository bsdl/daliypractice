package com.bsdl.medium._0661;

import java.util.*;


class Valid_Triangle_Number {
    public int triangleNumber(int[] nums) {
        int triangles = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for(int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while(k < nums.length && nums[i] + nums[j] > nums[k] ) {
                    k++;
                }
                triangles += k - j - 1; 
            }
            
        }
        return triangles;
    }

    public static void main(String[] args) {
        Valid_Triangle_Number v = new Valid_Triangle_Number();
        v.triangleNumber(new int[]{1,2,3,4,5,6});
    }
}