#include <iostream>
#include <vector>

using namespace std;

vector<int> in;
vector<int> pre;

bool isFirst = true;

void helper(int root, int start, int end) {
	if (start > end || !isFirst) {
		return;
	}
	int idx = start;
	while (idx < end && pre[root] != in[idx]) {
		idx++;
	}
	helper(root + 1, start, idx - 1);
	helper(root + 1 + idx - start, idx + 1, end);
	if (isFirst) {
		printf("%d", in[idx]);
		isFirst = false;
	}
}


int main() {
	int n;
	cin >> n;
	pre.resize(n);
	in.resize(n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &pre[i]);
	}
	for (int i = 0; i < n; i++) {
		scanf("%d", &in[i]);
	}
	helper(0, 0, n - 1);
	return 0;
}
