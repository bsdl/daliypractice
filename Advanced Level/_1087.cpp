#include <iostream>
#include <map>
#include <vector>

#define INF 9999999
using namespace std;

int graph[200][200];
string names[200];
map<string, int> ids;
map<string, int> allHappiness;
int costs[200];
bool isVisited[200] = {false};

vector<int> pre[200];

vector<int> tmpPath;
vector<int> finalPath;
int maxHappiness = 0;
double maxAvgHappiness = 0;
int pathNum = 0;

void dfs(int v) {
    tmpPath.push_back(v);
    if (v == 0) {
        int total = 0;
        for (int id: tmpPath) {
            total += allHappiness[names[id]];
        }
        double avg = total * 1.0 / (tmpPath.size() - 1);
        if (total > maxHappiness) {
            maxHappiness = total;
            maxAvgHappiness = avg;
            finalPath = tmpPath;
        } else if (total == maxHappiness && avg > maxAvgHappiness) {
            maxAvgHappiness = avg;
            finalPath = tmpPath;
        }
        pathNum++;
    } else {
        for (int id: pre[v]) {
            dfs(id);
        }
    }
    tmpPath.pop_back();
}

int main() {
    int n, k;
    string start;
    cin >> n >> k >> start;
    ids[start] = 0;
    names[0] = start;
    for (int i = 0; i < n - 1; i++) {
        string city;
        int happiness;
        cin >> city >> happiness;
        allHappiness[city] = happiness;
        ids[city] = i + 1;
        names[i + 1] = city;
    }
    fill(graph[0], graph[0] + 200 * 200, INF);
    fill(costs, costs + 200, INF);
    for (int i = 0; i < k; i++) {
        string c1, c2;
        int cost;
        cin >> c1 >> c2 >> cost;
        int id1 = ids[c1], id2 = ids[c2];
        graph[id1][id2] = graph[id2][id1] = cost;
    }
    costs[0] = 0;
    for (int i = 0; i < n; i++) {
        int minn = INF;
        int u = -1;
        for (int j = 0; j < n; j++) {
            if (!isVisited[j] && costs[j] < minn) {
                minn = costs[j];
                u = j;
            }
        }
        if (u == -1) break;
        isVisited[u] = true;
        for (int v = 0; v < n; v++) {
            if (costs[v] > costs[u] + graph[u][v]) {
                costs[v] = costs[u] + graph[u][v];
                pre[v].clear();
                pre[v].push_back(u);
            } else if (costs[v] == costs[u] + graph[u][v]) {
                pre[v].push_back(u);
            }
        }
    }
    dfs(ids["ROM"]);
    printf("%d %d %d %d\n", pathNum, costs[ids["ROM"]], maxHappiness, (int) maxAvgHappiness);
    bool isFirst = true;
    int size = finalPath.size();
    for (int i = size - 1; i >= 0; i--) {
        string name = names[finalPath[i]];
        if (isFirst) {
            cout << name;
            isFirst = false;
        } else {
            cout << "->" << name;
        }
    }
    return 0;
}