//
// Created by bsdl on 2020/6/19.
//
#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n, base;

    scanf("%d %d", &n, &base);
    if (n == 0) {
        cout << "Yes" ;
    }
    vector<int> v;
    int idx = 0;
    while (n > 0) {
        v.push_back(n % base);
        n /= base;
        idx++;
    }
    bool isPali = true;

    for (int i = 0, j = idx - 1; i < j; i++, j--) {
        if (v[i] != v[j]) {
            isPali = false;
            break;
        }
    }
    cout << (isPali ? "Yes" : "No") << endl;
    for (int i = idx - 1; i >= 0; i--) {
        if (i == 0) {
            cout << v[i];
        } else {
            cout << v[i] << " ";
        }
    }
    return  0;
}