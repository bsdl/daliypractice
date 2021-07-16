#include <iostream>
#include <vector>

using namespace std;

struct Mice {
    int idx, weight, rank = -1;
}og[1000];

int np, ng;

int helper(vector<Mice> &v) {
    int rank;
    if (v.size() == 1) {
        rank = 1;
        for (Mice mice: v) {
            og[mice.idx].rank = rank;
        }
        return 1;
    } else {
        vector<Mice> winners;
        int size = v.size();
        Mice maxWeightMice = {-1, -1};
        for (int i = 0; i < size; i++) {
            if (maxWeightMice.weight < v[i].weight) {
                maxWeightMice = v[i];
            }
            if ((i + 1) % ng == 0 || i + 1 == size) {
                winners.push_back(maxWeightMice);
                maxWeightMice = {-1, -1};
            }
        }
        rank = helper(winners) + 1;
        int cnt = 0;
        for (Mice mice: v) {
            if (og[mice.idx].rank == -1) {
                cnt++;
                og[mice.idx].rank = rank;
            }
        }
        return rank + cnt - 1;
    }
}

int main() {
    cin>>np>>ng;
    for (int i = 0; i < np; i++) {
        int weight;
        scanf("%d", &weight);
        og[i].weight = weight;
        og[i].idx = i;
    }
    vector<Mice> v;
    for (int i = 0; i < np; i++) {
        int id;
        scanf("%d", &id);
        v.push_back(og[id]);
    }
    helper(v);
    for (int i = 0; i < np; i++) {
        printf("%d", og[i].rank);
        if (i < np - 1) {
            printf(" ");
        }
    }
    return 0;
}