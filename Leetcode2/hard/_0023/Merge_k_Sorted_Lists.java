package com.bsdl.hard._0023;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Merge_k_Sorted_Lists {

    public class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }
 
    // public ListNode MergeKLists(ListNode[] lists) {
    //     if (lists.length == 0)
    //         return null;
    //     ListNode head = lists[0];
    //     for (int i = 1; i < lists.length; ++i) {
    //         head = Merge2Lists(head, lists[i]);
    //     }
    //     return head.next;
    // }

//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length == 0)
//            return null;
//        // ListNode head = lists[0];
//        int len = lists.length;
//        int interval = 1;
//        while (interval < len) {
//            for (int i = 0; i < len - interval; i += interval * 2) {
//                lists[i] = Merge2Lists(lists[i], lists[i + interval]);
//            }
//            interval *= 2;
//        }
//        return lists[0];
//    }
//
//    public ListNode Merge2Lists(ListNode head1, ListNode head2) {
//        ListNode head = new ListNode(0);
//        ListNode node = head;
//        node.next = null;
//        ListNode node1 = head1, node2 = head2;
//        while (node1 != null && node2 != null) {
//            if (node1.val < node2.val) {
//                node.next = node1;
//                node = node.next;
//                node1 = node1.next;
//            }else {
//                node.next = node2;
//                node = node.next;
//                node2 = node2.next;
//            }
//        }
//        if (node1 != null)
//            node.next = node1;
//        else
//            node.next = node2;
//        return head;
//    }

    public ListNode mergeKLists(ListNode[] lists) {
        // PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t.val));
        for (ListNode head: lists) {
            pq.offer(head);
        }
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            pq.offer(tmp.next);
            node.next = tmp;
            node = node.next;
        }
        return head.next;
    }

}