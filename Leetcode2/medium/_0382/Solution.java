package medium._0382;


import java.util.Random;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */


class Solution {

    ListNode head ;

    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public Solution(ListNode head) {
        this.head = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode node = this.head;
        int res = node.val;
        Random random = new Random();
        int num = 2;
        while (node != null) {
            if (random.nextInt(num) == 0) {
                res = node.val;
            }
            num++;
            node = node.next;
        }
        return res;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


