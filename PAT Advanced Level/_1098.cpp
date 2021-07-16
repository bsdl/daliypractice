#include <iostream>
#include <algorithm>

using namespace std;

void percDown(int arr[], int start, int end) {
    int father = start;
    int child = father * 2;
    while (child <= end) {
        if (child + 1 <= end && arr[child + 1] > arr[child]) {
            child++;
        }
        if (arr[child] < arr[father]) {
            break;
        } else {
            swap(arr[child], arr[father]);
            father = child;
            child = father * 2;
        }
    }
}


int main() {
    int n;
    scanf("%d", &n);
    int og[100], partial[100];
    for (int i = 1; i <= n; i++) {
        scanf("%d", og + i);
    }
    for (int i = 1; i <= n; i++) {
        scanf("%d", partial + i);
    }
    int idx = 1;
    while (idx < n && partial[idx] <= partial[idx + 1]) idx++;
    bool isInsert = true;
    idx++;
    for (int i = idx; i < n; i++) {
        if (og[i] != partial[i]) {
            isInsert = false;
            break;
        }
    }
    if (isInsert) {
        puts("Insertion Sort");
        sort(partial + 1, partial + idx + 1);
    } else {
        puts("Heap Sort");
        int pos = n;
        while (pos > 2 && partial[1] < partial[pos]) pos--;
        swap(partial[1], partial[pos]);
        percDown(partial, 1, pos - 1);
    }
    for (int i = 1; i <= n; i++) {
        printf("%d", partial[i]);
        if (i < n) {
            printf(" ");
        }
    }
    return 0;
}