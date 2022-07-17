//
// Created by bsdl on 2021/4/24.
//
#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
#include <queue>
#include <stack>
using namespace std;

bool cmp(vector<int> v1, vector<int> v2) {
    if (v1[0] == v2[0]) {
        return v1[1] < v2[1];
    }
    return v1[0] < v2[0];
}



vector<vector<int>> merge(vector<vector<int>>& intervals) {
    sort(intervals.begin(), intervals.end(), cmp);
    vector<vector<int>> ret;
    ret.push_back(intervals[0]);
    for (int i = 1; (int)i < intervals.size(); i++) {
        int size = ret.size();
        if (intervals[i][0] <= ret[size - 1][1]) {
            ret[size - 1] = {ret[size - 1][0], intervals[i][1]};
        } else {
            ret.push_back(intervals[i]);
        }
    }
    return ret;
}

int main() {
    vector<vector<int>> intervals{{1,3}, {2, 6}, {8, 10}, {15, 18}};
    merge(intervals);
}