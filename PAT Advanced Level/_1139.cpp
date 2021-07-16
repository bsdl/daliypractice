#include <iostream>
#include <unordered_map>
#include <vector>
#include <algorithm>

using namespace std;

struct Result {
    int a, b;
};

bool cmp(Result r1, Result r2) {
    if (r1.a == r2.a) {
        return r1.b < r2.b;
    }
    return r1.a < r2.a;
}

unordered_map<int, bool> hasPath;

int main() {
    int n, m, k;
    cin >> n >> m;
    vector<int> v[10000];
    for (int i = 0; i < m; i++) {
        string id1, id2;
        cin >> id1 >> id2;
        int a = abs(stoi(id1)), b = abs(stoi(id2));
        if (id1.length() == id2.length()) {
            v[a].push_back(b);
            v[b].push_back(a);
        }
        hasPath[a * 10000 + b] = hasPath[b * 10000 + a] = true;
    }
    cin >> k;
    for (int i = 0; i < k; i++) {
        string id1, id2;
        cin >> id1 >> id2;
        vector<Result> result;
        int a = abs(stoi(id1)), b = abs(stoi(id2));
        for (int j = 0; j < v[a].size(); j++) {
            for (int l = 0; l < v[b].size(); l++) {
                if (v[a][j] == b || v[b][l] == a) continue;
                if (hasPath[v[a][j] * 10000 + v[b][l]]) {
                    result.push_back({v[a][j], v[b][l]});
                }
            }
        }
        sort(result.begin(), result.end(), cmp);
        printf("%d\n", result.size());
        for (Result res: result) {
            printf("%04d %04d\n", res.a, res.b);
        }
    }
    return 0;
}