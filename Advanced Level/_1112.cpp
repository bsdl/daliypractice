#include <iostream>
#include <set>

using namespace std;

int main() {
	int k;
	cin >> k;
	string str;
	cin >> str;
	string stucked = "";
	set<char> s;
	set<char> occured;
	int len = str.length();
	int left = 0, right = 0;
	int cnt = 0;
	while (right < len) {
		if (str[left] == str[right]) {
			cnt++;
			if (cnt == k) {
				if (occured.find(str[left]) != occured.end()) {
					right++;				
					stucked.append(str.substr(left, right - left));
					left = right;
				}
				else {
					s.insert(str[left]);
					stucked += str[left];
					right++;
					left = right;				
				}	
				cnt = 0;
				continue;
			}
			right++;
			if (right == len) {
				stucked.append(str.substr(left, right - left));
				break;
			}
		}
		else {
			stucked.append(str.substr(left, right - left));
			occured.insert(str[left]);
			left = right;
			cnt = 0;
		}
	}
	for (char ch : s) {
		printf("%c", ch);
	}
	printf("\n");
	cout << stucked;
	return 0;
}
