package esay._0206;

import java.util.*;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    


public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode post = head.next;
        while (post != null) {
            head.next = pre;
            pre = head;
            head = post;
            post = post.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode n5 = new ListNode(5,null);
        ListNode n4 = new ListNode(4,n5);
        ListNode n3 = new ListNode(3,n4);
        ListNode n2= new ListNode(2,n3);
        ListNode head = new ListNode(1,n2);
        Solution solution = new Solution();
        solution.reverseList(head);
    }
}