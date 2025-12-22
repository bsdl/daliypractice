package com.bsdl.medium._0105;

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

class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int instart, int inend, int poststart, int postend) {
        if (instart > inend) {
            return null;
        }
        int nodeVal = postorder[postend];
        TreeNode node = new TreeNode(nodeVal);
        int index = instart;
        while (index <= inend && inorder[index] != nodeVal) {
            index++;
        }
        int left = index - instart;
        node.left = helper(inorder, postorder, instart, index - 1, poststart, poststart + left - 1);
        node.right = helper(inorder, postorder, index + 1, inend, poststart + left, postend - 1);
        return node;
    }

    public static void main(String[] args) {
        Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal s = new Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
        s.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        
    }
}