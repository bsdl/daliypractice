//
// Created by bsdl on 2020/6/17.
//

#include <iostream>

using namespace std;

int main() {
    string str;
    cin >> str;
    int len = str.length();
    int num = (len + 2) / 3;
    int n1 = num;
    int n3 = (len + 2) % 3 == 0 ? num : num + (len + 2) % 3;
    int row = n3 - 2;
    for (int i = 0; i < n1; i++) {
        if (i == n1 - 1) {
            for (int j = i; j < n3 + i; j++) {
                cout << str[j];
            }
        } else {
            int pos = i + (n1 - i) * 2 + row - 1;
            cout << str[i];
            for (int j = 0; j < row; j++) {
                cout << " ";
            }
            cout << str[pos] << endl;
        }
    }
    return 0;
}