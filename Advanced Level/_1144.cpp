#include <iostream>
#include <set>

using namespace std;

int main() {
	int n;
	cin >> n;
	int smallest = 1;
	set<int> used;
	while (n > 0) {
		int num;
		scanf("%d", &num);
		if (num == smallest) {
			smallest++;
			while (used.find(smallest) != used.end()) {
				smallest++;
			}
			used.insert(num);
		}
		else {
			used.insert(num);
		}
		n--;
	}
	printf("%d", smallest);
	return 0;
}