package medium._0264;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {


    public int nthUglyNumber(int n) {
        int[] nums = new int[1690];
        int[] primeFactors = {2, 3, 5};
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        pq.offer(1L);
        seen.add(1L);
        long ugly, nUgly;
        for (int i = 0; i < 1690; i++) {
            ugly = pq.poll();
            for (int num : primeFactors) {
                if (!seen.contains(num * ugly)) {
                    seen.add(num * ugly);
                    pq.offer(num * ugly);
                }
            }
            nums[i] = (int) ugly;
        }
        return nums[n - 1];
    }


}
