#include <iostream>
#include <set>
#include <map>

using namespace std;

struct Family
{
	set<string> members;
	int area;
	int stateNum;
};

int main() {
	int n;
	cin >> n;
	map<string, Family> m;
	for (int i = 0; i < n; i++) {
		string id;
		string fid, mid;
		for (auto it = m.begin(); it != m.end(); it++) {
			Family family = it->second;

		}
	}
	return 0;
}
