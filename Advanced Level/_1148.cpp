#include <iostream>
#include <vector>

using namespace std;


int main() {
    int n;
    cin>>n;
    vector<int> statements;
    statements.resize(n + 1);
    for (int i =1; i <= n; i++) {
        scanf("%d", &statements[i]);
    }
    for (int i = 1; i <= n; i++) {
        for (int j = i + 1; j <= n; j++) {
            vector<int> isMan(n + 1, 1);
            vector<int> liar;
            isMan[i] = isMan[j] = -1;
            for (int k = 1; k <= n; k++ ) {
                if (statements[k] * isMan[abs(statements[k])] < 0) {
                    liar.push_back(k);
                }
            }
            if (liar.size() == 2 && isMan[liar[0]] + isMan[liar[1]] == 0) {
                printf("%d %d", i, j);
                return 0;
            }
        }
    }
    printf("No Solution\n");
    return 0;
}