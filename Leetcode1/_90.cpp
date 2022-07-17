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
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> ret;
        vector<int> subset;
        sort(nums.begin(), nums.end());
        helper(nums, 0, subset, ret);
        return ret;
    }

    void helper(vector<int> &nums, int start, vector<int> &subset, vector<vector<int>> &ret) {
        ret.push_back(subset);
        if (start == nums.size()) {
            return;
        }
        for (int i = start; (int) i < nums.size(); i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.push_back(nums[i]);
            helper(nums, start + 1, subset, ret);
            subset.pop_back();
        }
    }
};