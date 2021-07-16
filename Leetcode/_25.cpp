//
// Created by bsdl on 2021/3/21.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <queue>
#include <stack>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};
class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        stack<ListNode*> st;
        ListNode *dummy = new ListNode(-1), *pre = dummy;
        while (true) {
            int count = 0;
            ListNode *node = head;
            while (node && count < k) {
                count++;
                st.push(node);
                node = node->next;
            }
            if (count < k) {
                break;
            }
            while (!st.empty()) {
                pre->next = st.top();
                st.pop();
                pre = pre->next;
            }
            pre->next = node;
            head = node;
        }
        return dummy->next;
    }
};
