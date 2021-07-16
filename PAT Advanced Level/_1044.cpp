//#include <iostream>
//#include <vector>
//#include <algorithm>
//
//using namespace std;
//
//struct Result {
//    int val;
//    int l, r;
//};
//
//bool cmp(Result r1, Result r2) {
//    return r1.val < r2.val;
//}
//
//
//int main() {
//    int n, m;
//    cin >> n >> m;
//    vector<int> chain(n + 1);
//    vector<Result> vals;
//    for (int i = 1; i <= n; i++) {
//        scanf("%d", &chain[i]);
//    }
//    int left = 1, right = 0, sum = 0;
//    bool flag = false;
//    while (right <= n) {
//        // 0 3 2 1 5 4 6 8 7 16 10 15 11 9 12 14 13
//        if (sum == m) {
//            flag = true;
//            printf("%d-%d\n", left, right);
//            sum -= chain[left++];
//        } else if (sum > m) {
//            vals.push_back({sum, left, right});
//            sum -= chain[left++];
//        } else {
//            sum += chain[++right];
//        }
//    }
//    while (left < right) {
//        if (sum < m) break;
//        else if (sum > m) {
//            sum -= chain[left++];
//        } else {
//            flag = true;
//            printf("%d-%d\n", left, right);
//            sum -= chain[left++];
//        }
//    }
//
//    if (!flag) {
//        sort(vals.begin(), vals.end(), cmp);
//        int val = vals[0].val;
//        int idx = 0;
//        while (vals[idx].val == val) {
//            printf("%d-%d\n", vals[idx].l, vals[idx].r);
//            idx++;
//        }
//    }
//    return 0;
//}


#include <stdio.h>

#define True 1
#define False 0

int main() {
    int N, M;
    scanf("%d %d", &N, &M);
    int values[100000] = {0};
    int pair[100000][2] = {{0}};
    for (int i = 0; i < N; i++) {
        scanf("%d", values + i);
    }
    int left = 0, right = 0, idx = 0, min = 100000000, curValue = values[0];
    while (True) {
        if (curValue <= min && curValue >= M) {
            if (curValue < min) {
                min = curValue;
                idx = 0;
            }
            pair[idx][0] = left + 1;
            pair[idx][1] = right + 1;
            idx++;
        }
        if (curValue <= M && right < N - 1) {
            curValue += values[++right];
        } else if (left < N) {
            curValue -= values[left++];
        } else {
            break;
        }
    }
    for (int i = 0; i < idx; i++) {
        printf("%d-%d\n", pair[i][0], pair[i][1]);
    }
    return 0;
}