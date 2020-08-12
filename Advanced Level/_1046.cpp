#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n, k;
    scanf("%d", &n);
    vector<int> path(n + 1);
    int total = 0;
    for (int i = 1; i <= n; i++) {
        scanf("%d", &path[i]);
        total += path[i];
    }
    vector<int> front(n + 1, 0);
    front[1] = 0;
    for (int i = 1; i <= n; i++) {
        front[i + 1] += front[i] + path[i];
    }
    scanf("%d", &k);
    while (k > 0) {
        k--;
        int start, end;
        scanf("%d %d", &start, &end);
        int dist = abs(front[start] - front[end]);
        printf("%d\n", dist > total - dist ? total - dist : dist);
    }
    return 0;
}
