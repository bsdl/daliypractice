#include <iostream>
#include <algorithm>

using namespace std;

struct AvlNode
{
	int val;
	AvlNode* left, * right;
	int height;
};


int getHeight(AvlNode* node) {
	return node == nullptr ? -1 : node->height;
}

AvlNode* singleRotateWithLeft(AvlNode* root) {
	AvlNode* node;
	node = root->left;
	root->left = node->right;
	node->right = root;
	root->height = max(getHeight(root->left), getHeight(root->right)) + 1;
	node->height = max(getHeight(root->left), root->height) + 1;
	return node;
}

AvlNode* singleRotateWithRight(AvlNode* root) {
	AvlNode* node;
	node = root->right;
	root->right = node->left;
	node->left = root;
	root->height = max(getHeight(root->left), getHeight(root->right)) + 1;
	node->height = max(getHeight(root->right), root->height) + 1;
	return node;
}

AvlNode* doubleRotateWithLeft(AvlNode* root) {
	root->left = singleRotateWithRight(root->left);
	return singleRotateWithLeft(root);
}

AvlNode* doubleRotateWithRight(AvlNode* root) {
	root->right = singleRotateWithLeft(root->right);
	return singleRotateWithRight(root);
}



AvlNode* insert(int val, AvlNode* root) {
	if (root == nullptr) {
		root = new AvlNode;
		root->val = val;
		root->left = root->right = nullptr;
		root->height = 0;
	}
	else {
		if (val < root->val) {
			root->left = insert(val, root->left);
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
			root->right = insert(val, root->right);
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
	int n;
	cin >> n;
	AvlNode* root = nullptr;
	for (int i = 0; i < n; i++) {
		int val;
		scanf("%d", &val);
		root = insert(val, root);
	}
	printf("%d", root->val);
	return 0;
}