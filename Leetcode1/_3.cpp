//
// Created by bsdl on 2021/3/20.
//
#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

using namespace std;

class Solution {
public:

    int lengthOfLongestSubstring(string s) {
        int left = 0, right = 0;
        int maxLen = 0;
        set<char> appeared;
        while (right < (int) s.length()) {
            if (appeared.count(s[right]) == 0) {
                maxLen = max(maxLen, right - left + 1);
                appeared.insert(s[right++]);
            } else {
                appeared.erase(s[left++]);
            }
        }
        return maxLen;
    }
};