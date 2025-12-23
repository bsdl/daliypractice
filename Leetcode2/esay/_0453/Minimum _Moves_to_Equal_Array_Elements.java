package esay._0453;

import java.util.*;

class Minimum_Moves_to_Equal_Array_Elements {
    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int times = 0;
        for (int num : nums) {
            num -= min;
            times += num;
        }
        return times;
    }
}