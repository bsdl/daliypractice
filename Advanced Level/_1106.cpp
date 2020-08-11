#include <iostream>
#include <map>
#include <vector>
#include <cmath>

using namespace std;
map<int, vector<int>> m;
int minDepth = INT32_MAX, total = 0;

void dfs(int member, int depth) {
    if (m[member].empty()) {
        if (depth < minDepth) {
            total = 1;
            minDepth = depth;
        } else if (depth == minDepth) {
            total++;
        }
    }
    for (int id: m[member]) {
        dfs(id, depth + 1);
    }
}

int main() {
    int n;
    double p, r;
    cin >> n>> p>>r;
    for (int i = 0; i < n; i++) {
        int cnt;
        scanf("%d", &cnt);
        while (cnt > 0) {
            int id;
            scanf("%d", &id);
            m[i].push_back(id);
            cnt--;
        }
    }
    dfs(0, 0);
    double increment = 1 + r / 100;
    double minPrice = p * pow(increment, minDepth);
    printf("%.4lf %d", minPrice, total);
    return 0;
}