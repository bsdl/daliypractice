#include <iostream>
#include <map>

using namespace std;

int main() {
	string shop, eva;
	cin >> shop;
	cin >> eva;
	map<char, int> beads;
	for (int i = 0; i < shop.length(); i++) {
		beads[shop[i]] += 1;
	}
	int missing = 0;
	for (int i = 0; i < eva.length(); i++) {
		if (beads.find(eva[i]) != beads.end()) {
			beads[eva[i]]--;
			if (beads[eva[i]] == 0) {
				beads.erase(eva[i]);
			}
		}
		else {
			missing++;
		}
	}
	if (missing == 0) {
		printf("Yes %d", shop.length() - eva.length());
	}
	else {
		printf("No %d", missing);
	}
	return 0;
}