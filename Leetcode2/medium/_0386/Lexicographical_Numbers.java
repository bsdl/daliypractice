package com.bsdl.medium._0386;

import java.util.*;

class Lexicographical_Numbers {
    // 10叉树先序序列
    public List<Integer> lexicalOrder(int n) {
        List<Integer> se = new LinkedList<>();
        dfs(0, se, n);
        return se;
    }

    public void dfs(int root, List<Integer> se, int n) {
        if(root > n) {
            return;
        }
        if(root != 0) {
            se.add(root);
        }      
        for(int i = 0; i <= 9; i++) {
            int node = root * 10 + i;
            if(node > 0) {
                dfs(root * 10 + i, se, n);
            }         
        }
    }
}