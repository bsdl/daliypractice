#include <iostream>
#include <string>
#include <math.h>
using namespace std;

bool isPrime(long num) {
	if (num <= 3) {
		return num > 1;
	}
	if (num % 2 == 0 || num % 3 == 0) {
		return false;
	}
	for (int i = 5; i * i <= num; i += 6) {
		if (num % i == 0 || num % (2 + i) == 0) {
			return false;
		}
	}
	return true;
}

int main() {
	int l, k;
	cin >> l >> k;
	int left = 0;
	string digits;
	cin >> digits;
	while (left + k <= l) {
		string candi = digits.substr(left, k);
		long num = stol(candi);
		if (isPrime(num)) {
			cout << candi;
			return 0;
		} 
		left++;
	}
	cout << 404;
	return 0;
}