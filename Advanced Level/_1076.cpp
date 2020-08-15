#include <iostream>
#include <queue>
#include <map>
#include <vector>

using namespace std;

map<int, vector<int>> graph;

int main() {
    int n, l, k;
    cin >> n >> l;
    for (int i = 1; i <= n; i++) {
        int size;
        scanf("%d", &size);
        for (int j = 0; j < size; j++) {
            int id;
            scanf("%d", &id);
            graph[id].push_back(i);
        }
    }
    cin >> k;
    while (k > 0) {
        int query;
        scanf("%d", &query);
        int cnt = 0, idx = 0;
        queue<int> que;
        bool isVisited[1020] = {false};
        que.push(query);
        isVisited[query] = true;
        int size = 1;
        while (!que.empty()) {
            while (size > 0) {
                int id = que.front();
                que.pop();
                for (int follower: graph[id]) {
                    if (!isVisited[follower]) {
                        isVisited[follower] = true;
                        que.push(follower);
                        cnt++;
                    }
                }
                size--;
            }
            idx++;
            if (idx == l) {
                break;
            }
            size = que.size();
        }
        printf("%d\n", cnt);
        k--;
    }
    return 0;
}