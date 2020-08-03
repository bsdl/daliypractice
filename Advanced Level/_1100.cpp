#include <iostream>
#include <cctype>
#include <string>
#include <map>
#include <math.h>

using namespace std;

string low_digits[13] = { "tret", "jan", "feb", "mar", "apr", "may", "jun",
    "jly", "aug", "sep", "oct", "nov", "dec" };
string high_digits[13] = { "tret", "tam", "hel", "maa", "huh", "tou", "kes", "hei",
    "elo", "syy", "lok", "mer", "jou" };

map<int, string> digit_str_low;
map<int, string> digit_str_high;
map<string, int> str_digit_low;
map<string, int> str_digit_high;

void setup() {
    for (int i = 0; i < 13; i++) {
        digit_str_low[i] = low_digits[i];
        str_digit_low[low_digits[i]] = i;
    }
    for (int i = 0; i < 13; i++) {
        digit_str_high[i] = high_digits[i];
        str_digit_high[high_digits[i]] = i;
    }
}

string line;

string to_mars(int num) {
    string res = "";
    if (num / 13 != 0) {
        cout << digit_str_high[num / 13];
    }
    if ((num / 13 != 0) && (num % 13 != 0)) {
        cout << " ";
    }
    if (num % 13 != 0 || num == 0) {
        cout << digit_str_low[num % 13];
    }
    
}

int to_earth() {
    int idx = 0;
    int res = 0;
    while (idx < line.length() && !isspace(line[idx])) idx++;
    string num = line.substr(0, idx);
    res += str_digit_high[num] * 13;
    idx++;
    if (idx < line.length()) {
        string low = line.substr(idx);
        res += str_digit_low[low];
    }
    cout << res;
    return res;
}

int main() {
    int n;
    cin >> n;
    setup();
    getchar();
    for (int i = 0; i < n; i++) {        
        getline(cin, line);
        if (isdigit(line[0])) {
            int tmp = stoi(line);
            to_mars(tmp);
        }
        else {
            to_earth();
        }
        cout << endl;
    }
    return 0;
}

