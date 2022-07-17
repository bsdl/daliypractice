//
// Created by bsdl on 2021/4/24.
//

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
struct ListNode {
    int val;
    ListNode *next;

    ListNode() : val(0), next(nullptr) {}

    ListNode(int x) : val(x), next(nullptr) {}

    ListNode(int x, ListNode *next) : val(x), next(next) {}
};


class Solution {
public:
    ListNode *reverseBetween(ListNode *head, int left, int right) {
        if (head == nullptr || head->next == nullptr) {
            return head;
        }
        auto *dummy = new ListNode();
        dummy->next = head;
        ListNode *l = dummy, *r = head;
        while (--left > 0) {
            l = l->next;
        }
        while (--right > 0) {
            r = r->next;
        }
        if (l == r) {
            return head;
        }
        ListNode *subHead = l->next;
        ListNode *subEnd = subHead;
        ListNode *end = r->next;
        l->next = nullptr;
        r->next = nullptr;
        ListNode *cur = subHead->next;
        subHead->next = nullptr;
        while (cur != nullptr) {
            ListNode *nextNode = cur->next;
            cur->next = subHead;
            subHead = cur;
            cur = nextNode;
        }
        l->next = subHead;
        subEnd->next = end;
        return dummy->next;
    }
};


int main() {
    auto* obj = new Solution();
//    auto *head = new ListNode(1);
//    head->val = 1;
//    ListNode node1(2);
    ListNode node2(3);
//    ListNode node3(4);
    ListNode node4(5);
//    head->next = &node1;
//    node1.next = &node2;
    node2.next = &node4;
//    node3.next = &node4;
    obj->reverseBetween(&node2, 1, 2);
    return 0;
}