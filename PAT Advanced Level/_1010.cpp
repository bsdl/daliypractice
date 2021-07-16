#include <iostream>
#include <algorithm>
#include <cmath>

typedef long long ll;
using namespace std;

ll parseNumToDecimal(string str, int radix) {
    ll res = 0;
    int idx = 0;
    for (auto it = str.rbegin(); it != str.rend(); it++) {
        long digit = isdigit(*it) ? *it - '0' : *it - 'a' + 10;
        res += digit * pow(radix, idx++);
    }
    return res;
}

ll binarySearchRadix(ll sure, string num2, ll left, ll right) {
    ll other;
    while (left <= right) {
        ll mid = (left + right) >> 1;
        other = parseNumToDecimal(num2, mid);
        if (sure == other) return mid;
        else if (sure < other || other < 0) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    return -1;
}

int main() {
    string n1, n2;
    int tag, radix;
    cin >> n1 >> n2 >> tag >> radix;
    ll num1;
    string num2;
    if (tag == 1) {
        num1 = parseNumToDecimal(n1, radix);
        num2 = n2;
    } else {
        num1 = parseNumToDecimal(n2, radix);
        num2 = n1;
    }
    int minRadix = 0;
    for (int i = 0; i < num2.length(); i++) {
        char ch = num2[i];
        int radix;
        if (isdigit(ch)) {
            radix = ch - '0';
        } else {
            radix = ch - 'a' + 10;
        }
        if (radix > minRadix) {
            minRadix = radix;
        }
    }
    minRadix++;
    ll maxRadix = minRadix > num1 ? minRadix : num1;
    ll res = binarySearchRadix(num1, num2, minRadix, maxRadix);
    if (res == -1) printf("Impossible");
    else printf("%lld", res);
    return 0;
}

