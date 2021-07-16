#include <iostream>
#include <algorithm>

using namespace std;

int seq[100010];

int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        scanf("%d", seq + i);
    }
    sort(seq, seq + n);
    int res, j;
    for (j = n - 1, res = 1; j > 0; j--, res++) {
        if (seq[j] <= res) break;
    }
    cout << res - 1;
    return 0;
}