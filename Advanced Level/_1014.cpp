#include <iostream>
#include <map>
#include <queue>

using namespace std;

const int N = 20;

int main() {
	queue<int> que[N];
	int endTime[N] = {};
	map<int, int> resSet;
	int n, m, k, q;
	cin >> n >> m >> k >> q;
	for (int i = 1; i <= k; i++) {
		int serveTime, minWindowIdx = 0;
		scanf("%d", &serveTime);
		for (int j = 0; j < n; j++) {
			if (i <= m * n) {
				if (que[j].size() < que[minWindowIdx].size()) {
					minWindowIdx = j;
				}
			}
			else {
				if (que[j].front() < que[minWindowIdx].front()) {
					minWindowIdx = j;
				}
			}
		}
		endTime[minWindowIdx] += serveTime;
		if (i > m * n) {
			que[minWindowIdx].pop();
		}
		que[minWindowIdx].push(endTime[minWindowIdx]);
		if (endTime[minWindowIdx] - serveTime < 540) {
			resSet[i] = endTime[minWindowIdx];
		}
	}
	while (q > 0) {
		int uid;
		cin >> uid;
		if (resSet.count(uid) > 0) {
			int minutes = resSet[uid];
			printf("%02d:%02d\n", minutes / 60 + 8, minutes % 60);
		}
		else {
			puts("Sorry");
		}
		q--;
	}
	return 0;
}
