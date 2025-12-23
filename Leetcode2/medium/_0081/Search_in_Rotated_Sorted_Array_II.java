package medium._0081;

class Search_in_Rotated_Sorted_Array_II {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            while(left < right && nums[left] == nums[left + 1]) {
                ++left;
            }
            while(left < right && nums[right] == nums[right - 1]) {
                --right;
            }
            int mid = (left + right) >> 1;
            if(nums[mid] == target) {
                return true;
            } else if(nums[mid] > nums[right]) {
                if(nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,3,1};
        Search_in_Rotated_Sorted_Array_II s = new Search_in_Rotated_Sorted_Array_II();
        s.search(nums, 3);
    }
}