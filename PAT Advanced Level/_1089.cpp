#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;
    int og[100], partially[100];
    for (int i = 0; i < n; i++) {
        scanf("%d", og + i);
    }
    for (int i = 0; i < n; i++) {
        scanf("%d", partially + i);
    }
    int i = 0;
    while (i < n - 1 && partially[i] <= partially[i + 1]) i++;
    int idx = ++i;
    bool isInsertion = true;
    while (idx < n) {
        if (og[idx] != partially[idx]) {
            isInsertion = false;
            break;
        }
        idx++;
    }
    if (isInsertion) {
        printf("Insertion Sort\n");
        sort(og, og + i + 1);
    } else {
        printf("Merge Sort\n");
        int increment = 1;
        bool flag = true;
        while (flag) {
            flag = false;
            for (int j = 0; j < n; j++) {
                if (og[j] != partially[j]) {
                    flag = true;
                }
            }
            increment *= 2;
            for (int j = 0; j < n / increment; j++) {
                sort(og + j * increment, og + (j + 1) * increment);
            }
            sort(og + n / increment * increment, og + n);
        }
    }
    idx = 0;
    for (; idx < n; idx++) {
        printf("%d", og[idx]);
        if (idx < n - 1) {
            printf(" ");
        }
    }
    return 0;
}
