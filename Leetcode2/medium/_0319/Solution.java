package medium._0319;

import java.util.Arrays;

public class Solution {
    public int bulbSwitch(int n) {
        int[] bulbs = new int[n];
        Arrays.fill(bulbs, 1);
        int turn = 2;
        while (turn <= n) {
            int idx = turn - 1;
            while (idx < n) {
                bulbs[idx] = bulbs[idx] == 1 ? 0 : 1;
                idx += turn;
            }
            turn++;
        }
        int bulbLight = 0;
        for (int bulb : bulbs) {
            if (bulb == 1) {
                bulbLight++;
            }
        }
        return bulbLight;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i <= 1000; i++) {
            int res = solution.bulbSwitch(i);
            System.out.print(i + "的结果是：" + res + "\n");
        }

    }
}
