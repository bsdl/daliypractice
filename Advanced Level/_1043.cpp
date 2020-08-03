#include <iostream>
#include <vector>

using namespace std;

struct Node
{
	int val;
	Node* left, * right;
};

int n;
vector<int> v;
vector<int> pre;
vector<int> reversepre;
vector<int> post;

Node* insert(int val, Node* root) {
	if (root == nullptr) {
		root = new Node;
		root->val = val;
		root->left = root->right = nullptr;
	}
	else if (val < root->val) {
		root->left = insert(val, root->left);
	}
	else {
		root->right = insert(val, root->right);
	}
	return root;
}

void preorder(Node* root) {
	if (root != nullptr) {
		pre.push_back(root->val);
		preorder(root->left);
		preorder(root->right);
	}
}

void reverse(Node* root) {
	if (root != nullptr) {
		Node* tmp = root->left;
		root->left = root->right;
		root->right = tmp;
		reverse(root->left);
		reverse(root->right);
	}
}

bool isFirst = true;

void postorder(Node* root) {
	if (root != nullptr) {
		postorder(root->left);
		postorder(root->right);
		if (isFirst) {
			printf("%d", root->val);
			isFirst = false;
		}
		else {
			printf(" %d", root->val);
		}
	}
}

int main() {
	cin >> n;
	Node* root = nullptr;
	for (int i = 0; i < n; i++) {
		int val;
		scanf("%d", &val);
		v.push_back(val);
		root = insert(val, root);
	}
	preorder(root);
	bool flag = true;
	for (int i = 0; i < n; i++) {
		if (pre[i] != v[i]) {
			flag = false;
			break;
		}
	}
	if (flag) {
		printf("YES\n");
		postorder(root);
		return 0;
	}
	reverse(root);
	pre.clear();
	preorder(root);
	flag = true;
	for (int i = 0; i < n; i++) {
		if (pre[i] != v[i]) {
			flag = false;
			break;
		}
	}
	if (flag) {
		printf("YES\n");
		postorder(root);
		return 0;
	}
	printf("NO");	
	return 0;
}
