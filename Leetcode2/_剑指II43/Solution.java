package _剑指II43;

import java.util.ArrayDeque;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class CBTInserter {

    private Queue<TreeNode> que;
    TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
        que = new ArrayDeque<>();
        que.offer(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node.left != null && node.right != null) {
                que.offer(node.left);
                que.offer(node.right);
            } else {
                que.clear();
                que.offer(node);
                break;
            }
        }
    }
    
    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        TreeNode father = this.que.peek();
        if (father.left == null && father.right == null) {
            father.left = node;
        } else {
            father.right = node;
        }
        this.que.offer(node);
        if (father.left != null && father.right != null) {
            this.que.poll();
        }
        return father.val;
    }
    
    public TreeNode get_root() {
        return this.root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */