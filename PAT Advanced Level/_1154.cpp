#include <iostream>
#include <set>
#include <map>
#include <vector>
#include <queue>

using namespace std;

int n, m, k;
map<int, vector<int>> graph;
vector<vector<int>> queries;

int main() {
    cin >> n >> m;
    bool occ[10000] = {false};
    for (int i = 0; i < m; i++) {
        int e1, e2;
        scanf("%d %d", &e1, &e2);
        graph[e1].push_back(e2);
        graph[e2].push_back(e1);
    }
    for (int i = 0; i < n; i++) {
        if (!occ[i]) {
            graph[i];
        }
    }
    cin >> k;
    for (int i = 0; i < k; i++) {
        vector<int> colors(n);
        for (int j = 0; j < n; j++) {
            scanf("%d", &colors[j]);
        }
        queries.push_back(colors);
    }
    for (int i = 0; i < k; i++) {
        set<int> s;
        bool flag = true;
        for (int j = 0; j < n; j++) {
            int color = queries[i][j];
            for (int id: graph[j]) {
                if (queries[i][id] == color) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                s.insert(color);
            } else {
                break;
            }
        }
        if (flag) {
            int size = s.size();
            printf("%d-coloring\n", size);
        } else {
            printf("No\n");
        }
    }
    return 0;
}
