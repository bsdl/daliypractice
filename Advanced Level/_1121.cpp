#include <iostream>
#include <map>
#include <set>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	int n;
	cin >> n;
	map<string, string> couples;
	for (int i = 0; i < n; i++) {
		string c1, c2;
		cin >> c1 >> c2;
		couples[c1] = c2;
		couples[c2] = c1;
	}
	int m;
	cin >> m;
	vector<string> singles;
	set<string> notSingles;
	for (int i = 0; i < m; i++) {
		string guest;
		cin >> guest;
		if (couples.find(guest) == couples.end()) {
			singles.push_back(guest);
		}
		else {
			notSingles.insert(guest);
		}
	}
	for (string p : notSingles) {
		string mate = couples[p];
		if (notSingles.find(mate) == notSingles.end()) {
			singles.push_back(p);
		}
	}
	sort(singles.begin(), singles.end());
	int size = singles.size();
	printf("%d\n", size);
	for (int i = 0; i < size; i++) {
		cout << singles[i];
		if (i != size - 1) {
			cout << " ";
		}
	}
	return 0;
}