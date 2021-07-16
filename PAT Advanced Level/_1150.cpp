#include <iostream>
#include <map>
#include <vector>
#include <set>

using namespace std;

int graph[210][210];
int minDist = INT32_MAX, index = -1;

int main() {
    int n, m, k;
    cin >> n >> m;
    fill(graph[0], graph[0] + 201 * 210, -1);
    for (int i = 0; i < m; i++) {
        int c1, c2, dist;
        scanf("%d %d %d", &c1, &c2, &dist);
        graph[c1][c2] = graph[c2][c1] = dist;
    }
    cin >> k;
    for (int i = 1; i <= k;i++) {
        int cnt;
        scanf("%d", &cnt);
        bool isSimple = true, isCycle = true;
        int dist= 0;
        vector<int> path;
        set<int> unique;
        for (int j = 0; j < cnt; j++) {
            int id;
            scanf("%d", &id);
            path.push_back(id);
            unique.insert(id);
        }
        if (unique.size() != n || cnt < n + 1 || path[0] != path[cnt - 1]) {
            isCycle = false;
        }
        if (cnt > n + 1) {
            isSimple = false;
        }
        for (int j = 0; j < cnt - 1; j++) {
            if (graph[path[j]][path[j + 1]] != -1) {
                dist += graph[path[j]][path[j + 1]];
            } else {
                isCycle = false;
                dist = -1;
                break;
            }
        }
        if (dist != -1 && !isCycle) {
            printf("Path %d: %d (Not a TS cycle)\n", i, dist);
        } else if (dist != -1 && !isSimple) {
            printf("Path %d: %d (TS cycle)\n", i, dist);
        } else if (dist != -1) {
            printf("Path %d: %d (TS simple cycle)\n", i, dist);
        } else {
            printf("Path %d: NA (Not a TS cycle)\n", i);
        }
        if (isCycle && dist < minDist) {
            minDist = dist;
            index = i;
        }
    }
    printf("Shortest Dist(%d) = %d\n", index, minDist);
    return 0;
}
