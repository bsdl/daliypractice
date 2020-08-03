//
// Created by bsdl on 2020/6/17.
//
#include <iostream>
#include <vector>
using namespace std;

int main() {
    int len1, len2;
    cin >> len1;
    vector<int> v1(len1);
    for (int i = 0; i < len1; i++) {
        scanf("%d", &v1[i]);
    }
    cin >> len2;
    vector<int> v2(len2);
    for (int i = 0; i < len2; i++) {
        scanf("%d", &v2[i]);
    }

    int mid = (len1 + len2) >> 1;
    mid += (len1 + len2) % 2 == 0 ? -1 : 0;
    int idx1 = 0, idx2 = 0, idx = 0;
    vector<int> v3(len1 + len2);
    while (idx1 < len1 && idx2 < len2) {
        if (v1[idx1] < v2[idx2]) {
            v3[idx++] = v1[idx1++];
        } else {
            v3[idx++] = v2[idx2++];
        }
    }
    while (idx1 < len1) {
        v3[idx++] = v1[idx1++];
    }
    while (idx2 < len2) {
        v3[idx++] = v2[idx2++];
    }
    cout << v3[mid];
    return 0;
}
