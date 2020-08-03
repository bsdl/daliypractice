#include <iostream>
#include <ctype.h>
#include <string>

using namespace std;

int main() {
	int n;
	cin >> n;
	float sum = 0;
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		string str;
		cin >> str;
		bool isLegal = true;
		for (int j = 0; j < str.length(); j++) {
			if (j == 0) {
				if (str[j] == '-' || str[j] == '+') {
					continue;
				}
				else if (!isdigit(str[j])) {
					isLegal = false;
					break;
				}				
			}
			else if (isalpha(str[j])) {
				isLegal = false;
				break;
			}
			else if (str[j] == '.') {
				if (j + 1 == str.length() || str.length() - 1 - j > 2) {
					isLegal = false;
					break;
				}
				int k = j + 1;
				while (k < str.length()) {
					if (!isalnum(str[k])) {
						isLegal = false;
					}
					k++;
				}
				break;
			}
			else if (!isalnum(str[j])) {
				isLegal = false;
				break;
			}
			else {
				continue;
			}
		}
		if (isLegal) {
			float val = stof(str);
			if (val < -1000 || val > 1000) {
				cout << "ERROR: " << str << " is not a legal number" << endl;
			}
			else {
				sum += val;
				cnt++;
			}
		}
		else {
			cout << "ERROR: " << str << " is not a legal number" << endl;
		}
	}
	if (cnt == 0) {
		printf("The average of 0 numbers is Undefined");
	}
	else {
		float avg = sum / cnt;
		if (cnt == 1) {
			printf("The average of 1 number is %.2f", avg);
		}
		else {
			printf("The average of %d numbers is %.2f", cnt, avg);
		}
	}
	return 0;
}