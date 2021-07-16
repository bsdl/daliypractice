#include <iostream>
#include <vector>

using namespace std;

int mSize, n, m;
vector<int> hashTable;

bool isPrime(int num) {
    if (num <= 3) {
        return num > 1;
    }
    if (num % 2 == 0 || num % 3 == 0) {
        return false;
    }
    for (int i = 5; i * i <= num; i += 6) {
        if (num % i == 0 || num % (i + 2) == 0) {
            return false;
        }
    }
    return true;
}

void insert(int num) {
    int isIn = false;
    for (int i = 0; i < mSize; i++) {
        int pos = (num + i * i) % mSize;
        if (hashTable[pos] == 0) {
            hashTable[pos] = num;
            isIn = true;
            break;
        }
    }
    if (!isIn) {
        printf("%d cannot be inserted.\n", num);
    }
}

int main() {
    cin >> mSize >> n >> m;
    while (!isPrime(mSize)) {
        mSize++;
    }
    hashTable.resize(mSize);
    for (int i = 0; i < n; i++) {
        int num;
        scanf("%d", &num);
        insert(num);
    }
    int tol = 0;
    for (int i = 0; i < m; i++) {
        int num, cnt = 0;
        scanf("%d", &num);
        for (int j = 0; j <= mSize; j++) {
            cnt++;
            int pos = (num + j * j) % mSize;
            if (hashTable[pos] == 0 || hashTable[pos] == num) {
                break;
            }
        }
        tol += cnt;
    }
    printf("%.1lf", tol * 1.0 / m);
    return 0;
}

