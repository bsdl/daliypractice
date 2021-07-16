//
// Created by bsdl on 2021/3/22.
//
#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <queue>
#include <stack>
using namespace std;
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<>> pq;
        for (auto num: nums) {
            if (pq.size() == k && pq.top() >= num) {
                continue;
            }
            if (pq.size() == k) {
                pq.pop();
            }
            pq.push(num);
        }
        return pq.top();
    }
};