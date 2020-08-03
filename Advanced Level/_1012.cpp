#include <iostream>
#include <algorithm>
#include <vector>
#include <map>

using namespace std;

struct Student
{
	int id;
	int scores[4];
	int ranks[4];
	int bestRank;
	char bestCourse;

}stus[2077];

int cid = -1;

bool comparator(Student s1, Student s2) {
	return s1.scores[cid] > s2.scores[cid];
}

int main() {
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		scanf("%d%d%d%d", &stus[i].id, &stus[i].scores[1], 
			&stus[i].scores[2], &stus[i].scores[3]);
		stus[i].scores[0] =
			(stus[i].scores[1] + stus[i].scores[2] + stus[i].scores[3]) / 3.0 + 0.5;		
	}
	
	char courses[4] = { 'A', 'C', 'M', 'E' };
	for (int i = 0; i < 4; i++) {
		cid = i;
		sort(stus, stus + n, comparator);
		stus[0].ranks[cid] = 1;
		for (int j = 1; j < n; j++) {
			if (stus[j].scores[cid] == stus[j - 1].scores[cid]) {
				stus[j].ranks[cid] = stus[j - 1].ranks[cid];
			}
			else {
				stus[j].ranks[cid] = j + 1;	
			}
		}
	}
	map<int, Student> hash;
	for (int i = 0; i < n; i++) {
		Student stu = stus[i];
		int bestRank = stu.ranks[0];
		char bestCourse = courses[0];
		for (int j = 1; j < 4; j++) {
			if (stu.ranks[j] < bestRank) {
				bestRank = stu.ranks[j];
				bestCourse = courses[j];
			}
		}
		stu.bestRank = bestRank;
		stu.bestCourse = bestCourse;
		hash[stu.id] = stu;
	}
	while (m > 0) {
		m--;
		int id;
		scanf("%d", &id);
		if (hash.count(id) > 0) {
			printf("%d %c\n", hash[id].bestRank, hash[id].bestCourse);
		}
		else {
			puts("N/A");
		}
	}
	return 0;
}
