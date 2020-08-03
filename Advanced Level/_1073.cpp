//
// Created by bsdl on 2020/6/19.
//

#include <iostream>
#include <string>
#include <cmath>

using namespace std;

int main() {
    string str;
    cin >> str;
    int idx = 0;
    while (str[idx] != 'E') {
        idx++;
    }
    string num = str.substr(0, idx);
    if (num[0] == '-') {
        cout << '-';
    }
    num = num.substr(1);
    int ex = stoi(str.substr(idx + 1));
    if (ex < 0) {
        cout << "0.";
        for (int i = 0; i < abs(ex) - 1; i++) {
            cout << 0;
        }
        for (char i : num) {
            if (i != '.') {
                cout << i;
            }
        }
    } else if (ex > 0) {
        int dotPos = 1 + ex;
        for (int i = 0; i < num.length(); i++) {
            if (num[i] == '.' || (i == 0 && num[i] == '0')) {
                continue;
            } else {
                cout << num[i];
                if (i == dotPos && i != num.length() - 1) {
                    cout << '.';
                }
            }
            if (i > 1) {
                ex--;
            }
        }
        while (ex > 0) {
            cout << '0';
            ex--;
        }
    }
    return 0;
}