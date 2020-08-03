//
// Created by bsdl on 2020/6/18.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

struct testee {
    long long int id;
    int score, finalRank, localRank, location;
};

bool comparator(testee t1, testee t2) {
    return t1.score == t2.score ? t1.id < t2.id : t1.score > t2.score;
}

int main() {
    int n;
    scanf("%d", &n);
    vector<testee> tol;
    for (int i = 0; i < n; i++) {
        int k;
        scanf("%d", &k);
        vector<testee> list;
        for (int j = 0; j < k; j++) {
            long long int id;
            int score;
            scanf("%lld %d", &id, &score);
            testee t;
            t.score = score;
            t.id = id;
            t.location = i + 1;
            list.push_back(t);
        }
        sort(list.begin(), list.end(), comparator);
        list[0].localRank = 1;
        tol.push_back(list[0]);
        for (int r = 1; r < list.size(); r++) {
            list[r].localRank = list[r].score == list[r - 1].score ?
                                list[r - 1].localRank : r + 1;
            tol.push_back(list[r]);
        }
    }
    sort(tol.begin(), tol.end(), comparator);
    printf("%d\n", tol.size());
    tol[0].finalRank = 1;
    printf("%013lld %d %d %d\n", tol[0].id, tol[0].finalRank, tol[0].location, tol[0].localRank);

    for (int i = 1; i < tol.size(); i++) {
        int finalRank = tol[i].score == tol[i - 1].score ?
                        tol[i - 1].finalRank : i + 1;
        tol[i].finalRank = finalRank;
        printf("%013lld %d %d %d\n", tol[i].id, tol[i].finalRank, tol[i].location, tol[i].localRank);
    }
    return 0;
}