#include <iostream>
#include <vector>

#define INF 99999999

using namespace std;

int graph[510][510];
int hours[510];
int bikes[510] = {0};
bool isVisited[510] = {false};
vector<int> pre[510], finalPath, tmpPath;
int minNeed = INF, minBack = INF;

void init(int n) {
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= n; j++) {
            graph[i][j] = i == j ? 0 : INF;
        }
    }
}

void dfs(int v) {
    tmpPath.push_back(v);
    if (v == 0) {
        int need = 0, back = 0;
        int size = tmpPath.size();
        for (int i = size - 1; i >= 0; i--) {
            int sId = tmpPath[i];
            if (bikes[sId] > 0) {
                back += bikes[sId];
            } else {
                if (back > (0 - bikes[sId])) {
                    back += bikes[sId];
                } else {
                    need += ((-bikes[sId]) - back);
                    back = 0;
                }
            }
        }
        if (need < minNeed) {
            minNeed = need;
            minBack = back;
            finalPath = tmpPath;
        } else if (need == minNeed && back < minBack) {
            minBack = back;
            finalPath = tmpPath;
        }
        tmpPath.pop_back();
        return;
    }
    int size = pre[v].size();
    for (int i = 0; i < size; ++i) {
        dfs(pre[v][i]);
    }
    tmpPath.pop_back();
}

int main() {
    int cmax, n, sp, m;
    cin >> cmax >> n >> sp >> m;
    init(n);
    for (int i = 1; i <= n; i++) {
        scanf("%d", bikes + i);
        bikes[i] -= cmax / 2;
    }
    for (int i = 0; i < m; i++) {
        int s1, s2, hour;
        scanf("%d %d %d", &s1, &s2, &hour);
        graph[s1][s2] = graph[s2][s1] = hour;
    }
    fill(hours, hours + 510, INF);
    hours[0] = 0;
    for (int i = 0; i <= n; i++) {
        int u = -1;
        int min = INF;
        for (int j = 0; j <= n; j++) {
            if (!isVisited[j] && hours[j] < min) {
                min = hours[j];
                u = j;
            }
        }
        if (u == -1) break;
        isVisited[u] = true;
        for (int v = 0; v <= n; v++) {
            if (!isVisited[v] && graph[u][v] != INF) {
                if (hours[v] > hours[u] + graph[u][v]) {
                    hours[v] = hours[u] + graph[u][v];
                    pre[v].clear();
                    pre[v].push_back(u);
                } else if (hours[v] == hours[u] + graph[u][v]) {
                    pre[v].push_back(u);
                }
            }
        }
    }
    dfs(sp);
    printf("%d 0", minNeed);
    int size = finalPath.size();
    for (int i = size - 2; i >= 0; i--) {
        printf("->%d", finalPath[i]);
    }
    printf(" %d", minBack);
    return 0;
}