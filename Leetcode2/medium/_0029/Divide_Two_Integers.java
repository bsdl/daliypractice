package medium._0029;

class Divide_Two_Integers {
    // public int divide(int dividend, int divisor) {
    //     // Integer.MAX_VALUE 左移一位变成0 
    //     // Integer.MIN_VALUE 左移一位变成-1
    //     if (divisor == -1 && dividend == Integer.MIN_VALUE) {
    //         return Integer.MAX_VALUE;
    //     }
    //     int sign = (dividend ^ divisor) < 0 ? -1: 1;
    //     int times = 0;
    //     long up =  Math.abs((long) dividend);
    //     long down = Math.abs((long) divisor);
    //     if (down > up) {
    //         return 0;
    //     }
    //     for (int i = 31; i >= 0; i--) {
    //         if ((up >> i) >= down) {
    //             times += 1 << i;
    //             up -= down << i;
    //         }
    //     }
    //     return times * sign;
    // }

    public int divide(int dividend, int divisor) {
        int sign = (dividend ^ divisor) < 0? -1: 1;
        if (dividend >= 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        if (divisor < dividend) {
            return 0;
        }
        int times = 1;
        while (dividend <= divisor) {
            int tmpDivisor = divisor;
            while (dividend > tmpDivisor << 1) {
                tmpDivisor <<= 1;
            }
        }
        return times * sign;
    }

    public static void main(String[] args) {
        // System.out.println(Integer.MAX_VALUE);
        // System.out.println(Integer.MIN_VALUE / (-1));
        // System.out.println(-10 >> 3);
        Divide_Two_Integers d = new Divide_Two_Integers();
        d.divide(100, 3);
    }
}