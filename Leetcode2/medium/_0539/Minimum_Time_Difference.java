package medium._0539;

import java.util.*;

class Minimum_Time_Difference {
    public int findMinDifference(List<String> timePoints) {
        int size = timePoints.size();
        int[] minutes = new int[size];
        int index = 0;
        for(String timePoint: timePoints) {
            int minute = Integer.valueOf(timePoint.substring(0, 2)) * 60 + Integer.valueOf(timePoint.substring(3));
            minutes[index++] = minute;
        }
        Arrays.sort(minutes);
        int aDay = 24 * 60;
        int minTimeDiff = aDay - minutes[size - 1] + minutes[0];
        for(int i = 1; i < size; i++) {
            int diff = minutes[i] - minutes[i - 1];
            minTimeDiff = Math.min(minTimeDiff, diff);
        }
        return minTimeDiff;
    }
}