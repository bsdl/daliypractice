#include <iostream>
#include <map>
#include <vector>
#include <cmath>

using namespace std;

map<int, vector<int>> m;
int maxDepth = 0, total = 0;

void dfs(int root, int depth) {
    if (m[root].empty()) {
        if (depth > maxDepth) {
            maxDepth = depth;
            total = 1;
        } else if (depth == maxDepth) {
            total++;
        }
        return;
    }
    for (int member: m[root]) {
        dfs(member, depth + 1);
    }
}

int main() {
    int n;
    double p, r;
    cin >> n >> p >> r;
    for (int i = 0; i < n; i++) {
        int sId;
        scanf("%d", &sId);
        m[sId].push_back(i);
    }
    dfs(-1, 0);
    double increment = 1 + r / 100;
    double finalPrice = p * pow(increment, maxDepth - 1);
    printf("%.2lf %d", finalPrice, total);
    return 0;
}