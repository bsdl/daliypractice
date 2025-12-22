package com.bsdl.medium._0134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 1) {
            return gas[0] >= cost[0] ? 0 : -1;
        }
        for (int i = 0; i < gas.length; i++) {
            int left = gas[i] - cost[i];
            if (left < 0) {
                continue;
            }
            int next = i + 1;
            if (next == gas.length) {
                next = 0;
            }

            while (left > 0) {
                left = left + gas[next] - cost[next];
                if (left < 0) {
                    break;
                } else {
                    next++;
                    if (next == gas.length) {
                        next = 0;
                    }
                }
                if (next == i) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3});
        System.out.println(res);
    }
}
