package com.bsdl.medium._0095;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int n) {
        List<TreeNode> list = new ArrayList<>();
        if (start > n) {
            list.add(null);
            return list;
        }
        if (start == n) {
            TreeNode root = new TreeNode(start);
            list.add(root);
            return list;
        }
        for (int i = start; i <= n; i++) {
            List<TreeNode> leftTrees = helper(start, i - 1);
            List<TreeNode> rightTrees = helper(i + 1, n);
            for (TreeNode leftTree: leftTrees
            ) {
                for (TreeNode rightTree: rightTrees
                ) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftTree;
                    node.right = rightTree;
                    list.add(node);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.generateTrees(6);
    }
}
