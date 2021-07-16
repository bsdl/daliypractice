#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> nodes;
vector<bool> isRoot;
string vals[25];
int n;

void inorder(int root, int depth) {
	if (root == -1) {
		return;
	}
	else if (nodes[root][0] == -1 && nodes[root][1] == -1) {
		cout << vals[root];
	}
	else {
		if (depth > 1) {
			printf("(");
		}
		inorder(nodes[root][0], depth + 1);
		cout << vals[root];
		inorder(nodes[root][1], depth + 1);
		if (depth > 1) {
			printf(")");
		}
	}
}

int main() {
	scanf("%d", &n);
	nodes.resize(n + 1);
	isRoot.resize(n + 1, true);
	for (int i = 1; i <= n; i++) {
		int left, right;
		cin >> vals[i] >> left >> right;
		nodes[i].push_back(left);
		nodes[i].push_back(right);
		if (left != -1) isRoot[left] = false;
		if (right != -1) isRoot[right] = false;
	}
	int root;
	for (int i = 1; i <= n; i++) {
		if (isRoot[i]) {
			root = i;
			break;
		}
	}
	inorder(root, 1);
	return 0;
}