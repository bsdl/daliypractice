#include <iostream>
#include <queue>
#include <stack>
#include <map>

using namespace std;

int main() {
	int n;
	cin >> n;
	priority_queue<int> pq;

	stack<int> s;
	for (int i = 0; i < n; i++) {
		string oper;
		cin >> oper;
		if (oper == "Push") {
			int num;
			cin >> num;
			s.push(num);
			pq.push(num);
		}

	}
	return 0;
}