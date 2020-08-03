//
// Created by bsdl on 2020/6/19.
//

#include <iostream>

using namespace std;

int main() {
    string str;
    cin >> str;
    long long int num = 0;
    int ps = 0;
    long long int tmp = 0;
    for (int i = 0; i < str.length(); i++) {
        if (str[i] == 'P') {
            ps++;
        } else if (str[i] == 'A') {
            tmp += ps;
        } else {
            num += tmp;
        }
    }
    cout << num % 1000000007;
    return 0;
}