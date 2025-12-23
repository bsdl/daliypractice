package hard._0135;

import javax.swing.plaf.SliderUI;
import java.util.Arrays;

public class Solution {
    public int candy(int[] ratings) {
        int kidsNum = ratings.length;
        if (kidsNum == 0) {
            return 0;
        }
        int[] candiesForEach = new int[kidsNum];
        Arrays.fill(candiesForEach, 1);
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < kidsNum; i++) {
                if (i != kidsNum - 1 && ratings[i] > ratings[i + 1] && candiesForEach[i] <= candiesForEach[i + 1]) {
                    candiesForEach[i] = candiesForEach[i + 1] + 1;
                    flag = true;
                }
                if (i > 0 && ratings[i] > ratings[i - 1] && candiesForEach[i] <= candiesForEach[i - 1]) {
                    candiesForEach[i] = candiesForEach[i - 1] + 1;
                    flag = true;
                }
            }
        }
        int candiesTol = 0;
        for (int candies : candiesForEach
        ) {
            candiesTol += candies;
        }
        return candiesTol;
    }
}
