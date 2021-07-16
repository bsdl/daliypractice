#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Node {
	int addr, val, next;
}nodes[100000];


bool comparator(Node n1, Node n2) {
	return n1.val < n2.val;
}

int main() {
	int n, head;
	cin >> n >> head;
	for (int i = 0; i < n; i++) {
		int addr, val, next;
		scanf("%d %d %d", &addr, &val, &next);
		nodes[addr].addr = addr;
		nodes[addr].next = next;
		nodes[addr].val = val;
	}
	vector<Node> list;
	while (head != -1) {
		list.push_back(nodes[head]);
		head = nodes[head].next;
	}
	if (list.size() == 0) {
		printf("0 -1");
		return 0;
	}
	sort(list.begin(), list.end(), comparator);
	printf("%d %05d\n", list.size(), list[0].addr);
	for (int i = 0; i < list.size(); i++) {
		printf("%05d %d ", list[i].addr, list[i].val);
		if (i == list.size() - 1) {
			printf("-1\n");
		}
		else {
			printf("%05d\n", list[i + 1].addr);
		}
	}
	return 0;
}