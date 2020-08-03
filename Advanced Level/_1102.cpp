#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct node
{
	int id;
	int left = -1;
	int right = -1;
};

char chL, chR;
vector<node> nodes;
vector<int> inSeq;

void levelorder(int root) {
	queue<int> que;
	vector<int> seq;
	que.push(root);
	while (!que.empty()) {
		int idx = que.front();
		seq.push_back(idx);
		que.pop();
		node n = nodes[idx];
		if (n.left != -1) {
			que.push(n.left);
		} 
		if (n.right != -1) {
			que.push(n.right);
		}
	}
	for (int i = 0; i < seq.size(); i++) {
		printf("%d", seq[i]);
		if (i != seq.size() - 1) {
			printf(" ");
		}
		else {
			printf("\n");
		}
	}
}

void inorder(node n) {
	if (n.left != -1) {
		inorder(nodes[n.left]);
	}
	inSeq.push_back(n.id);
	if (n.right != -1) {
		inorder(nodes[n.right]);
	}
	
}

int main() {
	int n;
	scanf("%d", &n);
	nodes.resize(n);
	vector<bool> isVisited(n, false);
	for (int i = 0; i < n; i++) {
		cin >> chL >> chR;
		nodes[i].id = i;
		if (chL != '-') {
			nodes[i].right = chL - '0';
			isVisited[chL - '0'] = true;
		}
		if (chR != '-') {
			nodes[i].left = chR - '0';
			isVisited[chR - '0'] = true;
		}
	}
	int root;
	for (int i = 0; i < isVisited.size(); i++) {
		if (!isVisited[i]) {
			root = i;
		}
	}
	levelorder(root);
	inorder(nodes[root]);
	for (int i = 0; i < inSeq.size(); i++) {
		printf("%d", inSeq[i]);
		if (i != inSeq.size() - 1) {
			printf(" ");
		}
	}
	return 0;
}