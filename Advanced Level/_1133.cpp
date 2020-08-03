#include <iostream>
#include <map>
#include <vector>

using namespace std;

struct node
{
	string addr;
	int data;
	string next;
};

int main() {
	string root_addr;
	int n, k;
	cin >> root_addr >> n >> k;
	map<string, node> m;
	for (int i = 0; i < n; i++) {
		string addr, next;
		int data;
		cin >> addr >> data >> next;
		m[addr] = { addr, data, next };
	}
	node root = m[root_addr];
	vector<node> seq;
	while (m.find(root.addr) != m.end()) {
		if (root.data < 0) {
			seq.push_back(root);
		}
		root = m[root.next];
	}
	root = m[root_addr];
	while (m.find(root.addr) != m.end()) {
		if (root.data >= 0 && root.data <= k) {
			seq.push_back(root);
		}
		root = m[root.next];
	}
	root = m[root_addr];
	while (m.find(root.addr) != m.end()) {
		if (root.data > k) {
			seq.push_back(root);
		}
		root = m[root.next];
	}
	for (int i = 0; i < seq.size(); i++) {
		if (i == seq.size() - 1) {
			cout << seq[i].addr << " " << seq[i].data << " " << -1 << endl;
		}
		else {
			cout << seq[i].addr << " " << seq[i].data << " " << seq[i + 1].addr << endl;
		}	
	}
	return 0;
}
