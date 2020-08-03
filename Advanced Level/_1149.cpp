#include <iostream>
#include <map>
#include <vector>

using namespace std;

int main() {
	int n, m;
	cin >> n >> m;
	map<int, vector<int>> incompatibles;
	for (int i = 0; i < n; i++) {
		int good1, good2;
		scanf("%d %d", &good1, &good2);
		incompatibles[good1].push_back(good2);
		incompatibles[good2].push_back(good1);
	}
	for (int i = 0; i < m; i++) {
		int goods_num;
		cin >> goods_num;
		int	container[100001] = {0};
		bool isYes = true;
		vector<int> list(goods_num);
		for (int i = 0; i < goods_num; i++) {
			scanf("%d", &list[i]);
			container[list[i]] = 1;
		}
		
		for (int good : list) {
			vector<int> incompat_goods = incompatibles[good];
			for (int incampat : incompat_goods) {
				if (container[incampat] == 1) {
					isYes = false;
					break;
				}
			}
			if (!isYes) {
				break;
			}
		}
		if (isYes) {
			printf("Yes\n");
		}
		else {
			printf("No\n");
		}
	}
	return 0;
}
