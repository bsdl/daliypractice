package com.bsdl.esay._0035;

class Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (right == -1) {
            return 0;
        }
        int mid = 0;
        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }else if (nums[mid] > target) {
                right = mid - 1;
            }else {
                return mid;
            }
        }
        if (nums[mid] > target) {
            return mid;
        }else {
            return mid + 1;
        }
    }
    public static void main(String[] args) {
        Search_Insert_Position s = new Search_Insert_Position();
        int a = s.searchInsert(new int[]{1,3,5,6}, 2);
        System.out.print(a);
    }
}