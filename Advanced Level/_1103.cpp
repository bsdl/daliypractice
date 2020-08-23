#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

int n, k, p;
int maxFactors[8] = {0, 0, 20, 7, 4, 3, 2, 2};
int maxFactorSum = 0;
vector<int> seq, tmpSeq;

void dfs(int end, int sum, int cnt) {
    for (int i = end; i > 0; i--) {
        int curSum = sum + (int)pow(i, p);
        if (cnt == k && curSum < n) return;
        if (curSum > n || (curSum == n && cnt < k)) continue;
        if (cnt == k && curSum == n) {
            tmpSeq.push_back(i);
            int fSum = 0;
            for (int fac: tmpSeq) {
                fSum += fac;
            }
            if (fSum > maxFactorSum) {
                seq = tmpSeq;
                maxFactorSum = fSum;
            } else if(fSum == maxFactorSum) {
                for (int j = 0; j < tmpSeq.size(); j++) {
                    if (tmpSeq[j] == seq[j]) continue;
                    else if (tmpSeq[j] > seq[j]) {
                        seq = tmpSeq;
                    }
                    break;
                }
            }
            tmpSeq.pop_back();
            return;
        }
        tmpSeq.push_back(i);
        dfs(i, curSum, cnt + 1);
        tmpSeq.pop_back();
    }
}

int main() {
    cin >> n >> k >> p;
    dfs(maxFactors[p], 0, 1);
    if (seq.size() == 0) {
        printf("Impossible");
    } else {
        printf("%d = ", n);
        for (int i = 0; i < seq.size(); i++) {
            printf("%d^%d", seq[i], p);
            if (i < seq.size() - 1) {
                printf(" + ");
            }
        }
    }
    return 0;
}