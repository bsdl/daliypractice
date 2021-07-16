//
// Created by bsdl on 2021/3/20.
//
#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <queue>
using namespace std;
class Solution {
public:

    // time out
//    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
//        vector<int> maxes;
//        int windowLeft = 0, windowRight = k- 1;
//        int lastMaxIndex = -1;
//
//        for (; windowRight < (int) nums.size(); windowLeft++, windowRight++) {
//            if (lastMaxIndex < windowLeft) {
//                int currMaxVal = INT32_MIN;
//                for (int i = windowLeft; i <= windowRight; i++) {
//                    if (currMaxVal < nums[i]) {
//                        currMaxVal = nums[i];
//                        lastMaxIndex = i;
//                    }
//                }
//            } else {
//                if (nums[lastMaxIndex] < nums[windowRight]) {
//                    lastMaxIndex = windowRight;
//                }
//            }
//            maxes.push_back(nums[lastMaxIndex]);
//        }
//        return maxes;
//    }

    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> maxes;
        deque<int> window;
        for (int i = 0; i < k;i ++) {
            while (!window.empty() && nums[window.back()] < nums[i]) {
                window.pop_back();
            }
            window.push_back(i);
        }
        maxes.push_back(nums[window.front()]);
        for (size_t i = k; i < nums.size(); i++) {
            if (!window.empty() && window.front() <= i - k) {
                window.pop_front();
            }
            while (!window.empty() && nums[window.back()] < nums[i]) {
                window.pop_back();
            }
            window.push_back(i);
            maxes.push_back(nums[window.front()]);
        }
        return maxes;
    }
};