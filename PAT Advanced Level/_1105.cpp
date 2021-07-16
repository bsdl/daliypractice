#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool comparator(int n1, int n2) {
	return n1 > n2;
}

int main() {
	int N;
	cin >> N;
	vector<int> v(N);
	for (int i = 0; i < N; i++) {
		scanf("%d", &v[i]);
	}
	sort(v.begin(), v.end(), comparator);
	int m, n = 1;
	int diff = INT32_MAX;
	int final_m = N, final_n = 1;
	while (n <= N / 2) {
		if (N % n == 0) {
			m = N / n;
			if (m < n) {
				break;
			}
			if (diff > m - n) {
				diff = m - n;
				final_m = m;
				final_n = n;
			}
		}
		n++;
	}

	vector<vector<int>> matrix(final_m);
	for (int i = 0; i < final_m; i++) {
		matrix[i].resize(final_n);
	}
	int start = 0;
	int top = 0, bottom = final_m - 1, left = 0, right = final_n - 1;
	while (start < N) {
		for (int i = left; i <= right; i++) {
			matrix[top][i] = v[start++];
		}
		if (++top > bottom) break;
		for (int i = top; i <= bottom; i++) {
			matrix[i][right] = v[start++];
		}
		right--;
		if (start == N) break;
		for (int i = right; i >= left; i--) {
			matrix[bottom][i] = v[start++];
		}
		bottom--;
		for (int i = bottom; i >= top; i--) {
			matrix[i][left] = v[start++];
		}
		left++;
	}
	for (int i = 0; i < final_m; i++) {
		for (int j = 0; j < final_n; j++) {
			printf("%d", matrix[i][j]);
			if (j == final_n - 1) {
				printf("\n");
			}
			else {
				printf(" ");
			}
		}
	}
	return 0;
}