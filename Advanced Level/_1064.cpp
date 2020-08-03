#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> seq;
vector<int> completeTree;
int idx = 0;

void inorder(int root, int n) {
	if (root * 2 <= n) {
		inorder(root * 2, n);
	}
	completeTree[root] = seq[idx++];
	if (root * 2 + 1 <= n) {
		inorder(root * 2 + 1, n);
	}
}

int main() {
	int n;
	cin >> n;
	seq.resize(n);
	completeTree.resize(n + 1);
	for (int i = 0; i < n; i++) {
		scanf("%d", &seq[i]);
	}
	sort(seq.begin(), seq.end());
	inorder(1, n);
	for (int i = 1; i <= n; i++) {
		printf("%d", completeTree[i]);
		if (i < n) {
			printf(" ");
		}
	}
	return 0;
}