#include <iostream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

int countFriend(int num) {
    int sum = 0;
    while (num > 0) {
        sum += (num % 10);
        num /= 10;
    }
    return sum;
}

int main() {
    int n;
    cin >> n;
    vector<int> v;
    set<int> s;
    for (int i = 0; i < n; i++) {
        int num;
        scanf("%d", &num);
        int f = countFriend(num);
        if (s.find(f) != s.end()) {
            v.push_back(f);
        }
        s.insert(f);
    }
    sort(v.begin(), v.end());
    cout << v.size() << endl;
    for (int i = 0; i < v.size(); i++) {
        printf("%d", v[i]);
        if (i != v.size() - 1) {
            printf(" ");
        }
    }
    return 0;
}