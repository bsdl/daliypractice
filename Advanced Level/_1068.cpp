//
// Created by bsdl on 2020/6/24.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n, price;
    scanf("%d %d", &n, &price);
    vector<int> v(n);
    for (int i = 0; i < n; i++) {
        scanf("%d", v[i]);
    }
    sort(v.begin(), v.end());
    
    return 0;
}