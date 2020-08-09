#include <iostream>
#include <map>
#include <vector>

using namespace std;

int isVisited[1001] = {false};
map<int, vector<int>> graph;

void dfs(int v) {
    isVisited[v] = true;
    int size = graph[v].size();
    for (int i = 0; i < size; i++) {
        if (!isVisited[graph[v][i]]) {
            dfs(graph[v][i]);
        }
    }
}

int main() {
    int n, m, k;
    cin >> n >> m >> k;
    for (int i = 0; i < m; i++) {
        int c1, c2;
        scanf("%d %d", &c1, &c2);
        graph[c1].push_back(c2);
        graph[c2].push_back(c1);
    }
    for (int i = 0; i < k; i++) {
        int occupied;
        scanf("%d", &occupied);
        isVisited[occupied] = true;
        int component = 0;
        for (int v = 1; v <= n; v++) {
            if (!isVisited[v]) {
                dfs(v);
                component++;
            }
        }
        fill(isVisited, isVisited + 1001, false);
        printf("%d\n", component == 0 ? 0 : component - 1);
    }
    return 0;
}

