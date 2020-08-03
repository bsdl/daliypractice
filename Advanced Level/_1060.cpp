#include <iostream>
#include <cstring>

using namespace std;

int main() {
	int chop;
	string str1, str2;
	// chop�����ѧ������С�����ĸ���
	cin >> chop >> str1 >> str2;
	char sigs1[10000], sigs2[10000];
	// ����e1��e2�ߵ�С�����λ��
	int e1 = 0, e2 = 0;
	while (e1 < str1.length() && str1[e1] != '.') e1++;
	while (e2 < str2.length() && str2[e2] != '.') e2++;
	// ��p��q�ߵ���һ���������������£��п���Խ��С����
	int p = 0, q = 0;
	while (str1[p] == '0' || str1[p] == '.') p++;
	while (str2[q] == '0' || str2[q] == '.') q++;
	// e1��e2�������ָ��������p��q��λ�ü�������ָ��
	if (p <= e1) {
		e1 -= p;
	}
	else {
		e1 = e1 - p + 1;
	}
	if (q <= e2) {
		e2 -= q;
	}
	else {
		e2 = e2 - q + 1;
	}
	if (p == str1.length()) {
		e1 = 0;
	}
	if (q == str2.length()) {
		e2 = 0;
	}
	// ����Ч��λ�洢���������ֲ�0
	int idx1 = 0, idx2 = 0;
	while (idx1 < chop) {
		if (str1[p] != '.' && p < str1.length()) {
			sigs1[idx1++] = str1[p];
		}
		else if (p >= str1.length()) {
			sigs1[idx1++] = '0';
		}
		p++;
	}
	while (idx2 < chop) {
		if (str2[q] != '.' && q < str2.length()) {
			sigs2[idx2++] = str2[q];
		}
		else if (q >= str2.length()) {
			sigs2[idx2++] = '0';
		}
		q++;
	}
	// �����Ч��λ��Ȳ���ָ��Ҳ���
	if (strcmp(sigs1, sigs2) == 0 && e1 == e2) {
		printf("YES 0.%s*10^%d", sigs1, e1);
	}
	else {
		printf("NO 0.%s*10^%d 0.%s*10^%d", sigs1, e1, sigs2, e2);
	}
	return 0;
}