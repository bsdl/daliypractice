#include <iostream>
#include <set>
#include <string>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

struct Testee {
    char level;
    int site;
    int date;
    string id;
    int score;
};


struct Type2 {
    int cnt;
    int total;
} scoreOfSite[10001];


struct Type3 {
    int site;
    int times;

    Type3(int a, int b) : site(a), times(b) {}

    bool operator<(const Type3 &type3) const {
        return times != type3.times ? times > type3.times : site < type3.site;
    }
};

bool comparator(Testee t1, Testee t2) {
    return (t1.score != t2.score) ? t1.score > t2.score : t1.id < t2.id;
}


int main() {
    int n, m;
    cin >> n >> m;
    vector<Testee> testees;
    map<int, map<int, int>> type3OfDate;
    for (int i = 0; i < n; i++) {
        string id;
        int score;
        cin >> id >> score;
        char level = id[0];
        int site = stoi(id.substr(1, 3));
        int date = stoi(id.substr(4, 6));
        testees.push_back({level, site, date, id, score});
        scoreOfSite[site].total += score;
        scoreOfSite[site].cnt++;
        type3OfDate[date][site]++;
    }
    int isSorted = false;
    for (int i = 1; i <= m; i++) {
        int type;
        scanf("%d", &type);
        if (type == 1) {
            char level;
            scanf(" %c", &level);
            printf("Case %d: %d %c\n", i, type, level);
            if (!isSorted) {
                sort(testees.begin(), testees.end(), comparator);
                isSorted = true;
            }
            int cnt = 0;
            for (Testee t : testees) {
                if (t.level == level) {
                    cout << t.id << " " << t.score << endl;
                    cnt++;
                }
            }
            if (cnt == 0) {
                puts("NA");
            }
        } else if (type == 2) {
            int site;
            scanf("%d", &site);
            printf("Case %d: %d %03d\n", i, type, site);
            if (scoreOfSite[site].cnt == 0) {
                puts("NA");
            } else {
                printf("%d %d\n", scoreOfSite[site].cnt, scoreOfSite[site].total);
            }
        } else if (type == 3) {
            int date;
            scanf("%d", &date);
            printf("Case %d: %d %06d\n", i, type, date);
            map<int, int> sitesAndTimes = type3OfDate[date];
            set<Type3> setType3s;
            for (auto it = sitesAndTimes.begin(); it != sitesAndTimes.end(); it++) {
                setType3s.insert({it->first, it->second});
            }
            for (Type3 ty : setType3s) {
                printf("%03d %d\n", ty.site, ty.times);
            }
            if (setType3s.empty()) {
                puts("NA");
            }
        }
    }
    return 0;
}
