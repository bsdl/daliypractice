package com.bsdl.esay._0110;

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

class Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }   
        return isBalanced(root.left) && isBalanced(root.right) 
                && Math.abs(dfs(root.left) - dfs(root.right)) <= 1;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 1 + dfs(root.left);
        int right = 1 + dfs(root.right);
        return Math.max(left, right);
    }
}