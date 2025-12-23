package esay._0543;

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

class Diameter_of_Binary_Tree {
    int result;
    public int diameterOfBinaryTree(TreeNode root) {
        result = 0;
        calDepth(root);
        return result;
    }
    public int calDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = calDepth(root.left);
        int right = calDepth(root.right);
        result = Math.max(result, left + right);
        return Math.max(left, right) + 1;
    }



    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        // Diameter_of_Binary_Tree s = new Diameter_of_Binary_Tree();
        // s.diameterOfBinaryTree(t1);


        // TreeNode t2 = new TreeNode(2);
        // t2.left = new TreeNode(1);
        // t2.right = new TreeNode(3);
        // t2.left.right = new TreeNode(4);
        // t2.right.right = new TreeNode(7);   
    }
}