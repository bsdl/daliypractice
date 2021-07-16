#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int parents[1010];

bool comp(int a, int b) {
    return a > b;
}

int findParent(int parent) {
    int son, tmp;
    son = parent;
    while (parent != parents[parent]) {
        parent = parents[parent];
    }
    while (son != parent) {
        tmp = parents[son];
        parents[son] = parent;
        son = tmp;
    }
    return parent;
}

void join(int root1, int root2) {
    int x, y;
    x = findParent(root1);
    y = findParent(root2);
    if (x != y) {
        parents[x] = y;
    }
}

int main() {
    int n;
    cin >> n;
    int hobbies[1010] = {0};
    for (int i = 1; i <= n; i++) {
        parents[i] = i;
    }
    for (int i = 1; i <= n; i++) {
        int cnt;
        scanf("%d:", &cnt);
        for (int j = 0 ; j < cnt; j++) {
            int hobby;
            scanf("%d", &hobby);
            if (hobbies[hobby] == 0) {
                hobbies[hobby] = i;
            }
            join(i, findParent(hobbies[hobby]));
        }
    }
    vector<int> isRoot(n + 1);
    for (int i = 1; i <= n; i++) {
        isRoot[findParent(i)]++;
    }
    int cnt = 0;
    for (int i = 1; i <= n; i++) {
        if (isRoot[i] != 0) {
            cnt++;
        }
    }
    printf("%d\n", cnt);
    sort(isRoot.begin(), isRoot.end(), comp);
    for (int i = 0; i < cnt; i++) {
        printf("%d", isRoot[i]);
        if (i != cnt - 1) printf(" ");
    }
    return 0;
}
