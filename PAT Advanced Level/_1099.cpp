#include <iostream>
#include <queue>
#include <stack>
#include <vector>
#include <algorithm>

using namespace std;

struct Node
{
	int val;
	int left, right;
	int index;
}nodes[101];

int main() {
	int N;
	vector<int> vals;
	scanf("%d", &N);
	vals.resize(N);
	for (int i = 0; i < N; i++) {
		scanf("%d %d", &nodes[i].left, &nodes[i].right);
		nodes[i].index = i;
	}
	for (int i = 0; i < N; i++) {
		scanf("%d", &vals[i]);
	}
	sort(vals.begin(), vals.end());
	int idx = 0;
	stack<Node> st;
	int n = 0;
	while (n != -1) {
		st.push(nodes[n]);
		n = nodes[n].left;
	}
	while (!st.empty()) {
		Node node = st.top();
		st.pop();
		nodes[node.index].val = vals[idx++];
		if (node.right != -1) {
			n = node.right;
			while (n != -1) {
				st.push(nodes[n]);
				n = nodes[n].left;
			}
		}
	}
	// level order
	queue<int> que;
	que.push(0);
	bool isFirst = true;
	while (!que.empty()) {
		int deq = que.front();
		que.pop();
		if (nodes[deq].left != -1) {
			que.push(nodes[deq].left);
		}
		if (nodes[deq].right != -1) {
			que.push(nodes[deq].right);
		}
		if (isFirst) {
			printf("%d", nodes[deq].val);
			isFirst = false;
		}
		else {
			printf(" %d", nodes[deq].val);
		}
	}
	return 0;
}