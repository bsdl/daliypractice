package com.bsdl.medium._0454;

import java.util.HashMap;
import java.util.Map;

class _4Sum_II {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map1 = new HashMap<>();
        int tuples = 0;
        for(int a: A) {
            for(int b: B) {
                map1.put(a + b, map1.getOrDefault(a + b, 0) + 1);
            }
        }
        for(int c: C) {
            for(int d: D) {
                int rest = 0 - (c + d);
                if(map1.containsKey(rest)) {
                    tuples += map1.get(rest);
                }
            }
        }
        return tuples;
    }
}