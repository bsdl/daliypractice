#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    vector<int> sorted, og;
    for (int i = 0; i < n; i++) {
        int num;
        scanf("%d", &num);
        sorted.push_back(num);
        og.push_back(num);
    }
    sort(sorted.begin(), sorted.end());
    vector<int> res;
    int max = 0;
    int size = sorted.size();
    for (int i = 0; i < size; i++) {
        if (og[i]== sorted[i] && og[i] > max) {
            res.push_back(og[i]);
        }
        if (og[i] > max) {
            max = og[i];
        }
    }
    printf("%d\n", res.size());
    bool isFirst = true;
    for (int num: res) {
        if (isFirst) {
            printf("%d", num);
            isFirst = false;
        } else {
            printf(" %d", num);
        }
    }
    puts("");
    return 0;
}

