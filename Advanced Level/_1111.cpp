#include <iostream>
#include <vector>

#define INF 0x3fffffff

using namespace std;

struct Info {
    int length = INF, time = INF;
} graph[500][500];
int n, m, source, destination;
int dist[500];
int times[500];
bool isVisited[500] = {false};
vector<int> preLength[500];
vector<int> preTime[500];
vector<int> shortestPath;
vector<int> fastestPath;
vector<int> tmpPath;
int shortest = INF;
int fastest = INF;
int intersectionNum = INF;

void dfsLength(int v) {
    tmpPath.push_back(v);
    if (v == source) {
        int size = tmpPath.size();
        int distance = 0, time = 0;
        for (int i = 0; i < size - 1; i++) {
            int v1 = tmpPath[i], v2 = tmpPath[i + 1];
            distance += graph[v2][v1].length;
            time += graph[v2][v1].time;
        }
        if (distance < shortest) {
            shortestPath = tmpPath;
            shortest = distance;
            fastest = time;
        } else if (distance == shortest && time < fastest) {
            shortestPath = tmpPath;
            fastest = time;
        }
    } else {
        for (int id : preLength[v]) {
            dfsLength(id);
        }
    }
    tmpPath.pop_back();
}


void dfsTime(int v) {
    tmpPath.push_back(v);
    if (v == source) {
        int size = tmpPath.size();
        int time = 0;
        for (int i = 0; i < size - 1; i++) {
            int v1 = tmpPath[i], v2 = tmpPath[i + 1];
            time += graph[v2][v1].time;
        }
        if (time < fastest) {
            fastest = time;
            fastestPath = tmpPath;
            intersectionNum = size;
        } else if (time == fastest && size < intersectionNum) {
            fastestPath = tmpPath;
            intersectionNum = size;
        }
    } else {
        for (int id: preTime[v]) {
            dfsTime(id);
        }
    }
    tmpPath.pop_back();
}

int main() {

    scanf("%d %d", &n, &m);
    for (int i = 0; i < m; i++) {
        int v1, v2, oneWay, length, time;
        scanf("%d %d %d %d %d", &v1, &v2, &oneWay, &length, &time);
        graph[v1][v2].length = length;
        graph[v1][v2].time = time;
        if (oneWay == 0) {
            graph[v2][v1].length = length;
            graph[v2][v1].time = time;
        }
    }
    scanf("%d %d", &source, &destination);
    fill(dist, dist + 500, INF);
    dist[source] = 0;
    for (int i = 0; i < n; i++) {
        int u = -1;
        int minn = INF;
        for (int j = 0; j < n; j++) {
            if (!isVisited[j] && dist[j] < minn) {
                minn = dist[j];
                u = j;
            }
        }
        if (u == -1) break;
        isVisited[u] = true;
        for (int v = 0; v < n; v++) {
            if (dist[v] > dist[u] + graph[u][v].length) {
                dist[v] = dist[u] + graph[u][v].length;
                preLength[v].clear();
                preLength[v].push_back(u);
            } else if (dist[v] == dist[u] + graph[u][v].length) {
                preLength[v].push_back(u);
            }
        }
    }
    dfsLength(destination);
    fill(times, times + 500, INF);
    fill(isVisited, isVisited + 500, false);
    times[source] = 0;
    for (int i = 0; i < n; i++) {
        int u = -1;
        int minn = INF;
        for (int j = 0; j < n; j++) {
            if (!isVisited[j] && times[j] < minn) {
                minn = times[j];
                u = j;
            }
        }
        if (u == -1) break;
        isVisited[u] = true;
        for (int v = 0; v < n; v++) {
            if (times[v] > times[u] + graph[u][v].time) {
                times[v] = times[u] + graph[u][v].time;
                preTime[v].clear();
                preTime[v].push_back(u);
            } else if (times[v] == times[u] + graph[u][v].time) {
                preTime[v].push_back(u);
            }
        }
    }
    tmpPath.clear();
    fastest = INF;
    dfsTime(destination);
    int isSame = true;
    if (shortestPath.size() != fastestPath.size()) {
        isSame = false;
    }
    if (isSame) {
        for (int i = 0; i < shortestPath.size(); i++) {
            if (shortestPath[i] != fastestPath[i]) {
                isSame = false;
                break;
            }
        }
    }
    if (isSame) {
        printf("Distance = %d; Time = %d: ", shortest, fastest);
        int size = shortestPath.size();
        for (int i = size - 1; i >= 0; i--) {
            printf("%d", shortestPath[i]);
            if (i > 0) {
                printf(" -> ");
            }
        }
    } else {
        printf("Distance = %d: ", shortest);
        int size = shortestPath.size();
        for (int i = size - 1; i >= 0; i--) {
            printf("%d", shortestPath[i]);
            if (i > 0) {
                printf(" -> ");
            }
        }
        puts("");
        printf("Time = %d: ", fastest);
        size = fastestPath.size();
        for (int i = size - 1; i >= 0; i--) {
            printf("%d", fastestPath[i]);
            if (i > 0) {
                printf(" -> ");
            }
        }
    }
    return 0;
}
