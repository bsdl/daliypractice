package com.bsdl.medium._0430;

import java.util.Stack;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/


class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}

class Flatten_a_Multilevel_Doubly_Linked_List {
    public Node flatten(Node head) {
        Stack<Node> stack = new Stack<>();
        if (head != null) {
            if (head.next != null) {
                stack.push(head.next);
            }
            if (head.child != null) {
                stack.push(head.child);
            }
        }else {
            return null;
        }
        Node hNode = new Node();
        hNode.val = head.val;
        hNode.prev = null;
        hNode.child = null;
        Node newNode = hNode;
        while (!stack.isEmpty()) {
            Node node = new Node();
            Node tmpNode = stack.pop();
            newNode.next = node;
            node.prev = newNode;
            node.val = tmpNode.val;
            node.child = null;
            newNode = newNode.next;
            if (tmpNode.next != null) {
                stack.push(tmpNode.next);
            }
            if (tmpNode.child != null) {
                stack.push(tmpNode.child);
            }
        }
        return hNode;
    }
}