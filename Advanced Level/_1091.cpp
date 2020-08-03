#include <iostream>
#include <queue>

using namespace std;

struct node 
{
	int x, y, z;
};

bool isVisited[1300][130][70];
int brain[1300][130][70];

int X[6] = { 1, 0, 0, -1, 0, 0 };
int Y[6] = { 0, 1, 0, 0, -1, 0 };
int Z[6] = { 0, 0, 1, 0, 0, -1 };
int m, n, l, threshold;


bool isValid(int x, int y, int z) {
	if (x < 0 || y < 0 || z < 0 || x >= m || y >= n || z >= l) {
		return false;
	}
	if (brain[x][y][z] == 0 || isVisited[x][y][z]) {
		return false;
	}
	return true;
}


int bfs(int x, int y, int z) {
	int cnt = 0;
	queue<node> que;
	node n = { x, y, z };
	que.push(n);
	while (!que.empty()) {
		node cur = que.front();
		que.pop();
		isVisited[x][y][z] = true;
		cnt++;
		for (int i = 0; i < 6; i++) {
			int newX = cur.x + X[i];
			int newY = cur.y + Y[i];
			int newZ = cur.z + Z[i];
			if (isValid(newX, newY, newZ)) {
				que.push({ newX, newY, newZ });
				isVisited[newX][newY][newZ] = true;
			}
		}
		
	}
	return cnt >= threshold ? cnt : 0;
}

int main() {
	scanf("%d %d %d %d", &m, &n, &l, &threshold);
	for (int i = 0; i < l; i++) {
		for (int j = 0; j < m; j++) {
			for (int k = 0; k < n; k++) {
				scanf("%d", &brain[j][k][i]);
			}
		}
	}
	int volume = 0;
	for (int i = 0; i < l; i++) {
		for (int j = 0; j < m; j++) {
			for (int k = 0; k < n; k++) {
				if (brain[j][k][i] == 1 && !isVisited[j][k][i]) {
					volume += bfs(j, k, i);
				}
			}
		}
	}
	printf("%d", volume);
	return 0;
	
}
