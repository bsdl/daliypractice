#include <iostream>
#include <set>
#include <algorithm>

using namespace std;

struct Node {
    int val;
    Node *left = nullptr, *right = nullptr;
};

int pre[10050];
int in[10050];

Node *findLca(Node *root, int n1, int n2) {
    int val = root->val;
    if (val == n1 || val == n2) {
        return root;
    }
    if ((n1 > val && n2 < val) || (n2 > val && n1 < val)) {
        return root;
    } else if (n1 < val && n2 < val) {
        findLca(root->left, n1, n2);
    } else {
        findLca(root->right, n1, n2);
    }
}

Node *buildTree(int pre[], int in[], int n) {
    if (n == 0) {
        return nullptr;
    }
    Node *node = new Node;
    int idx = 0;
    while (pre[0] != in[idx]) {
        idx++;
    }
    node->val = in[idx];
    node->left = buildTree(pre + 1, in, idx);
    node->right = buildTree(pre + idx + 1, in + idx + 1, n - idx - 1);
    return node;
}

int main() {
    int m, n;
    cin >> m >> n;
    set<int> occr;
    Node *root = nullptr;
    for (int i = 0; i < n; i++) {
        scanf("%d", pre + i);
        occr.insert(pre[i]);
        in[i] = pre[i];
    }
    sort(in, in+n);
    root = buildTree(pre, in, n);
    for (int i = 0; i < m; i++) {
        int n1, n2;
        scanf("%d %d", &n1, &n2);
        if (occr.count(n1) == 0 && occr.count(n2) == 0) {
            printf("ERROR: %d and %d are not found.\n", n1, n2);
        } else if (occr.count(n1) == 0) {
            printf("ERROR: %d is not found.\n", n1);
        } else if (occr.count(n2) == 0) {
            printf("ERROR: %d is not found.\n", n2);
        } else {
            Node *lca = findLca(root, n1, n2);
            int val = lca->val;
            if (val == n1) {
                printf("%d is an ancestor of %d.\n", n1, n2);
            } else if (val == n2) {
                printf("%d is an ancestor of %d.\n", n2, n1);
            } else {
                printf("LCA of %d and %d is %d.\n", n1, n2, val);
            }
        }
    }
    return 0;
}