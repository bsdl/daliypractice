#include <iostream>
#include <stack>

using namespace std;

int main() {
    int m, n, k;
    cin >> m >> n >> k;
    for (int i = 0; i < k; i++) {
        int seq[1001];
        stack<int> st;
        for (int j = 0; j < n; j++) {
            scanf("%d", seq + j);
        }
        int idx = 0;
        bool isValid = true;
        for (int j = 1; j <= n; j++) {
            st.push(j);
            if (st.size() > m) {
                isValid = false;
                break;
            }
            while (!st.empty() && st.top() == seq[idx]) {
                st.pop();
                idx++;
            }
        }
        if (!st.empty()) isValid = false;
        printf("%s\n", isValid ? "YES" : "NO");
    }
    return 0;

}