#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    vector<int> a1, a2, all;
    a2.resize(n / 2);
    if (n % 2 == 0) {
        a1.resize(n / 2);
        cout << 0;
    }
    else {
        a1.resize(n / 2 + 1);
        cout << 1;
    }
    for (int i = 0; i < n; i++) {
        int num;
        scanf("%d", &num);
        all.push_back(num);
    }
    sort(all.begin(), all.end());
    int idx = 0;
    int sum1 = 0, sum2 = 0;
    while (idx < n / 2) {
        a2.push_back(all[idx]);
        sum2 += all[idx++];
    }
    while (idx < n) {
        a1.push_back(all[idx]);
        sum1 += all[idx++];
    }
    printf("%d", sum1 - sum2);
    return 0;
}
