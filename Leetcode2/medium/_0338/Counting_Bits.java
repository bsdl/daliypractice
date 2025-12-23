package medium._0338;

class Counting_Bits {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        // result[0] = 0;
        for(int i = 1; i <= num; i++) {
            int tmp = i - 1;
            int next = result[i - 1];
            while(tmp % 2 != 0) {
                next--;
                tmp >>= 1;
            }
            result[i] = next + 1;         
        }  
        return result;
    }

    public static void main(String[] args) {
        Counting_Bits c = new Counting_Bits();
        int[] test = c.countBits(5);
    }
}