package com.bsdl.medium._0429;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/


class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = que.size();
            for(int i = 0; i < size; i++) {
                Node node = que.poll();
                list.add(node.val);
                que.addAll(node.children);
            }
            result.add(list);
        }
        return result;
    }
}
