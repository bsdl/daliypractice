//
// Created by bsdl on 2020/6/28.
//

#include <iostream>
#include <set>
#include <map>

using namespace std;

int main() {
    int n;
    scanf("%d", &n);
    map<int, set<int>> allSets;
    for (int i = 0; i < n; i++) {
        int m;
        scanf("%d", &m);
        set<int> s;
        for (int j = 0; j < m; j++) {
            int num;
            scanf("%d", &num);
            s.insert(num);
        }
        allSets[i + 1] = s;
    }
    int k;
    scanf("%d", &k);
    for (int i = 0; i < k; i++) {
        int n1, n2;
        scanf("%d %d", &n1, &n2);
        set<int> set1 = allSets[n1];
        set<int> set2 = allSets[n2];
        int intersectionLen = 0, unionLen = 0;
        for (int num : set1) {
            if (set2.find(num) != set2.end()) {
                intersectionLen++;
            }
        }
        unionLen = set2.size() + set1.size() - intersectionLen;
        float perc = ((float)intersectionLen / (float)unionLen) * 100;
        printf("%0.1f%%\n", perc);
    }
    return 0;
}
