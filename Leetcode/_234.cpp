//
// Created by bsdl on 2021/3/20.
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
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};


class Solution {
public:
    bool isPalindrome(ListNode* head) {
        stack<int> values;
        ListNode* node = head;
        while (node) {
            values.push(node->val);
            node = node->next;
        }
        node= head;
        while (node) {
            int value = values.top();
            values.pop();
            if (value == node->val) {
                node = node->next;
            } else {
                return false;
            }
        }
        return true;
    }
};
