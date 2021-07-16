#include <iostream>
#include <algorithm>
#include <vector>
#include <map>
#include <set>

using namespace std;

struct Applicant {
    int id;
    int enScore;
    int fiScore;
    int rank = -1;
    vector<int> prefers;
    Applicant(int id, int en, int fi): id(id), enScore(en), fiScore(fi){}
};

bool comparator(Applicant a1, Applicant a2) {
    if (a1.fiScore != a2.fiScore) {
        return a1.fiScore > a2.fiScore;
    } else {
        return a1.enScore > a2.enScore;
    }
}

int main() {
    int n, m, k;
    cin >> n >> m >> k;
    map<int, int> quotas;
    vector<Applicant> apps;
    set<int> admits[400];
    for (int i = 0; i < m; i++) {
        int quota;
        scanf("%d", &quota);
        quotas[i] = quota;
    }
    for (int i = 0; i < n; i++) {
        int enScore, inScore;
        scanf("%d %d", &enScore, &inScore);
        int fiScore = (enScore + inScore) / 2;
        Applicant applicant(i, enScore, fiScore);
        for(int j = 0; j < k;j++) {
            int prefer;
            scanf("%d", &prefer);
            applicant.prefers.push_back(prefer);
        }
        apps.push_back(applicant);
    }
    sort(apps.begin(), apps.end(), comparator);
    for (int i = 0; i < n; i++) {
        if (i == 0) {
            apps[i].rank = 1;
        } else {
            if (apps[i].fiScore == apps[i - 1].fiScore &&
                apps[i].enScore == apps[i - 1].enScore) {
                apps[i].rank = apps[i - 1].rank;
            } else {
                apps[i].rank = i + 1;
            }
        }
    }
    for (int i = 0; i < n;) {
        bool flag[400] = {false};
        int rank = apps[i].rank;
        while (apps[i].rank == rank) {
            for (int j = 0; j < k; j++) {
                int gradId = apps[i].prefers[j];
                if (quotas[gradId] > 0 || (quotas[gradId] <= 0 && flag[gradId])) {
                    admits[gradId].insert(apps[i].id);
                    flag[gradId] = true;
                    quotas[gradId]--;
                    break;
                }
            }
            i++;
        }
    }
    for (int i = 0; i < m; i++) {
        int isFirst = true;
        for (int appId: admits[i]) {
            if (isFirst) {
                printf("%d", appId);
                isFirst = false;
            } else {
                printf(" %d", appId);
            }
        }
        puts("");
    }
    return 0;
}


