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
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> inDegrees(numCourses);
        vector<vector<int>> graph(numCourses);
        for (vector<int> pair: prerequisites) {
            inDegrees[pair[1]]++;
            graph[pair[0]].push_back(pair[1]);
        }
        queue<int> que;
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                que.push(i);
            }
        }
        int count = 0;
        while (!que.empty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int courseNum = que.front(); que.pop();
                count++;
                for (int cNum: graph[courseNum]) {
                    if (--inDegrees[cNum] == 0) {
                        que.push(cNum);
                    }
                }
            }
        }
        return count == numCourses;
    }
};