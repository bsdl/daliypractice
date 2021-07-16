#include <iostream>
#include <algorithm>

using namespace std;

bool comparator(string s1, string s2) {
    return s1 + s2 < s2 + s1;
}

int main() {
    int n;
    cin >> n;
    string v[10000];
    for (int i = 0; i < n; i++) {
        cin >> v[i];
    }
    sort(v, v + n, comparator);
    string s;
    for (int i = 0; i < n; i++) {
        s += v[i];
    }
    while (s.length() != 0 && s[0] == '0') {
        s.erase(s.begin());
    }
    if (s.length() == 0) {
        cout << 0;
    }
    cout << s;
    return 0;
}