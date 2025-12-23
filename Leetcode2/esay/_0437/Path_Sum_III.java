package esay._0437;

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

class Path_Sum_III {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSum(root.left, sum) + pathSum(root.right, sum) + helper(root, sum);

    }

    public int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int num = 0;
        if (sum == root.val) {
            num++;
        }
        num += helper(root.left, sum - root.val);
        num += helper(root.right, sum - root.val);
        return num;
    } 

    public static void main(String args[]) {
        
        

    }
}