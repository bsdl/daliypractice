package esay._0190;

public class Reverse_Bits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += (n & 1);
            n >>= 1;
        }
        return res;
    }

    public static void main(String args[]) {
        Reverse_Bits r = new Reverse_Bits();
        r.reverseBits(0b00000010100101000001111010011100);
    }
}