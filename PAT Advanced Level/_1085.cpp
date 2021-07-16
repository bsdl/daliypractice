//
// Created by bsdl on 2020/6/16.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    int N;
    long long p;
    cin >> N >> p;
    vector<int> seq(N);
    for (int i = 0; i < N; i++) {
        cin >> seq[i];
    }
    sort(seq.begin(), seq.end());
    int tmp = 0, max = 0;
    for (int i = 0; i < N; i++) {
        for (int j = i + max; j < N; j++) {
            if (seq[i] * p >= seq[j]) {
                tmp = j - i + 1;
                max = max >= tmp ? max : tmp;
            } else {
                break;
            }
        }
    }
    cout << max;
    return 0;
}