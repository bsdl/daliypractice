#include <iostream>
#include <vector>
#include <map>

#define INF 0x3fffffff

using namespace std;

vector<int> subway[10000];
map<int, int> line;

int n, k, start, dest;
int minCnt, minTransfer;
vector<int> path, tmpPath;
bool visit[10000] = {false};

void dfs(int id, int cnt) {
    if (id == dest) {
        int transferTimes = 0;
        int preLine = line[tmpPath[0] * 10000 + tmpPath[1]];
        for (int i = 2; i < tmpPath.size(); i++) {
            int preId = tmpPath[i - 1], nextId = tmpPath[i];
            int curLine = line[preId * 10000 + nextId];
            if (curLine != preLine) {
                transferTimes++;
                preLine = curLine;
            }
        }
        if (cnt < minCnt) {
            path = tmpPath;
            minCnt = cnt;
            minTransfer = transferTimes;
        } else if (cnt == minCnt && transferTimes < minTransfer) {
            path = tmpPath;
            minTransfer = transferTimes;
        }
    } else {
        for (int next: subway[id]) {
            if (!visit[next]) {
                visit[next] = true;
                tmpPath.push_back(next);
                dfs(next, cnt + 1);
                tmpPath.pop_back();
                visit[next] = false;
            }
        }
    }
}

int main() {
    cin >> n;
    for (int i = 1; i <= n; i++) {
        int m, pre;
        scanf("%d %d", &m, &pre);
        for (int j = 1; j < m; j++) {
            int id;
            scanf("%d", &id);
            subway[pre].push_back(id);
            subway[id].push_back(pre);
            line[pre * 10000 + id] = line[id * 10000 + pre] = i;
            pre = id;
        }
    }
    cin >> k;
    for (int i = 0; i < k; i++) {
        minCnt = INF;
        minTransfer = INF;
        path.clear();
        tmpPath.clear();
        fill(visit, visit + 10000, false);
        scanf("%d %d", &start, &dest);
        visit[start] = true;
        tmpPath.push_back(start);
        dfs(start, 0);
        int size = path.size();
        printf("%d\n", size - 1);
        int preLine = line[path[0] * 10000 + path[1]];
        int startId = start;
        for (int j = 2; j < size; j++) {
            int preId = path[j - 1], curId = path[j];
            int curLine = line[preId * 10000 + curId];
            if (preLine != curLine) {
                printf("Take Line#%d from %04d to %04d.\n", preLine, startId, preId);
                startId = preId;
                preLine = curLine;
            }
        }
        printf("Take Line#%d from %04d to %04d.\n", preLine, startId, path[size - 1]);
    }
    return 0;
}

