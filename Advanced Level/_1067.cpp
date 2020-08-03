//
// Created by bsdl on 2020/6/24.
//

#include <iostream>

using namespace std;

int main() {
    int n;
    scanf("%d", &n);
    int seq[n];
    for (int i = 0; i < n; i++) {
        scanf("%d", seq + i);
    }
    int numOfStep = 0;
    for (int i = 1; i < n; i++) {
        if (seq[i] != i) {
            swap(seq[0], seq[i]);
            numOfStep++;
            while (seq[0] != 0) {
                swap(seq[0], seq[seq[0]]);
                numOfStep++;
            }
        }
    }
    cout << numOfStep;
    return 0;
}
