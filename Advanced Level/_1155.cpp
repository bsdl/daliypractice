#include <iostream>
#include <vector>

using namespace std;

int n;
vector<vector<int>> res;
vector<int> heap;
bool isMax = false, isMin = false;

void traverse(vector<int> path, int start) {
    if (start > n) {
        return;
    }
    if (start * 2 > n) {
        path.push_back(heap[start]);
        if (path.size() > 1) {
            if (path[path.size() - 1] > path[path.size() - 2]) {
                isMin = true;
            } else {
                isMax = true;
            }
        }
        res.push_back(path);
        return;
    }
    path.push_back(heap[start]);
    if (path.size() > 1) {
        if (path[path.size() - 1] > path[path.size() - 2]) {
            isMin = true;
        } else {
            isMax = true;
        }
    }
    vector<int> newPath(path);
    traverse(newPath, start * 2 + 1);
    traverse(newPath, start * 2);

}

int main() {
    cin>>n;
    heap.resize(n + 1);
    for (int i = 1; i <= n; i++) {
        scanf("%d", &heap[i]);
    }
    vector<int> path;
    traverse(path, 1);
    for (vector<int> v: res) {
        for (int i = 0; i < v.size(); i++) {
            printf("%d", v[i]);
            if (i == v.size() - 1) {
                puts("");
            } else {
                printf(" ");
            }
        }
    }
    if (isMax && isMin) {
        puts("Not Heap");
    } else if (isMax) {
        puts("Max Heap");
    } else {
        puts("Min Heap");
    }
    return 0;
}