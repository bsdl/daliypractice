package com.bsdl.esay._0617;

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

class Merge_Two_Binary_Trees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode t = null;
        if (t1 == null && t2 == null) {
            return t;
        }else if (t1 == null) {
            t = new TreeNode(t2.val);
            t.left = mergeTrees(null, t2.left);
            t.right = mergeTrees(null, t2.right);
        }else if (t2 == null) {
            t = new TreeNode(t1.val);
            t.left = mergeTrees(t1.left, null);
            t.right = mergeTrees(t1.right, null);
        }else {
            t = new TreeNode(t1.val + t2.val);
            t.left = mergeTrees(t1.left, t2.left);
            t.right = mergeTrees(t1.right, t2.right);
        }
        return t;
    }

    // public TreeNode helper(TreeNode t1, TreeNode t2, TreeNode t) {
    //     if (t1 == null && t2 == null) {
    //         return t;
    //     }else if (t1 == null) {
    //         t = new TreeNode(t2.val);
    //         helper(null, t2.left, t.left);
    //         // return helper(null, t2.right, t.right);
    //     }else if (t2 == null) {
    //         t = new TreeNode(t1.val);
    //         helper(t1.left, null, t.left);
    //         helper(t1.right, null, t.right);
    //     }else {
    //         t = new TreeNode(t1.val + t2.val);
    //         helper(t1.left, t2.left, t.left);
    //         helper(t1.right, t2.right, t.right);
    //     }
    // }
    public static void main(String args[]) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);
    }
}
