#include <iostream>
#define INF 9999999
using namespace std;

int graph[500][500];
int rescueTeam[500];
int dist[500];
bool visited[500];

void init(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            graph[i][j] = (i == j) ? 0 : INF;
        }
    }
}

int main() {
    int n, m, start, end;
    cin >> n >> m >> start >> end;
    init(n);
    for (int i = 0; i < n; i++) {
        scanf("%d", rescueTeam + i);
    }
    for (int i = 0; i < m; i++) {
        int c1, c2, len;
        scanf("%d %d %d", &c1, &c2, &len);
        graph[c1][c2] = graph[c2][c1]  = len;
    }
    int pathNum[500] = {0};
    int curTeams[500] = {0};
    fill(dist, dist + 500, INF);
    dist[start] = 0;
    pathNum[start] = 1;
    curTeams[start] = rescueTeam[start];
    for (int i = 0; i < n; i++) {
        int min = INF;
        int u = -1;
        for (int j = 0; j < n; j++) {
            if (!visited[j] && dist[j] < min) {
                min = dist[j];
                u = j;
            }
        }
        if (u == -1) break;
        visited[u] = true;
        for (int v = 0; v < n; v++) {
            if (!visited[v] && graph[u][v] < INF) {
                if (dist[v] > dist[u] + graph[u][v]) {
                    pathNum[v] = pathNum[u];
                    dist[v] = dist[u] + graph[u][v];
                    curTeams[v] = curTeams[u] + rescueTeam[v];
                } else if (dist[v] == dist[u] + graph[u][v]) {
                    pathNum[v] += pathNum[u];
                    if (curTeams[v] < curTeams[u] + rescueTeam[v]) {
                        curTeams[v] = curTeams[u] + rescueTeam[v];
                    }
                }
            }
        }
    }
    printf("%d %d", pathNum[end], curTeams[end]);
    return 0;
}

