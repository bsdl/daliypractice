#include <iostream>
#include <vector>
#include <set>

using namespace std;

struct Node {
	int val;
	Node* left = NULL, * right = NULL;
};

Node* insert(int val, Node* root) {
	if (root == NULL) {
		root = new Node;
		root->val = val;
	}
	else if (abs(val) < abs(root->val)) {
		root->left = insert(val, root->left);
	}
	else if (abs(val) > abs(root->val)) {
		root->right = insert(val, root->right);
	}
	return root;
}

set<int> times;

bool isRedBlack(Node* root, int curBlackNum) {
	if (root != NULL) {
		int isBlack = root->val < 0 ? 0 : 1;
		if (root->left != NULL && root->val < 0 && root->left->val < 0)
			return false;
		if (root->right != NULL && root->val < 0 && root->right->val < 0)
			return false;
		if (!isRedBlack(root->left, curBlackNum + isBlack)) return false;
		if (!isRedBlack(root->right, curBlackNum + isBlack)) return false;
	}
	else {
		times.insert(curBlackNum);
	}
	return true;

}

int main() {
	int k;
	cin >> k;
	while (k > 0) {
		k--;
		int n;
		cin >> n;
		times.clear();
		Node* root = NULL;
		for (int i = 0; i < n; i++) {
			int val;
			cin >> val;
			root = insert(val, root);
		}
		if (root->val < 0) {
			printf("No\n");
		}
		else {
			bool flag = isRedBlack(root, 0);
			if (flag && times.size() == 1) {
				cout << "Yes" << endl;
			}
			else {
				cout << "No" << endl;
			}
		}	
	}
	return 0;
}
