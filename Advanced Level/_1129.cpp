#include <iostream>
#include <set>

using namespace std;



struct item {
	int idx, cnt;
	item(int _idx, int _cnt) : idx(_idx), cnt(_cnt){}
	bool operator < (const item &it) const {
		return (cnt != it.cnt) ? cnt > it.cnt : idx < it.idx;
	}
};

int main() {
	int n, k;
	cin >> n >> k;
	int indices[50001] = {};
	set<item> items;
	for (int i = 0; i < n; i++) {
		int num;
		scanf("%d", &num);	
		if (i > 0) {
			printf("%d:", num);
			int tmpIdx = 0;
			for (auto it = items.begin(); it != items.end() && tmpIdx < k; it++) {
				printf(" %d", it->idx);
				tmpIdx++;
			}
			printf("\n");
		}		
		auto it = items.find(item(num, indices[num]));
		if (it != items.end()) {
			items.erase(it);
		}
		items.insert(item(num, ++indices[num]));
	}
	return 0;
}

