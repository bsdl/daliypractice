package _779;


public class Solution {
    public int kthGrammar(int n, int k) {
        int cur = 0, index = 1;
        while (n > 1) {
            int leftIndex = getLeftLeafIndex(index, n - 1);
            int rightIndex = index * (int)Math.pow(2, n - 1);
            int mid = (leftIndex + rightIndex) / 2;
            boolean isLeft = k <= mid;
            if (cur == 0) {
                if (isLeft) {
                    cur = 0;
                    index = 2 * index - 1;
                } else {
                    cur = 1;
                    index *= 2;
                }
            } else {
                if (isLeft) {
                    cur = 1;
                    index = 2 * index - 1;
                } else {
                    cur = 0;
                    index *= 2;
                }
            }
            n--;
        }
        return cur;
    }

    public int getLeftLeafIndex(int index, int n) {
        if (n == 0) return index;
        return getLeftLeafIndex(2 * index - 1, n - 1);
    }


    public static void main(String[] args) {
        // int res = Solution.kthGrammar(3, 4);
        // System.out.println(res);
        Solution solution = new Solution();
        // int idx = solution.getLeftLeafIndex(2, 2);
        // System.out.println(idx);
        int res= solution.kthGrammar(3,3);
        System.out.println(res);
    }
}
