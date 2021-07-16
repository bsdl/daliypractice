#include <iostream>
#include <vector>
#include <map>
#include <set>

using namespace std;

map<int, vector<int>> graph;
set<int> deepestVertexSet;
bool isVisited[10002] = {false};
int tmpDepth = 0;
vector<int> tmpVec;

void dfs(int v, int depth) {
    isVisited[v] = true;
    if (depth > tmpDepth) {
        tmpDepth = depth;
        tmpVec.clear();
        tmpVec.push_back(v);
    } else if (depth == tmpDepth) {
        tmpVec.push_back(v);
    }
    int size = graph[v].size();
    for (int i = 0; i < size; i++) {
        if (!isVisited[graph[v][i]]) {
            dfs(graph[v][i], depth + 1);
        }
    }
}

int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n - 1; i++) {
        int v1, v2;
        scanf("%d %d", &v1, &v2);
        graph[v1].push_back(v2);
        graph[v2].push_back(v1);
    }
    int start = 0, component = 0;
    for (int v = 1; v <= n; v++) {
        if (!isVisited[v]) {
            dfs(v, 0);
            if (v == 1) {
                for (int i = 0; i < tmpVec.size(); i++) {
                    if (i == 0) {
                        start = tmpVec[i];
                    }
                    deepestVertexSet.insert(tmpVec[i]);
                }
            }
            component++;
        }
    }
    if (component > 1) {
        printf("Error: %d components", component);
    } else  {
        fill(isVisited, isVisited + n + 1, false);
        tmpDepth = 0;
        tmpVec.clear();
        dfs(start, 0);
        for (int leaf: tmpVec) {
            deepestVertexSet.insert(leaf);
        }
        for (auto &it: deepestVertexSet) {
            printf("%d\n", it);
        }
    }
    return 0;
}