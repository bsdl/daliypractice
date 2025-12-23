package esay._0107;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

class Binary_Tree_Level_Order_Traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            result.add(0, new LinkedList<>());
            int queSize = que.size();
            while (queSize != 0) {
                TreeNode node = que.poll();
                result.get(0).add(node.val);
                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
                queSize--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(2);
        t1.right = new TreeNode(3);
        t1.left.left = new TreeNode(4);
        t1.left.right = new TreeNode(5);
        Binary_Tree_Level_Order_Traversal_II b = new Binary_Tree_Level_Order_Traversal_II();
        b.levelOrderBottom(t1);
        // TreeNode t2 = new TreeNode(2);
        // t2.left = new TreeNode(1);
        // t2.right = new TreeNode(3);
        // t2.left.right = new TreeNode(4);
        // t2.right.right = new TreeNode(7);   
    }
}