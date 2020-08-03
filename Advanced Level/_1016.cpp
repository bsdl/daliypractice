#include <iostream>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

struct Record
{
	int day;
	int hour;
	int minute;
	string oper;
};

struct Customer
{
	int month;
	float total;
	vector<Record> records;
};

int prices[24] = {};


bool comparator(Record r1, Record r2) {
	if (r1.day != r2.day) {
		return r1.day < r2.day;
	}
	else if (r1.hour != r2.hour) {
		return r1.hour < r2.hour;
	}
	else {
		return r1.minute < r2.minute;
	}
}

int main() {
	int daySum = 0;
	for (int i = 0; i < 24; i++) {
		int price;
		scanf("%d", &price);
		daySum += price;
		prices[i] = price;
	}
	int n;
	cin >> n;
	map<string, Customer> customers;
	for (int i = 0; i < n; i++) {
		string name;
		int month, day, hour, minute;
		string oper;
		cin >> name;
		scanf("%d:%d:%d:%d", &month, &day, &hour, &minute);
		cin >> oper;		
		customers[name].records.push_back({ day, hour, minute, oper });
		customers[name].month = month;
	}
	for (auto it : customers) {
		sort(it.second.records.begin(), it.second.records.end(), comparator);
		vector<Record> v = it.second.records;
		cout << it.first;
		printf(" %02d\n", it.second.month);
		float total = 0;
		int left = 0, right = 1;
		while (right < v.size()) {
			if (v[left].oper == "on-line" && v[right].oper == "off-line") {
				printf("%02d:%02d:%02d %02d:%02d:%02d ",
					v[left].day, v[left].hour, v[left].minute,
					v[right].day, v[right].hour, v[right].minute);
				int minutes = (v[right].day * 24 * 60 + v[right].hour * 60 + v[right].minute)
					- (v[left].day * 24 * 60 + v[left].hour * 60 + v[left].minute);
				printf("%d ", minutes);
				float cost = 0;
				int startDay = v[left].day, endDay = v[right].day;
				int startHour = v[left].hour, startMinute = v[left].minute;
				int endHour = v[right].hour, endMinute = v[right].minute;
				
				int dayDiff = endDay - startDay;
				if (dayDiff > 1) {
					cost += daySum * 60;
					dayDiff--;
				}
				if (dayDiff == 1 && startHour > endHour) {
					while (startHour < 24) {
						cost += 60 * prices[startHour++];
					}
					startHour = 0;
				}
				else if (dayDiff == 1 && startHour <= endHour) {
					cost += daySum * 60;
				}
				
				int hourDiff = endHour - startHour;
				if (hourDiff > 0) {
					cost += prices[startHour++] * (60 - startMinute);
					for (int i = startHour; i < endHour; i++) {
						cost += 60 * prices[i];
					}
					cost += endMinute * prices[endHour];
				}
				else {
					cost += (endMinute - startMinute) * prices[startHour];
				}
				cost /= 100;
				printf("$%.2f\n", cost);
				total += cost;
				left = right + 1;
				right = left + 1;
			}
			else {
				if (v[right].oper == "on-line") {
					left = right;
					right++;
				}
				else if (v[right].oper == "off-line") {
					left = right + 1;
					right = left + 1;
				}
			}
		}
		printf("Total amount: $%.2f\n", total);
	}
	return 0;
}