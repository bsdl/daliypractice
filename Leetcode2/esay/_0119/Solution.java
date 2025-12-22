package com.bsdl.esay._0119;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(pre.get(j) + pre.get(j - 1));
                }
            }
            pre = row;
        }
        return row;
    }



}
