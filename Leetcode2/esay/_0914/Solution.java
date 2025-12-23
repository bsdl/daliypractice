package esay._0914;

public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        // 0与一个数的最大公约数是这个数本身
        int[] counter = new int[10000];
        for (int num : deck) {
            counter[num]++;
        }
        int x = 0;
        for (int cnt: counter) {
            if(cnt > 0) {
                x = gcd(x, cnt);
            }
            if (x == 1) {
                return false;
            }
        }
        return x >= 2;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
