package com.bsdl.medium._0002;


public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            if (val >= 10) {
                val %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            node.next = new ListNode(val);
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            if (carry == 0) {
                node.next = l1;
                break;
            } else {
                int val = l1.val + carry;
                if (val >= 10) {
                    val %= 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                l1 = l1.next;
                node.next = new ListNode(val);
                node = node.next;
            }
        }
        while (l2 != null) {
            if (carry == 0) {
                node.next = l2;
                break;
            } else {
                int val = l2.val + carry;
                if (val >= 10) {
                    val %= 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                l2 = l2.next;
                node.next = new ListNode(val);
                node = node.next;
            }
        }
        if (carry == 1) {
            node.next = new ListNode(1);
        }
        return head.next;
    }
}
