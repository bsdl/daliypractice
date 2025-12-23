package medium._1171;

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List {
    // public ListNode removeZeroSumSublists(ListNode head) {
    //     ListNode left = head, right, prev = left;
    //     int sum;
    //     for (; left != null; prev = left, left = left.next) {
    //         sum = 0;
    //         for (right = left; right != null ;) {
    //             sum += right.val;
    //             if (sum == 0) {
    //                 if (left == head) {
    //                     left = right.next;
    //                     head = left;
    //                 }else {
    //                     left = right.next;
    //                     prev.next = left;
    //                 }
    //                 right = left;
    //             }else {
    //                 right = right.next;
    //             }
    //         }
    //         if (left == null) {
    //             break;
    //         }
    //     }
    //     return head;
    // }


    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode prev = new ListNode(0);
        prev.next = head;
        int sum = 0;
        for (ListNode node = prev; node != null; node = node.next) {
            sum += node.val;
            map.put(sum, node);
        }
        sum = 0;
        for (ListNode node = prev; node != null; node = node.next) {
            sum += node.val;
            node.next = map.get(sum).next;
        }
        return prev.next;
    }

    public static void main(String args[]) {
        ListNode node = new ListNode(1);
        ListNode head = node;
        int[] arr = {2,3,-3,4};
        for(int i : arr) {
            ListNode n = new ListNode(i);
            node.next = n;
            node = node.next;
        }
        Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List s = new Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List();
        s.removeZeroSumSublists(head);
    }
}
