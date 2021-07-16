#include <iostream>
#include <map>
#include <vector>

using namespace std;

map<int, vector<int>> graph;

int main() {
    int n, m, k;
    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        int v1, v2;
        scanf("%d %d", &v1, &v2);
        graph[v1].push_back(v2);
        graph[v2].push_back(v1);
    }
    cin >> k;
    for (int i = 0; i < k; i++) {
        int cnt;
        scanf("%d", &cnt);
        vector<int> query(cnt);
        for (int j = 0; j < cnt; j++) {
            scanf("%d", &query[j]);
        }
        bool isVisited[10000] = {false};
        int edgeNum = 0;
        for (int id: query) {
            for (int next: graph[id]) {
                if (!isVisited[next]) {
                    edgeNum++;
                }
            }
            isVisited[id] = true;
        }
        printf("%s\n", edgeNum == m ? "Yes" : "No");
    }
    return 0;
}
