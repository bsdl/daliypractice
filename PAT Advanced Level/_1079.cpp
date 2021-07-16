#include <iostream>
#include <cmath>
#include <map>
#include <vector>

using namespace std;

map<int, vector<int>> chain;
map<int, int> amounts;
double total = 0;
int n;
double p, r;
double increment;

void dfs(int member, int depth) {
    if (chain[member].empty()) {
        int amount = amounts[member];
        double price = p * pow(increment, depth);
        total += price * amount;
        return;
    }
    for (int id: chain[member]){
        dfs(id, depth + 1);
    }
}

int main() {
    cin >> n >> p >> r;
    increment = 1 + r / 100;
    for (int i = 0; i < n;i++) {
        int cnt;
        scanf("%d", &cnt);
        if (cnt == 0) {
            int amount;
            scanf("%d", &amount);
            amounts[i] = amount;
        }
        for(int j = 0; j < cnt; j++) {
            int id;
            scanf("%d", &id);
            chain[i].push_back(id);
        }
    }
    dfs(0, 0);
    printf("%.1lf", total);
    return 0;
}

