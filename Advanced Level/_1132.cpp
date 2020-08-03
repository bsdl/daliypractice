#include <iostream>
#include <string>

using namespace std;

int main() {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        string str;
        cin >> str;
        int mid = str.length() / 2;
        int a = stoi(str.substr(0, mid));
        int b = stoi(str.substr(mid));
        int z = stoi(str);
        int mul = a * b;
        if (mul == 0) {
            cout << "No" << endl;
            continue;
        }
        if (z % mul == 0) {
            cout << "Yes" << endl;
        }
        else {
            cout << "No" << endl;
        }
    }
    return 0;
}