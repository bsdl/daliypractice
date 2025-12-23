package medium._0337;


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

// 所能抢到的最大金额为该节点加上该节点左右孩子的左右节点之和和该节点的左右孩子之和的较大值
public class Solution {
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 记录防止重复搜索出现过的节点的金额
        if(map.containsKey(root)) {
            return map.get(root);
        }
        int val = 0;
        if (root.left != null) {
            val += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            val += rob(root.right.left) + rob(root.right.right);
        }
        int max = Math.max(root.val + val, rob(root.left) + rob(root.right));
        map.put(root, max);
        return max;
    }
}
