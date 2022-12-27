package _剑指II73;


class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int maxPile = -1;
        for (int pile: piles) {
            maxPile = Math.max(maxPile, pile);
        }
        int right = maxPile;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int tolHour = 0;
            for (int pile: piles) {
                int hour = pile / mid;
                hour += (pile % mid == 0) ? 0 : 1;
                tolHour += hour;
                if (tolHour > h) {
                    break;
                }
            }
            if (tolHour == h) {
                res = mid;
                right = mid - 1;
            } else if (tolHour > h) {
                left = mid + 1;
            } else {
                res = mid;
                right = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int val = solution.minEatingSpeed(new int[]{1,1,1,999999999},
         10);
        System.out.println(val);
    }
}
