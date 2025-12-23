package medium._0138;

import java.util.HashMap;
import java.util.Map;


// import java.util.HashMap;
// import java.util.Map;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
class Copy_List_with_Random_Pointer {
    // Map<Node, Node> map = new HashMap<>();
    // public Node copyRandomList(Node head) {
    //     if (head == null) {
    //         return null;
    //     }        
    //     if (map.containsKey(head)) {
    //         return map.get(head);
    //     }
    //     Node node = new Node(head.val, null, null);
    //     map.put(head, node);
    //     node.next = copyRandomList(head.next);
    //     node.random = copyRandomList(head.random);
    //     return node;
    // }

    public static void main(String args[]) {
        Node n1 = new Node(-1, null, null);
        Node n2 = new Node(8, null, null);
        Node n3 = new Node(7, null, null);
        Node n4 = new Node(-3, null, null);
        Node n5 = new Node(4, null, null);
        n1.next = n2;n2.next = n3; n3.next = n4;n4.next = n5;
        n1.random = n5;
        n2.random = n4;
        n3.random = null;
        n4.random = null;
        n5.random = n1;
        Copy_List_with_Random_Pointer c = new Copy_List_with_Random_Pointer();
        Node node = c.copyRandomList(n1);
        System.out.println(node.random.val);
    }

    public Node copyRandomList(Node head) { 
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();  
        Node copyHead = new Node(head.val, null, null);
        Node headRandom = null;
        if (head.random != null && head.random != head) {
            headRandom = new Node(head.random.val, null, null);
            map.put(head.random, headRandom);
        }else if (head.random != null) {
            headRandom = copyHead;
            map.put(head.random, headRandom);
        }
        copyHead.random = headRandom;
        map.put(head, copyHead);
        Node node = head.next;
        Node newNode = copyHead;
        while (node != null) {
            if (map.containsKey(node)) {
                newNode.next = map.get(node);          
            }else {
                Node copyNode = new Node(node.val, null, null);
                newNode.next = copyNode; 
                map.put(node, copyNode);           
            }
            newNode = newNode.next;
            Node nodeRandom = null;
            if (node.random != null && node.random != node) {
                if (map.containsKey(node.random)) {
                    nodeRandom = map.get(node.random);
                } else {
                    nodeRandom = new Node(node.random.val, null, null);
                    map.put(node.random, nodeRandom);
                }              
            }else if (node.random != null) {
                nodeRandom = newNode;
                map.put(node.random, nodeRandom);
            }
            newNode.random = nodeRandom;
            node = node.next;
        }
        return copyHead;
    }
}