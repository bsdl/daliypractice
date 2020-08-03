#include <iostream>
#include <queue>
#include <algorithm>

#define CLOSE_TIME 61200

using namespace std;

struct Customer
{
	int timesec, spend;
}customers[10000];

bool comparator(Customer c1, Customer c2) {
	return c1.timesec < c2.timesec;
}

int main() {
	int n, k;
	cin >> n >> k;
	//vector<Customer> vec(n);
	for (int i = 0; i < n; i++) {
		int hour, minute, sec;
		scanf("%d:%d:%d", &hour, &minute, &sec);
		int spend;
		scanf("%d", &spend);
		customers[i].timesec = hour * 60 * 60 + minute * 60 + sec;
		customers[i].spend = spend;
	}
	queue<int> que[100];
	for (int i = 0; i < k; i++) {
		que[i].push(8 * 60 * 60);
	}
	sort(customers, customers + n, comparator);
	float cnt = 0;
	float totalWaitTime = 0;
	for (int i = 0; i < n; i++) {
		int serveTime = customers[i].spend * 60;
		int arriveTime = customers[i].timesec;
		if (arriveTime > CLOSE_TIME) {
			break;
		}
		int minWindowIdx = 0;
		for (int j = 0; j < k; j++) {
			if (que[minWindowIdx].front() > que[j].front()) {
				minWindowIdx = j;
			}
		}
		int timeAhead = que[minWindowIdx].front();
		int endTime;
		if (arriveTime < timeAhead) {
			totalWaitTime += timeAhead - arriveTime;
			endTime = timeAhead + serveTime;
		}
		else {
			endTime = arriveTime + serveTime;
		}
		cnt++;
		que[minWindowIdx].push(endTime);
		que[minWindowIdx].pop();
	} 
	float averageMinutes = totalWaitTime / cnt / 60.0;
	printf("%.1f", averageMinutes);
	return 0;
}