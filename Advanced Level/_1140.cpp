#include <iostream>
#include <string>

using namespace std;

int main() {
    int d, n;
    cin >> d >> n;
    string str = to_string(d);
    for (int i = 0; i < n - 1; i++) {
        string newStr = "";
        int left = 0, right = 0;
        while (right <= str.length()) {
            if (right == str.length() || str[left] != str[right]) {
                newStr += str[left];
                newStr += to_string(right - left);
                left = right;
                if (right == str.length()) {
                    break;
                }
            }
            else {
                right++;
            }
        }
        str = newStr;
    }
    cout << str;
    return 0;
}
