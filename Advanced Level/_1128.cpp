#include <iostream>
#include <vector>

using namespace std;

bool isNQueen(vector<int> chessboard) {
    int size = chessboard.size();
    for (int i = 0; i < size - 1; i++) {
        for (int j = i + 1; j < size; j++) {
            if (j - i == abs(chessboard[i] - chessboard[j])
                || chessboard[i] == chessboard[j]) {
                return false;
            }
        }
    }
    return true;
}

int main() {
    int k;
    scanf("%d", &k);
    vector<vector<int>> all;
    for (int i = 0; i < k; i++) {
        int n;
        scanf("%d", &n);
        vector<int> chessboard;
        chessboard.resize(n);
        for (int j = 0; j < n; j++) {
            scanf("%d", &chessboard[j]);
        }
        all.push_back(chessboard);
    }
    for (vector<int> chessboard: all) {
        isNQueen(chessboard) ? printf("YES\n"): printf("NO\n");
    }
    return 0;
}

