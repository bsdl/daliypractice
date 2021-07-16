#include <iostream>
#include <vector>

using namespace std;
int graph[210][210];

int main() {
    int nv, ne, m;
    cin >> nv >> ne;
    fill(graph[0], graph[0] + 201 * 210, 0);
    for (int i = 0; i < ne; i++) {
        int a, b;
        scanf("%d %d", &a, &b);
        graph[a][b] = graph[b][a] = 1;
    }
    cin >> m;
    for (int i = 0; i < m; i++) {
        int k;
        scanf("%d", &k);
        vector<int> v(k);
        bool hash[210] = {false};
        for (int j = 0; j < k; j++) {
            scanf("%d", &v[j]);
            hash[v[j]] = true;
        }
        bool isClique = true, isMaximal = true;
        for (int j = 0; j < k - 1; j++) {
            if (!isClique) break;
            for (int l = j + 1; l < k; l++) {
                if (graph[v[j]][v[l]] == 0) {
                    isClique = false;
                    puts("Not a Clique");
                    break;
                }
            }
        }
        if (!isClique) continue;
        for (int j = 1; j <= nv; j++) {
            if (!hash[j]) {
                for (int l = 0; l < k; l++) {
                    if (graph[j][v[l]] == 0) break;
                    if (l == k - 1) isMaximal = false;
                }
            }
        }
        printf("%s\n", isMaximal ? "Yes" : "Not Maximal");
    }
    return 0;
}
