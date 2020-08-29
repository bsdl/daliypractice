#include <iostream>
#include <set>
#include <map>

using namespace std;

int main() {
    int k;
    scanf("%d\n", &k);
    string str;
    getline(cin, str);
    map<char, bool> notStucked;
    set<char> mightStucked;
    int left = 0, right = 1;
    while (right < str.length()) {
        if (str[left] != str[right]) {
            notStucked[str[left]] = true;
            left++;
            right++;
        } else {
            while (right < str.length() && str[left] == str[right]) right++;
            int len = right - left;
            if (len < k) {
                notStucked[str[left]] = true;
                left = right - 1;
            } else if (len > k) {
                if (len % k == 0) {
                    mightStucked.insert(str[left]);
                    left = right;
                    right++;
                } else {
                    notStucked[str[left]] = true;
                }
            } else {
                mightStucked.insert(str[left]);
                left = right;
                right++;
            }

        }
    }
    set<char> stucked;
    for (auto &it : mightStucked) {
        if (!notStucked[it]) {
            stucked.insert(it);
        }
    }
    string resStr;
    map<char, bool> appeared;
    int idx = 0;
    while (idx < str.length()) {
        resStr += str[idx];
        if (stucked.count(str[idx]) == 0) {
            idx++;
        } else {
            if (!appeared[str[idx]]) {
                printf("%c", str[idx]);
                appeared[str[idx]] = true;
            }
            idx += k;
        }
    }
    printf("\n%s", resStr.c_str());
	return 0;
}
