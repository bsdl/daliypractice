package medium._1111;


public class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int depth = 0;
        int idx = 0;
        for (char ch: seq.toCharArray()) {
            if (ch == '(') {
                ans[idx++] = ++depth % 2;
            } else {
                ans[idx++] = depth-- & 2;
            }
        }
        return ans;
    }
}
