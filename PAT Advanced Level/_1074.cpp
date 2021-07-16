#include <iostream>

using namespace std;

struct Node {
	int val;
	int next;
}linkedList[100001];

int reverseList(int head, int end) {
	int res = head;
	int pos = linkedList[head].next;
	int tmp = -1;
	linkedList[head].next = linkedList[end].next;
	linkedList[end].next = -1;
	while (pos != -1) {
		tmp = linkedList[pos].next;
		linkedList[pos].next = res;
		res = pos;
		pos = tmp;
	}
	return head;
}

int main() {
	int head, n, k;
	cin >> head >> n >> k;
	for (int i = 0; i < n; i++) {
		int node, val, next;
		scanf("%d %d %d", &node, &val, &next);
		linkedList[node].next = next;
		linkedList[node].val = val;
	}
	int pre = 100000;
	linkedList[pre].next = head;
	if (k == 1) {
		while (true) {
			int addr = linkedList[pre].next;
			if (addr == -1) {
				break;
			}
			printf("%05d %d ", addr, linkedList[addr].val);
			if (linkedList[addr].next == -1) {
				printf("-1\n");
			}
			else {
				printf("%05d\n", linkedList[addr].next);
			}
			pre = addr;
		}
		return 0;
	}
	int pos = head;
	while (pos != -1) {
		for (int i = 0; i < k - 1; i++) {
			pos = linkedList[pos].next;
			if (pos == -1) {
				break;
			}
		}
		if (pos == -1) {
			break;
		}
		int tmp = linkedList[pre].next;	
		linkedList[pre].next = pos;
		tmp = reverseList(tmp, pos);
		pre = tmp;
		pos = linkedList[tmp].next;
	}
	int start = 100000;
	while (true) {
		int addr = linkedList[start].next;
		if (addr == -1) {
			break;
		}
		printf("%05d %d ", addr, linkedList[addr].val);
		if (linkedList[addr].next == -1) {
			printf("-1\n");
		}
		else {
			printf("%05d\n", linkedList[addr].next);
		}
		start = addr;
	}
	return 0;
}