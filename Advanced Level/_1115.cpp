#include <iostream>
#include <queue>

using namespace std;

struct Node {
	int val, depth;
	Node* left = nullptr, * right = nullptr;
};

int n;
int lowestDepth = -1;

Node* insert(int val, Node* root, int depth) {
	if (root == nullptr) {
		root = new Node;
		root->val = val;
		root->depth = depth;
		lowestDepth = lowestDepth < depth ? depth : lowestDepth;
	}
	else if (val <= root->val) {
		root->left = insert(val, root->left, depth + 1);
	}
	else {
		root->right = insert(val, root->right, depth + 1);
	}
	return root;
}

int main() {
	cin >> n;
	Node* root = nullptr;
	for (int i = 0; i < n; i++) {
		int val;
		scanf("%d", &val);
		root = insert(val, root, 0);
	}
	queue<Node*> que;
	que.push(root);
	int depth = 0;
	int size = que.size();;
	int n1, n2;
	while (!que.empty()) {		
		if (depth == lowestDepth - 1) {
			n2 = size;
		}
		if (depth == lowestDepth) {
			n1 = size;
		}
		depth++;	
		while (size > 0) {
			size--;
			Node* node = que.front();
			que.pop();
			if (node->left != nullptr) {
				que.push(node->left);
			} 
			if (node->right != nullptr) {
				que.push(node->right);
			}			
		}	
		size = que.size();
	}
	printf("%d + %d = %d", n1, n2, n1 + n2);
	return 0;
}