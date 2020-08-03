#include <iostream>
#include <string>
#include <queue>


using namespace std;

struct TreeNode
{
	int left, right;
};

int main() {
	int n;
	cin >> n;
	vector<bool> isRoot(n, true);
	vector<TreeNode> tree(n);
	for (int i = 0; i < n; i++) {
		string left, right;
		cin >> left >> right;
		if (left == "-") {
			tree[i].left = -1;
		}
		else {
			isRoot[stoi(left)] = false;
			tree[i].left = stoi(left);
		}
		if (right == "-") {
			tree[i].right = -1;
		}
		else {
			isRoot[stoi(right)] = false;
			tree[i].right = stoi(right);
		}
	}
	int root;
	for (int i = 0; i < n; i++) {
		if (isRoot[i]) {
			root = i;
			break;
		}
	}
	int lastNode = 0;
	queue<int> que;
	que.push(root);
	int cnt = 0;
	while (!que.empty()) {
		int node = que.front();
		que.pop();
		if (node == -1) {
			if (cnt == n) {
				printf("YES %d", lastNode);
			}
			else {
				printf("NO %d", root);				
			}
			return 0;
		}
		else {
			cnt++;
			lastNode = node;
		}
		que.push(tree[node].left);
		que.push(tree[node].right);
		
	}
	return 0;
}