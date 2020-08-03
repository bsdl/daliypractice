#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct people {
	int id, virtue, talent, total;
};

vector<people> sages;
vector<people> noblemen;
vector<people> fools;
vector<people> smallmen;

bool comparator(people p1, people p2) {
	if (p1.total != p2.total) {
		return p1.total > p2.total;
	}
	else if (p1.virtue != p2.virtue) {
		return p1.virtue > p2.virtue;
	}
	else {
		return p1.id < p2.id;
	}
}

int main() {
	int n, l, h;
	scanf("%d %d %d", &n, &l, &h);
	for (int i = 0; i < n; i++) {
		int id, virtue, talent;
		scanf("%d %d %d", &id, &virtue, &talent);
		people p = { id, virtue, talent, virtue + talent};
		if (virtue >= h && talent >= h) {
			sages.push_back(p);
		}
		else if (virtue >= h && talent < h && talent >= l) {
			noblemen.push_back(p);
		}
		else if (virtue < h && talent < h && virtue >= talent && talent >= l) {
			fools.push_back(p);
		}
		else if (virtue >= l && talent >= l) {
			smallmen.push_back(p);
		}
	}
	int numOfRankedPeople = sages.size() + noblemen.size() + fools.size() + smallmen.size();
	sort(sages.begin(), sages.end(), comparator);
	sort(noblemen.begin(), noblemen.end(), comparator);
	sort(fools.begin(), fools.end(), comparator);
	sort(smallmen.begin(), smallmen.end(), comparator);
	printf("%d\n", numOfRankedPeople);
	for (people p : sages) {
		printf("%d %d %d\n", p.id, p.virtue, p.talent);
	}
	for (people p : noblemen) {
		printf("%d %d %d\n", p.id, p.virtue, p.talent);
	}
	for (people p : fools) {
		printf("%d %d %d\n", p.id, p.virtue, p.talent);
	}
	for (people p : smallmen) {
		printf("%d %d %d\n", p.id, p.virtue, p.talent);
	}
	return 0;
}