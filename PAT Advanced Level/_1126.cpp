#include <iostream>
#include <map>
#include <vector>

using namespace std;

map<int, vector<int>> graph;
bool isVisited[510] = {false};

void dfs(int v) {
    if (isVisited[v]) {
        return;
    }
    isVisited[v] = true;
    for (int id: graph[v]) {
        dfs(id);
    }
}


int main() {
    int n, m;
    cin >> n >> m;
    bool occ[510] = {false};
    for (int i = 0; i < m; i++) {
        int a, b;
        scanf("%d %d", &a, &b);
        graph[a].push_back(b);
        graph[b].push_back(a);
        occ[a] = occ[b] = true;
    }
    for (int i = 1; i <= n; i++) {
        if (!occ[i]) {
            graph[i];
        }
    }
    bool isCircuit = true;
    int oddNum = 0;

    int component = 0;
    for (int i = 1; i <= n; i++) {
        int degree = graph[i].size();
        if (degree % 2 != 0) {
            oddNum++;
            isCircuit = false;
        }
        printf("%d", degree);
        if (i == n) {
            printf("\n");
        } else {
            printf(" ");
        }
        if (!isVisited[i]) {
            dfs(i);
            component++;
        }
    }

    if (component == 1) {
        if (isCircuit) {
            printf("Eulerian");
        } else if (oddNum == 2) {
            printf("Semi-Eulerian");
        } else {
            printf("Non-Eulerian");
        }
    } else {
        printf("Non-Eulerian");
    }
    return 0;
}