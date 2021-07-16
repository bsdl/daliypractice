#include <iostream>
#include <vector>
#include <cmath>

#define INF 9999999

using namespace std;

int graph[1020][1020];
int allDists[11][1020];

int main() {
    int n, m, k, ds;
    cin >> n >> m >> k >> ds;
    fill(graph[0], graph[0] + 1020 * 1020, INF);
    fill(allDists[0], allDists[0] + 11 * 1020, INF);
    for (int i = 0; i < k; i++) {
        string e1, e2;
        int dist;
        cin >> e1 >> e2 >> dist;
        int v1, v2;
        if (e1[0] == 'G') {
            if (e1.size() == 3) {
                v1 = n + 10;
            } else {
                v1 = n + e1[1] - '0';
            }
        } else {
            v1 = stoi(e1);
        }
        if (e2[0] == 'G') {
            if (e2.size() == 3) {
                v2 = n + 10;
            } else {
                v2 = n + e2[1] - '0';
            }
        } else {
            v2 = stoi(e2);
        }
        graph[v1][v2] = graph[v2][v1] = dist;
    }
    for (int g = 1; g <= m; g++) {
        bool isVisited[1020] = {false};
        allDists[g - 1][n + g] = 0;
        for (int i = 1; i <= n + m; i++) {
            int u = -1;
            int minn = INF;
            for (int j = 1; j <= n + m; j++) {
                if (!isVisited[j] && allDists[g - 1][j] < minn) {
                    minn = allDists[g - 1][j];
                    u = j;
                }
            }
            if (u == -1) break;
            isVisited[u] = true;
            for (int v = 1; v <= n + m; v++) {
                if (allDists[g - 1][v] > allDists[g - 1][u] + graph[u][v]) {
                    allDists[g - 1][v] = allDists[g - 1][u] + graph[u][v];
                }
            }
        }
    }
    int location = -1;
    double maxMinDist = -1;
    double finalAverageDist = -1;
    for (int i = 0; i < m; i++) {
        double sum = 0, minDist = INF;
        bool flag = true;
        for (int j = 1; j <= n; j++) {
            int dist = allDists[i][j];
            if (dist > ds || dist == INF) {
                flag = false;
                break;
            }
            minDist = minDist > dist ? dist : minDist;
            sum += dist;
        }
        if (flag) {
            if (minDist > maxMinDist) {
                maxMinDist = minDist;
                location = i + 1;
                finalAverageDist = sum * 1.0 / n;
            } else if (minDist == maxMinDist) {
                sum = sum * 1.0 / n;
                if (sum < finalAverageDist) {
                    location = i + 1;
                    finalAverageDist = sum;
                }
            }
        }
    }
    if (location == -1) {
        printf("No Solution");
        return 0;
    }
    printf("G%d\n", location);
    printf("%.1lf %.1lf", maxMinDist, finalAverageDist);
    return 0;
}