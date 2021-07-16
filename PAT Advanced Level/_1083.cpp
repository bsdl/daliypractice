#include <iostream>
#include <algorithm>

using namespace std;

struct student {
    string name;
    string id;
    int grade;
};

bool comparator(student s1, student s2) {
    return s1.grade > s2.grade;
}

int main() {
    int N;
    cin >> N;
    student students[101];
    for (int i = 0; i < N; i++) {
        student stu;
        cin >> stu.name >> stu.id >> stu.grade;
        students[i] = stu;
    }
    int min, max;
    scanf("%d %d", &min, &max);
    sort(students, students + N, comparator);
    int cnt = 0;
    for (int i = 0; i < N; i++) {
        if (students[i].grade <= max && students[i].grade >= min) {
            cnt++;
            cout << students[i].name << " " << students[i].id << endl;
        }
        if (students[i].grade < min) {
            break;
        }
    }
    if (cnt == 0) {
        cout << "NONE";
    }
    return 0;
}