package medium._0365;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        Stack<int[]> stack = new Stack<>();
        Set<Map.Entry<Integer, Integer>> set = new HashSet<>();
        stack.push(new int[]{0, 0});
        while (!stack.isEmpty()) {
            int[] twoRemain = stack.pop();
            int xRemain = twoRemain[0];
            int yRemain = twoRemain[1];
            if (xRemain == z || yRemain == z || xRemain + yRemain == z) {
                return true;
            }
            if (set.contains(new AbstractMap.SimpleEntry<>(xRemain, yRemain))) {
                continue;
            }
            set.add(new AbstractMap.SimpleEntry<>(xRemain, yRemain));
            stack.push(new int[]{0, yRemain});
            stack.push(new int[]{xRemain, 0});
            stack.push(new int[]{xRemain, y});
            stack.push(new int[]{x, yRemain});
            stack.push(new int[]{xRemain - Math.min(y - yRemain, xRemain), yRemain + Math.min(y - yRemain, xRemain)});
            stack.push(new int[]{xRemain + Math.min(x - xRemain, yRemain), yRemain - Math.min(x - xRemain, yRemain)});
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
