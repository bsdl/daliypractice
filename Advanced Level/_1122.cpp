#include <iostream>
#include <vector>
#include <set>

using namespace std;

int graph[210][210];

int main() {
    int n, m, k;
    cin >> n >> m;
    fill(graph[0], graph[0] + 210 * 210, 0);
    for (int i = 0; i < m; i++) {
        int a, b;
        scanf("%d %d", &a, &b);
        graph[a][b] = graph[b][a] = 1;
    }
    cin >> k;
    for (int i = 0; i < k; i++) {
        bool flag = true;
        int cnt;
        scanf("%d", &cnt);
        vector<int> candi;
        set<int> unique;
        for (int i = 0; i < cnt; i++) {
            int id;
            scanf("%d", &id);
            candi.push_back(id);
            unique.insert(id);
        }
        if (unique.size() != n || cnt != n + 1 || candi[0] != candi[cnt - 1]) {
            flag = false;
        }
        for (int j = 0; j < cnt - 1; j++) {
            if (graph[candi[j]][candi[j + 1]] == 0) {
                flag = false;
            }
        }
        printf("%s\n", flag ? "YES" : "NO");
    }
    return 0;
}
