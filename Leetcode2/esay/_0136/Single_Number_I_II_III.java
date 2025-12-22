package com.bsdl.esay._0136;


class Single_Number_I_II_III {
    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] ^= nums[i - 1];  
        }
        return nums[nums.length - 1];
    }

    
    public static void main(String[] args) {
        System.out.println(10 ^ 10);
        System.out.println(10 ^ 5);
    }
}
