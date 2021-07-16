#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    vector<int> v(n);
    for (int i = 0; i < n; i++) {
        /*scanf("%d", v[i]);*/
        cin >> v[i];
    }
    sort(v.begin(), v.end());
    float len = 0;
    float lastSeg = v[0];
    for (int i = 1; i < n; i++) {
        len = (lastSeg + v[i]) / 2;
        lastSeg = len;
    }
    int res = (int)len;
    printf("%d", res);
    return 0;
}