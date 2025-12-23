package medium._0436;

import java.util.*;

class Find_Right_Interval {
    public int[] findRightInterval(int[][] intervals) {
        // 以区间起点升序排序
        int[][] sorted = Arrays.copyOf(intervals, intervals.length);
        Arrays.sort(sorted, (a, b) -> a[0] - b[0]);
        // 由于起始点互不相同，哈希表存放key为区间的起始， value为原始索引
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
        }    
        int[] indexes = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
            int left = 0, right = sorted.length - 1;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(intervals[i][1] > sorted[mid][0]) {
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            if(sorted[left][0] >= intervals[i][1]) {
                indexes[i] = map.get(sorted[left][0]);
            }else {
                indexes[i] = -1;
            }
        }
        return indexes;
    }

    public static void main(String[] args) {
        Find_Right_Interval f = new Find_Right_Interval();
        int[][] intervals = {
            new int[] {3,4},
            new int[] {2,3},
            new int[] {1,2}
        };
        f.findRightInterval(intervals);
    }
}