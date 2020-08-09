#include <iostream>

#define INF 5000

using namespace std;

struct Info {
    int dist, cost;
} graph[500][500];

int n, m, s, d;
int dists[500];
int costs[500];
int isVisited[500];
int pre[500];

void init(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i == j) {
                graph[i][j] = {0, 0};
            } else {
                graph[i][j] = {5000, 5000};
            }
        }
    }
}

void print(int vertex) {
    if (vertex == s) {
        return;
    }
    print(pre[vertex]);
    printf(" %d", vertex);
}

int main() {

    cin >> n >> m >> s >> d;
    init(n);
    for (int i = 0; i < m; i++) {
        int c1, c2, dist, cost;
        scanf("%d%d%d%d", &c1, &c2, &dist, &cost);
        graph[c1][c2].dist = graph[c2][c1].dist = dist;
        graph[c1][c2].cost = graph[c2][c1].cost = cost;
    }
    fill(dists, dists + 500, INF);
    fill(costs, costs + 500, INF);
    dists[s] = 0;
    costs[s] = 0;
    for (int i = 0; i < n; i++) {
        int min = INF;
        int u = -1;
        for (int j = 0; j < n; j++) {
            if (!isVisited[j] && dists[j] < min) {
                min = dists[j];
                u = j;
            }
        }
        if (u == -1) break;
        isVisited[u] = true;
        for (int v = 0; v < n; v++) {
            if (dists[v] > dists[u] + graph[u][v].dist) {
                dists[v] = dists[u] + graph[u][v].dist;
                costs[v] = costs[u] + graph[u][v].cost;
                pre[v] = u;
            } else if (dists[v] == dists[u] + graph[u][v].dist
                        && costs[v] > costs[u] + graph[u][v].cost) {
                costs[v] = costs[u] + graph[u][v].cost;
                pre[v] = u;
            }
        }
    }
    printf("%d", s);
    print(d);
    printf(" %d %d", dists[d], costs[d]);
    return 0;
}

