package _769;

public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = -1, cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                cnt++;
            }
        }
        return cnt;
    }
}
