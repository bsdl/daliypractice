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
    string digits;
    getline(cin, digits);
    int size = digits.size();
    int occurs[10] = {};
    for (int i = 0; i < size; i++) {
        occurs[digits.at(i) - '0']++;
    }
    int carry = 0;
    bool isTrue = true;
    string afterDouble = "";
    for (int i = size - 1; i >= 0; i--) {
        int num = (digits.at(i) - '0') * 2 + carry;
        if (num >= 10) {
            if (i != 0) {
                num %= 10;
                carry = 1;
            }       
        } else {
            carry = 0;
        }
        afterDouble = to_string(num) + afterDouble;
        if (--occurs[num] < 0) {
            isTrue = false;
        }
    }
    if (isTrue) {
        cout << "Yes" << endl;
    } else {
        cout << "No" << endl;
    }
    cout << afterDouble << endl;

    return 0;

}
