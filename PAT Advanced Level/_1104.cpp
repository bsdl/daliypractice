#include <iostream>
#include <vector>

using namespace std;

int n;
long double total = 0;
long double data[100002] = {0};

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> data[i];
        total += data[i] * (i + 1) * (n - i);
    }
    printf("%.2Lf", total);
    return 0;
}