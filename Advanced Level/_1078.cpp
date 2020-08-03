//
// Created by bsdl on 2020/6/24.
//

#include <iostream>
#include <vector>

using namespace std;

bool isPrime(int num) {
    if (num == 1) return false;
    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0) {
            return false;
        }
    }
    return true;
}

int main() {
    int M, N;
    scanf("%d %d", &M, &N);
    while (!isPrime(M)) M++;
    vector<bool> v(M);
    for (int i = 0; i < N; i++) {
        int key;
        scanf("%d", &key);
        if (i != 0) printf(" ");
        for (int step = 0; step < M; step++) {
            int idx = (key + step * step) % M;
            if (!v[idx]) {
                printf("%d", idx % M);
                v[idx] = true;
                break;
            }
            if (step == M - 1) {
                printf("-");
            }
        }
    }
    return 0;
}