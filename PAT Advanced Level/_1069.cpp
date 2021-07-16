//
// Created by bsdl on 2020/6/26.
//

#include <iostream>
#include <algorithm>

using namespace std;

bool nonIncreasingComparator(char c1, char c2) {
    return c2 - c1;
}

void helper(string num) {
    while (num.length() < 4) {
        num = '0' + num;
    }
    if (num[0] == '0' && num[1] == '0' && num[2] == '0' && num[3] == '0') {
        return;
    }
    sort(num.begin(), num.end());
    string nonDecreasing = num;
    sort(num.begin(), num.end(), nonIncreasingComparator);
    string nonIncreasing = num;
    int res = stoi(nonIncreasing) - stoi(nonDecreasing);
    string result = to_string(res);
    while (result.length() < 4) {
        result = '0' + result;
    }
    cout << nonIncreasing << " - " << nonDecreasing << " = " << result << endl;
    if (res == 6174) {
        return;
    }
    helper(result);
}

int main() {
    string num;
    cin >> num;
    helper(num);
    return 0;
}