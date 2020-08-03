#include <iostream>
#include <set>

using namespace std;

struct Node {
	int val;
	Node* left = nullptr, * right = nullptr;
};

int in[10001];
int pre[10001];

Node* buildTree(int pre[], int in[], int n) {
	if (n == 0) {
		return nullptr;
	}
	int idx = 0;
	while (in[idx] != pre[0]) idx++;
	Node* node = new Node;
	node->val = in[idx];
	node->left = buildTree(pre + 1, in, idx);
	node->right = buildTree(pre + idx + 1, in + idx + 1, n - idx - 1);
	return node;
}

Node* findLca(Node* root, int n1, int n2) {
	if (root == nullptr || root->val == n1 || root->val == n2) {
		return root;
	}
	Node* left = findLca(root->left, n1, n2);
	Node* right = findLca(root->right, n1, n2);
	if (left == nullptr && right == nullptr) return nullptr;
	if (left != nullptr && right == nullptr) return left;
	if (left == nullptr && right != nullptr) return right;
	return root;
}


int main() {
	int m, n;
	cin >> m >> n;
	set<int> nodes;
 	for (int i = 0; i < n; i++) {
		scanf("%d", in + i);
		nodes.insert(in[i]);
	}
	for (int i = 0; i < n; i++) {
		scanf("%d", pre + i);
	}
	Node* root = buildTree(pre, in, n);
	for (int i = 0; i < m; i++) {
		int n1, n2;
		scanf("%d %d", &n1, &n2);
		if (nodes.count(n1) == 0 && nodes.count(n2) == 0) {
			printf("ERROR: %d and %d are not found.\n", n1, n2);
		}
		else if (nodes.count(n1) == 0) {
			printf("ERROR: %d is not found.\n", n1);
		}
		else if (nodes.count(n2) == 0) {
			printf("ERROR: %d is not found.\n", n2);
		}
		else {
			Node* node = findLca(root, n1, n2);
			if (node->val == n1) {
				printf("%d is an ancestor of %d.\n", n1, n2);
			}
			else if (node->val == n2) {
				printf("%d is an ancestor of %d.\n", n2, n1);
			}
			else {
				printf("LCA of %d and %d is %d.\n", n1, n2, node->val);
			}
		}
	}
	return 0;
}
