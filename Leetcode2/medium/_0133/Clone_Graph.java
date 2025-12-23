package medium._0133;

import java.util.*;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }  
}
*/


class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class Solution {
//    public Node cloneGraph(Node node) {
//        if(node == null) {
//            return null;
//        }
//        Deque<Node> deque = new LinkedList<>();
//        Map<Node, Node> map = new HashMap<>();
//        Node newNode = new Node(node.val);
//        map.put(node, newNode);
//        deque.offer(node);
//        while(!deque.isEmpty()) {
//            Node vertex = deque.poll();
//            for(Node n: vertex.neighbors) {
//                if(!map.containsKey(n)) {
//                    map.put(n, new Node(n.val));
//                    deque.offer(n);
//                }
//                map.get(vertex).neighbors.add(map.get(n));
//            }
//        }
//        return newNode;
//    }
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    private Node dfs(Node node) {
        if(node == null) {
            return null;
        }
        if(map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node, newNode);
        for (Node vertex: node.neighbors) {
            newNode.neighbors.add(dfs(vertex));
        }
        return newNode;
    }
}