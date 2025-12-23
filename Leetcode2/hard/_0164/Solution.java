package hard._0164;

public class Solution {
    public int maximumGap(int[] nums) {
        int[] buckets = new int[Integer.MAX_VALUE];
        if (nums.length < 2) {
            return 0;
        }
        for (int num : nums) {
            buckets[num]++;
        }
        int leap = 0;
        int tmpidx = -1;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] > 0) {
                if (tmpidx == -1) {
                    tmpidx = i;
                } else {
                    leap = Math.max(leap, i - tmpidx);
                }
            }
        }
        return leap;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int a= solution.maximumGap(new int[]{3,6,9,1});
//        System.out.println(a);
        
    }
}
