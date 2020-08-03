#include <iostream>
#include <queue>
#include <vector>

using namespace std;

struct Node
{
	int val;
	Node* left = nullptr, * right = nullptr;
};


Node* helper(int post[], int in[], int n) {
	if (n == 0) {
		return nullptr;
	}
	int idx = 0;
	while (post[n - 1] != in[idx]) {
		idx++;
	}
	Node* node = new Node();
	node->val = in[idx];
	node->left = helper(post, in, idx);
	node->right = helper(post + idx, in + idx + 1, n - idx - 1);
	return node;
}


int main() {
	int n;
	cin >> n;
	int in[30], post[30];
	for (int i = 0; i < n; i++) {
		scanf("%d", post + i);
	}
	for (int i = 0; i < n; i++) {
		scanf("%d", in + i);
	}
	vector<int> res;
	Node *root = helper(post, in, n);
	queue<Node*> que;
	que.push(root);
	int size = que.size();
	while (!que.empty()) {
		while (size > 0) {
			Node* node = que.front();
			que.pop();
			if (node->left) {
				que.push(node->left);
			}
			if (node->right) {
				que.push(node->right);
			}
			size--;
			res.push_back(node->val);
		}
		size = que.size();
	}
	for (int i = 0; i < n; i++) {
		printf("%d", res[i]);
		if (i < n - 1) {
			printf(" ");
		}
	}
	return 0;
}
