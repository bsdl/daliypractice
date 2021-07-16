#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

struct AvlNode
{
	int val;
	AvlNode* left;
	AvlNode* right;
	int height;
};

int n;
vector<AvlNode> nodes;

int getHeight(AvlNode* node) {
	if (node == nullptr) {
		return -1;
	}
	else {
		return node->height;
	}
}

AvlNode* singleRotateWithLeft(AvlNode* root) {
	AvlNode* node;
	node = root->left;
	root->left = node->right;
	node->right = root;
	root->height = max(getHeight(root->left), getHeight(root->right)) + 1;
	node->height = max(getHeight(node->left), root->height) + 1;
	return node;
}

AvlNode* singleRotateWithRight(AvlNode* root) {
	AvlNode* node;
	node = root->right;
	root->right = node->left;
	node->left = root;
	root->height = max(getHeight(root->left), getHeight(root->right)) + 1;
	node->height = max(getHeight(node->right), root->height) + 1;	
	return node;
}

AvlNode* doubleRotateWithRight(AvlNode* root) {
	root->right = singleRotateWithLeft(root->right);
	return singleRotateWithRight(root);
}

AvlNode* doubleRotateWithLeft(AvlNode* root) {
	root->left = singleRotateWithRight(root->left);
	return singleRotateWithLeft(root);
}

AvlNode* insertInAvl(int val, AvlNode* root) {
	if (root == nullptr) {
		root = new AvlNode;
		root->left = root->right = nullptr;
		root->height = 0;
		root->val = val;
	}
	else {
		if (val < root->val) {
			root->left = insertInAvl(val, root->left);
			if (getHeight(root->left) - getHeight(root->right) == 2) {
				if (val < root->left->val) {
					root = singleRotateWithLeft(root);
				}
				else {
					root = doubleRotateWithLeft(root);
				}
			}
		}
		else {
			root->right = insertInAvl(val, root->right);
			if (getHeight(root->right) - getHeight(root->left) == 2) {
				if (val > root->right->val) {
					root = singleRotateWithRight(root);
				}
				else {
					root = doubleRotateWithRight(root);
				}
			}
		}
	}
	root->height = max(getHeight(root->left), getHeight(root->right)) + 1;
	return root;
}

int main() {
	cin >> n;
	AvlNode* root = nullptr;
	for (int i = 0; i < n; i++) {
		int val;
		scanf("%d", &val);
		root = insertInAvl(val, root);
	}
	queue<AvlNode*> que;
	que.push(root);
	int cnt = 0;
	bool isComplete = true;
	bool isFirst = true;
	while (!que.empty()) {
		AvlNode* node = que.front();
		que.pop();
		if (node == nullptr) {
			if (cnt != n) {
				isComplete = false;
			}
			continue;
		}	
		if (node != nullptr) {
			que.push(node->left);
			que.push(node->right);
			if (isFirst) {
				printf("%d", node->val);
				isFirst = false;
			}
			else {
				printf(" %d", node->val);
			}
			cnt++;
		}	
	}
	cout << endl;
	if (isComplete) {
		cout << "YES";
	}
	else {
		cout << "NO";
	}
	return 0;
}