#include <iostream>
#include <string>

using namespace std;

bool isPali(string strNum) {
    int len = strNum.length();
    int l = 0, r = len - 1;
    while (l < r) {
        if (strNum[l] != strNum[r]) {
            return false;
        }
        l++;
        r--;
    }
    return true;
}

string reverse(string num) {
    string res;
    int len = num.length();
    for (int i = len - 1; i >= 0; i--) {
        res += num[i];
    }
    return res;
}

string strSum(string num1, string num2) {
    int end1 = num1.length() - 1, end2 = num2.length() - 1;
    string sum = "";
    int carry = 0;
    while (end1 >= 0 && end2 >= 0) {
        int num = num1[end1] - '0' + num2[end2] - '0' + carry;
        if (num >= 10) {
            carry = 1;
        } else {
            carry = 0;
        }
        num %= 10;
        sum = to_string(num) + sum;
        end1--;
        end2--;
    }
    while (end1 > 0) {
        int num = num1[end1] - '0' + carry;
        if (num >= 10) {
            carry = 1;
        } else {
            carry = 0;
        }
        num %= 10;
        sum = to_string(num) + sum;
        end1--;
    }
    while (end2 > 0) {
        int num = num2[end2] - '0' + carry;
        if (num >= 10) {
            carry = 1;
        } else {
            carry = 0;
        }
        num %= 10;
        sum = to_string(num) + sum;
        end2--;
    }
    if (carry == 1) {
        sum = "1" + sum;
    }
    return sum;
}

int main() {
    string num;
    cin >> num;
    int cnt = 0;
    bool flag = false;
    while (!isPali(num)) {
        if (cnt == 10) {
            flag = true;
            break;
        }
        string reverseNum = reverse(num);
        string sum = strSum(num, reverseNum);
        cout << num << " + " << reverseNum << " = " << sum << endl;
        cnt++;
        num = sum;
    }
    if (flag) {
        puts("Not found in 10 iterations.");
    } else {
        cout << num << " is a palindromic number." << endl;
    }
    return 0;
}

