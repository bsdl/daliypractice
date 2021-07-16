#include <iostream>
#include <vector>
#include <set>

using namespace std;

int parent[10010];

int findParent(int root) {
    int son = root, tmp;
    while (parent[root] != root) {
        root = parent[root];
    }
    while (son != root) {
        tmp = parent[son];
        parent[son] = root;
        son = tmp;
    }
    return root;
}

void join(int root1, int root2) {
    int x, y;
    x = findParent(root1);
    y = findParent(root2);
    if (x != y) {
        parent[x] = y;
    }
}

int main() {
    for (int i = 0; i < 10010; i++) {
        parent[i] = i;
    }
    int n, k;
    int maxId = 0;
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        int cnt;
        scanf("%d", &cnt);
        int lastId = -1;
        for (int j = 0; j < cnt; j++) {
            int id;
            scanf("%d", &id);
            maxId = max(maxId, id);
            if (j == 0) {
                lastId = id;
            } else {
                join(id, lastId);
                lastId = id;
            }
        }
    }
    set<int> trees;
    for (int i = 1; i <= maxId; i++) {
        trees.insert(findParent(i));
    }
    printf("%d %d\n", trees.size(), maxId);
    cin >> k;
    for (int i = 0; i < k; i++) {
        int b1, b2;
        scanf("%d %d", &b1, &b2);
        printf("%s\n", parent[b1] == parent[b2] ? "Yes" : "No");
    }
    return 0;
}
