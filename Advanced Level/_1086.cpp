#include <iostream>
#include <stack>
#include <cstring>
#include <vector>


using namespace std;

vector<int> in, pre;
bool isFirst = true;

void helper(int root, int start, int end) {
	if (start > end) {
		return;
	}
	int idx = start;
	while (idx < end && pre[root] != in[idx]) {
		idx++;
	}
	helper(root + 1, start, idx - 1);
	helper(root + 1 + idx - start, idx + 1, end);
	if (isFirst) {
		printf("%d", pre[root]);
		isFirst = !isFirst;
	}
	else {
		printf(" %d", pre[root]);
	}
}

int main() {
	int n;
	cin >> n;
	scanf("%d", &n);
	stack<int> stk;
	int inIdx = 0, preIdx = 0;
	for (int i = 0; i < 2 * n; i++) {
		string op;
		cin >> op;
		if (op.length() == 3) {
			int node = stk.top();
			stk.pop();
			in.push_back(node);
		}
		else {
			int node;
			cin >> node;
			pre.push_back(node);
			stk.push(node);
		}
	}
	helper(0, 0, n - 1);
	return 0;
}