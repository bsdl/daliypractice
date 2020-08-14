#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, m, s;
struct Node {
    int weight;
    vector<int> kids;
} tree[110];
vector<int> path;

void dfs(int id, int sum) {
    path.push_back(id);
    sum += tree[id].weight;
    if (tree[id].kids.empty() && sum == s) {
        int size = path.size();
        for (int i = 0; i < size; i++) {
            printf("%d", tree[path[i]].weight);
            printf("%s", i < size - 1 ? " " : "\n");
        }
    } else {
        for (int kid: tree[id].kids) {
            dfs(kid, sum);
        }
    }
    path.pop_back();
}

bool comparator(int id1, int id2) {
    return tree[id1].weight > tree[id2].weight;
}

int main() {
    cin >> n >> m >> s;
    for (int i = 0; i < n; i++) {
        scanf("%d", &tree[i].weight);
    }
    for (int i = 0; i < m; i++) {
        int id, size;
        scanf("%d %d", &id, &size);
        while (size > 0) {
            int kid;
            scanf("%d", &kid);
            tree[id].kids.push_back(kid);
            size--;
        }
        sort(tree[id].kids.begin(), tree[id].kids.end(), comparator);
    }
    dfs(0, 0);
    return 0;
}