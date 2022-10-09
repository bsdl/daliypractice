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



bool is_prime(int num) {
    for (int i = 2; i < num / 2; i++) {
        if (num % i == 0) {
            return false;
        }
    }
    return true;
}

int main() {
    int N;
    cin >> N;
    int primes[N] = {};
    int ret = 0;
    for (int i = 3; i <= N; i+=2) {
        if (is_prime(i)) {
            primes[i] = i;
            if (i - 2 > 2 
            && primes[i] - primes[i - 2] == 2) {
                ret++;
            }
        }
    }
    cout << ret << endl;
    return 0;
}
