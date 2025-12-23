package esay._3074;

import java.util.Arrays;

public class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        reverseArray(capacity);
        Arrays.sort(apple);
        int index = 0;
        int left = 0;
        for (int i = 0; i < apple.length;) {
            left = capacity[index] - apple[i];
            if (left < 0) {
                apple[i] -= capacity[index];
                index++;
                continue;
            } else if (left > 0) {
                capacity[index] = left;
                i++;
            } else {
                i++;
                index++;
            }
        }
        if (left == 0) {
            return index;
        }
        return index + 1;
    }

    private void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] apple = {1,3,2 };
        int[] capacity = { 4,3,1,5,2 };
        Solution solution = new Solution();
        int ret = solution.minimumBoxes(apple, capacity);
        System.out.println("\n=====>结果:" + ret);
    }
}
