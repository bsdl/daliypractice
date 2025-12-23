package medium._0945;

import java.util.Arrays;

public class Solution {
    public int minIncrementForUnique(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        int times = 0;
        int preNum = A[0];
        for (int i = 1; i < A.length; i++) {
            if (preNum + 1 <= A[i]) {
                preNum = A[i];
            } else {
                times += (preNum + 1 - A[i]);
                preNum++;
            }
        }
        return times;
    }
}
