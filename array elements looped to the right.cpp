#include <iostream>
#include <cmath>
#include <cstring>
#include <cctype>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <set>
#include <map>

using namespace std;


int main() {
    int N, M;
    cin >> N >> M;
    int nums[N] = {};
    int n;
    for (int i = 0; i < N; i++) {
        cin >> n; 
        int index = (i + M) % N;
        nums[index] = n;
    }
    for (int i = 0; i < N; i++) {
        if (i == N - 1) {
            printf("%d", nums[i]);
        } else {
            printf("%d ", nums[i]);
        }
    }
    return 0;
}
