#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Node {
    vector<int> children;
} tree[120];

int main() {
    int n, m;
    scanf("%d %d", &n, &m);
    for (int i = 0; i < m; i++) {
        int parent, cnt;
        scanf("%d %d", &parent, &cnt);
        for (int j = 0; j < cnt; j++) {
            int child;
            scanf("%d", &child);
            tree[parent].children.push_back(child);
        }
    }
    queue<int> que;
    que.push(1);
    int maxSize = 0;
    int maxDepth = 0;
    int size = 1;
    int depth = 1;
    while (!que.empty()) {
        if (size > maxSize) {
            maxSize = size;
            maxDepth = depth;
        }
        while (size > 0) {
            int node = que.front();
            que.pop();
            for (int child: tree[node].children) {
                que.push(child);
            }
            size--;
        }
        size = que.size();
        depth++;
    }
    printf("%d %d", maxSize, maxDepth);
    return 0;
}