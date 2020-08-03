#include <iostream>
#include <queue>
#include <vector>

using namespace std;

struct BiTree
{
	int val;
	BiTree* left = nullptr, *right = nullptr;
};

BiTree* postInTree(int in[], int post[], int n) {
	if (n == 0) {
		return nullptr;
	}
	int i = 0;
	while (post[n - 1] != in[i]) {
		i++;
	}
	BiTree* newTree = new BiTree;
	newTree->val = in[i];
	newTree->left = postInTree(in, post, i);
	newTree->right = postInTree(in + i + 1, post + i, n - i - 1);
	return newTree;
}

int main() {
	int n;
	scanf("%d", &n);
	int in[30], post[30];
	for (int i = 0; i < n; i++) {
		scanf("%d", in + i);
	}
	for (int i = 0; i < n; i++) {
		scanf("%d", post + i);
	}
	vector<int> seq;
	BiTree* root = postInTree(in, post, n);
	queue<BiTree*> que;
	bool isOdd = true;
	que.push(root);
	int size = que.size();
	while (!que.empty()) {
		vector<BiTree*> level(size);
		int tmpSize = size;
		while (size > 0) {
			BiTree* node = que.front();			
			level[size - 1] = node;
			seq.push_back(node->val);
			size--;
			que.pop();
		}
		for (int i = 0; i < tmpSize; i++) {
			BiTree* node = level[i];
			if (isOdd) {
				if (node->left) {
					que.push(node->left);
				}
				if (node->right) {
					que.push(node->right);
				}
			}
			else {
				if (node->right) {
					que.push(node->right);
				}
				if (node->left) {
					que.push(node->left);
				}
			}
		}		
		isOdd = !isOdd;
		size = que.size();
	}
	for (int i = 0; i < seq.size(); i++) {
		printf("%d", seq[i]);
		if (i != seq.size() - 1) {
			printf(" ");
		}
	}
	return 0;
}
