#include <iostream>
#include <map>
#include <vector>
#include <set>
#include <string>
#include <cmath>

using namespace std;

struct node
{
	string addr;
	int key;
	string next;
};

int main() {
	string head_addr;
	int n;
	cin >> head_addr >> n;
	map<string, node> linked_list;	
	for (int i = 0; i < n; i++) {
		string addr, next;
		int key;
		cin >> addr >> key >> next;
		node n = { addr, key, next };
		linked_list[addr] = n;
	}
	vector<node> uniqe;
	vector<node> removed;
	set<int> isOccured;
	int uniqe_idx = 0, removed_idx = 0;
	while (head_addr[0] != '-') {
		node head = linked_list[head_addr];
		string addr = head.addr;
		int key = head.key;
		if (isOccured.find(abs(key)) == isOccured.end()) {
			isOccured.insert(abs(key));
			uniqe.push_back(head);
			if (uniqe_idx > 0) {
				uniqe[uniqe_idx - 1].next = head.addr;
				uniqe[uniqe_idx].next = "-1";
			}
			uniqe_idx++;
		}
		else {
			removed.push_back(head);
			if (removed_idx > 0) {
				removed[removed_idx - 1].next = head.addr;
				removed[removed_idx].next = "-1";
			}
			removed_idx++;
		}
		head_addr = linked_list[addr].next;
	}
	for (node n : uniqe) {
		cout << n.addr << " " << n.key << " " << n.next << endl;
	}
	for (node n : removed) {
		cout << n.addr << " " << n.key << " " << n.next << endl;
	}
	return 0;
}
