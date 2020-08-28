#include <iostream>

using namespace std;

int main() {
    int stackSize, cnt, caseNum;
    scanf("%d %d %d", &stackSize, &cnt, &caseNum);
    for (int cId = 0; cId < caseNum; cId++) {
        int outQue[1000] = {0};
        int idx = 0;
        while (idx < cnt) {
            scanf("%d", outQue + idx);
            idx++;
        }
        idx = 1;
        int stack[1000] = {0};
        int top = -1;
        int outIdx = 0;
        while (true) {
            if ((top == -1 || idx <= outQue[outIdx]) && top < stackSize - 1 && idx <= cnt) {
                stack[++top] = idx;
                idx++;
            } else if (stack[top] == outQue[outIdx] && outIdx < cnt) {
                top--;
                outIdx++;
            } else if ((stack[top] > outQue[outIdx] && outIdx < cnt) || stack[top] < outQue[outIdx]) {
                printf("NO\n");
                break;
            } else if (top == -1 && idx == cnt + 1 && outIdx == cnt) {
                if (cId == caseNum - 1) {
                    printf("YES");
                } else {
                    printf("YES\n");
                }
                break;
            }
        }
    }
    return 0;
}

