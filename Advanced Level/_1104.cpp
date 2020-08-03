#include <iostream>
#include <vector>

using namespace std;

vector<float> v;
float sum = 0;


int main() {
	int n;
	cin >> n;
	v.resize(n);
	for (int i = 0; i < n; i++) {
		scanf("%f", &v[i]);
	}
	//vector<float> sub;
	for (int i = 0; i < n; i++) {
		for (int j = i; j < n; j++) {
			float tmp = 0;
			for (int k = i; k <= j; k++) {
				tmp += v[k];
			}
			sum += tmp;
		}
	}
	printf("%.2f", sum);
	return 0;
}