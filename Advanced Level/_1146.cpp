#include <iostream>
#include <map>
#include <vector>

using namespace std;

map<int, vector<int>> graph;
int indegrees[1001] = {};

int main() {
    int n, m, k;
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        int start, end;
        scanf("%d %d", &start, &end);
        graph[start].push_back(end);
        indegrees[end]++;
    }
    cin >> k;
    bool isFirst = true;
    for (int i = 0; i < k; i++) {
        vector<int> tmp(indegrees, indegrees + n + 1);
        bool flag = true;
        for (int j = 0; j < n; j++) {
            int val;
            scanf("%d", &val);
            if (!flag) continue;
            if (tmp[val] == 0) {
                for (int v: graph[val]) {
                    tmp[v]--;
                }
            } else {
                flag = false;
            }
        }
        if (!flag) {
            if (isFirst) {
                printf("%d", i);
                isFirst = false;
            } else {
                printf(" %d", i);
            }
        }
    }
    return 0;
}