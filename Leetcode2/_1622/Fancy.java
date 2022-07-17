package Leetcode2._1622;

import java.util.*;


class Fancy {

    private static final int MOD = 1000_000_007;
    private List<Integer> ops; 
    private List<Integer> fancyArray;
    private Map<Integer, Long> cache;

    public Fancy() {
        ops= new ArrayList<>();
        fancyArray = new ArrayList<>();
        cache = new HashMap<>();
    }
    
    public void append(int val) {
        fancyArray.add(val + 100 * ops.size());
    }
    
    public void addAll(int inc) {
        ops.add(inc);
        cache.clear();
    }
    
    public void multAll(int m) {
        ops.add(-m);
        cache.clear();
    }
    
    public int getIndex(int idx) {
        long result = -1;
        if (cache.get(idx) != null) {
            result = cache.get(idx);
        } else if (idx < fancyArray.size()) {
            result = fancyArray.get(idx) % 100;
            int start = fancyArray.get(idx) / 100;
            for (int i = start; i < ops.size(); i++) {
                int op = ops.get(i);
                if (op > 0) {
                    result += op;
                    if (result > MOD) {
                        result -= MOD;
                    }
                } else if (op < 0) {
                    result *= (-op);
                    if (result > MOD) {
                        result %= MOD;
                    } 
                }
            }
            cache.put(idx, result);
        }
        return (int)result;
    }

    public static void main(String[] args) {
        Fancy obj = new Fancy();
        obj.append(2);
        obj.addAll(3);
        obj.append(7);
        obj.multAll(2);
        System.out.println(obj.getIndex(0));
        obj.addAll(3);
        obj.append(10);
        obj.multAll(2);
        System.out.println(obj.getIndex(0));
        System.out.println(obj.getIndex(1));
        System.out.println(obj.getIndex(2));
        // long num = 5 * 1871401280510361600L + 212240022033961999L;
        // System.out.println(num % MOD);
        // System.out.println(5 * 1871401280510361600L);
        // 1871401280510361600L
        // 9223372036854775807L
        // -981298515
        // 601045500]

    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */