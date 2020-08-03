#include <iostream>
#include <vector>

using namespace std;

int n;
vector<int> pre;
vector<int> post;
vector<int> in;
bool isUnique = true;

void inorder(int prel, int prer, int postl, int postr) {
	if (prel == prer) {
		in.push_back(pre[prel]);
		return;
	}
	if (pre[prel] == post[postr]) {
		int idx = prel + 1;
		while (idx <= prer && pre[idx] != post[postr - 1]) idx++;
		if (idx - prel > 1) {
			inorder(prel + 1, idx - 1, postl, postl + (idx - prel - 1) - 1);
		}
		else {
			isUnique = false;
		}
		in.push_back(post[postr]);
		inorder(idx, prer, postl + (idx - prel - 1), postr - 1);
	}
}

int main() {
	cin >> n;
	pre.resize(n);
	post.resize(n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &pre[i]);
	}
	for (int i = 0; i < n; i++) {
		scanf("%d", &post[i]);
	}
	inorder(0, n - 1, 0, n - 1);
	printf("%s\n", isUnique ? "Yes" : "No");
	for (int i = 0; i < n; i++) {
		if (i == 0) {
			printf("%d", in[i]);
		}
		else {
			printf(" %d", in[i]);
		}
	}
	puts("");
	return 0;
}