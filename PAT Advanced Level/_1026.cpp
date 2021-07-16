#include <iostream>
#include <queue>
#include <set>

using namespace std;

struct Pair
{
	int hour, minute, second;
	int serveTime;
	bool isVip;
}pairs[10000];

bool comparator(Pair p1, Pair p2) {
	if (p1.hour != p2.hour) {
		return p1.hour < p2.hour;
	}
	else if (p1.minute != p2.minute) {
		return p1.minute < p2.minute;
	}
	else {
		return p1.second < p2.second;
	}
}

int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int hour, minute, second, serveTime, flag;
		scanf("%d:%d:%d %d %d", &hour, &minute, &second, &serveTime, &flag);
		bool isVip = false;
		if (flag == 1) isVip = true;
		pairs[i] = { hour, minute, second, serveTime, isVip };
	}
	int k, m;
	set<int> vips;
	cin >> k >> m;
	for (int i = 0; i < m; i++) {
		int idx;
		scanf("%d", &idx);
		vips.insert(idx);
	}
	sort(pairs, pairs + n, comparator);
	queue<int> que[100];
	
	return 0;
}