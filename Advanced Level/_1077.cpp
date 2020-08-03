#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
	int n;
	scanf("%d\n", &n);
	vector<string> sentences;
	for (int i = 0; i < n; i++) {
		string sentence;
		getline(cin, sentence);
		sentences.push_back(sentence);
	}
	string kuchiguse = sentences[0];
	string suffix = "";
	for (int i = 1; i < n; i++) {
		string s2 = sentences[i];
		int idx1 = kuchiguse.length() - 1, idx2 = s2.length() - 1;
		while (idx1 >= 0 && idx2 >= 0 && kuchiguse[idx1] == s2[idx2]) {		
			suffix = kuchiguse[idx1] + suffix;
			idx1--;
			idx2--;
		}
		if (suffix.length() == 0) {
			printf("nai");
			return 0;
		}
		else {
			kuchiguse = suffix;
			suffix.clear();
		}
	}
	cout << kuchiguse;
	return 0;
}
