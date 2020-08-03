#include <iostream>
#include <map>
#include <vector>

using namespace std;

struct node {
	string id;
	int rank;
	bool isChecked = false;
};

bool isPrime(int num) {
	for (int i = 2; i * i <= num; i++) {
		if (num % i == 0) {
			return false;
		}
	}
	return true;
}

int main() {
	int n;
	scanf("%d", &n);
	map<string, node> m;
	for (int i = 1; i <= n; i++) {
		string id;
		cin >> id;
		node n = {};
		n.id = id;
		n.rank = i;
		m[id] = n;
	}
	int k;
	scanf("%d", &k);
	vector<string> res;
	for (int i = 0; i < k; i++) {
		string query;
		cin >> query;
		if (m.find(query) == m.end()) {
			res.push_back(query + ": Are you kidding?");
			continue;
		}
		if (m[query].isChecked) {
			res.push_back(query + ": Checked");
			continue;
		}
		int rank = m[query].rank;
		if (rank == 1) {
			res.push_back(query + ": Mystery Award");
		}
		else if (isPrime(rank)) {
			res.push_back(query + ": Minion");
		}
		else {
			res.push_back(query + ": Chocolate");
		}
		m[query].isChecked = true;
	}
	for (string str : res) {
		cout << str << endl;
	}
	return 0;
}