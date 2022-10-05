#include <iostream>
#include <cmath>
#include <cstring>
#include <cctype>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <set>
#include <map>

using namespace std;


int main() {
    int N;
    char symbol;
    cin >> N >> symbol;

    int level = (int)floor(sqrt((N + 1) / 2));
    int actNum = pow(level, 2) * 2 - 1;
    int startNum = 2 * level - 1;
    // 打印上半层
    int indent = 0;
    for(int i = 0; i < level - 1; i++, indent++, startNum -= 2) {
        for(int j = 0; j < indent; j++) {
            cout << ' ';
        }
        for(int j = 0; j < startNum; j++) {
            cout << symbol;
        }
        cout << endl;
    }
    for(int j = 0; j < indent; j++) {
            cout << ' ';
        }
    cout << symbol << endl;
    indent--;
    startNum += 2;
    // 打印下半层
    for (int i = level - 1; i > 0; i--, indent--, startNum += 2) {
        for(int j = 0; j < indent; j++) {
            cout << ' ';
        }
        for(int j = 0; j < startNum; j++) {
            cout << symbol;
        }
        cout << endl;
    }
    cout << N - actNum << endl;
    return 0;
}
