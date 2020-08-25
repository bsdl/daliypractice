#include <iostream>
#include <map>

using namespace std;

int main() {
    string str;
    getline(cin, str);
    int idx = 0;
    string word;
    map<string, int> m;
    while (idx < str.length()) {
        if (isalnum(str[idx])) {
            word.push_back(tolower(str[idx]));
        } else {
            if (!word.empty()) {
                m[word]++;
                word.clear();
            }
        }
        idx++;
    }
    if (!word.empty()) {
        m[word]++;
    }
    string result;
    int maxCnt = 0;
    for (auto &it: m) {
        if (it.second > maxCnt) {
            result = it.first;
            maxCnt = it.second;
        }
    }
    cout << result << " " << maxCnt;
    return 0;
}