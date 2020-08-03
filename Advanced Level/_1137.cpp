#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
#include <math.h>

using namespace std;

struct student
{
	string id;
	int usual = -1, mid_term = -1, final = -1;
	int g = -1;
};

bool comparator(student s1, student s2) {
	return s1.g != s2.g ? s1.g > s2.g : s1.id < s2.id;
}

int main() {
	int p, m, n;
	cin >> p >> m >> n;
	map<string, student> students;
	for (int i = 0; i < p; i++) {
		string id;
		int score;
		cin >> id >> score;
		student stu = {};
		stu.id = id;
		stu.usual = score;
		students[id] = stu;
	}
	for (int i = 0; i < m; i++) {
		string id;
		int score;
		cin >> id >> score;
		if (students.find(id) != students.end()) {
			students[id].mid_term = score;
		}
		else {
			student stu = {};
			stu.id = id;
			stu.mid_term = score;
			students[id] = stu;
		}
	}
	for (int i = 0; i < n; i++) {
		string id;
		int score;
		cin >> id >> score;
		if (students.find(id) != students.end()) {
			students[id].final = score;
		}
		else {
			student stu = {};
			stu.id = id;
			stu.final = score;
			students[id] = stu;
		}
	}
	vector<student> v;
	for (auto it = students.begin(); it != students.end(); it++) {
		student stu = it->second;
		stu.g = stu.mid_term > stu.final ? round(stu.mid_term * 0.4 + stu.final * 0.6) : stu.final;
		v.push_back(stu);
		
	}
	sort(v.begin(), v.end(), comparator);
	for (student stu : v) {
		if (stu.g >= 60 && stu.usual >= 200) {
			cout << stu.id << " " << stu.usual << " " << 
				stu.mid_term << " " << stu.final << " " << stu.g << endl;
		}
	}
	return 0;
}