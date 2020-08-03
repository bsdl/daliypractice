#include <iostream>
#include <vector>

using namespace std;
vector<int> post;

void postorder(vector<int> tree, int start, int n) {
	if (2 * start <= n) {
		postorder(tree, 2 * start, n);
	} 
	if (2 * start + 1 <= n) {
		postorder(tree, 2 * start + 1, n);
	}
	post.push_back(tree[start]);
}
int main() {
	int m, n;
	scanf("%d %d", &m, &n);
	for (int i = 0; i < m; i++) {
		vector<int> tree(n + 1);
		for (int j = 1; j <= n; j++) {
			scanf("%d", &tree[j]);
		}
		bool isMax = true, isMin = true;
		for (int j = 2; j <= n; j++) {
			if (tree[j] > tree[j / 2]) {
				isMax = false;
			}
			if (tree[j] < tree[j / 2]) {
				isMin = false;
			}
		}
		if (isMax) {
			printf("Max Heap\n");
		}
		else if (isMin) {
			printf("Min Heap\n");
		}
		else {
			printf("Not Heap\n"); 
		}
		// ºóÐò±éÀú
		postorder(tree, 1, n);
		for (int i = 0; i < n; i++) {
			printf("%d", post[i]);
			if (i < n - 1) {
				printf(" ");
			}
			else {
				printf("\n");
			}
		}
		post.clear();
	}
	return 0;
}