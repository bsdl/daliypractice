//
// Created by bsdl on 2021/3/22.
//
#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <queue>
#include <stack>
#include <map>
using namespace std;
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        map<int, int> m;
        priority_queue<pair<int, int>, vector<pair<int, int>>, cmp> pq;
        for (int num: nums) {
            m[num]++;
        }
        for (auto it: m) {
            pq.push(it);
        }
        vector<int> ret;
        while (k--) {
            ret.push_back(pq.top().first);
            pq.pop();
        }
        return ret;
    }

    struct cmp {
        bool operator()(const pair<int, int> &p1, const pair<int, int> &p2) {
            return p1.second < p2.second;
        }
    };

};