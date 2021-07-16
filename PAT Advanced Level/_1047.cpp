//
// Created by bsdl on 2020/6/18.
//

#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

char name[40000][5];


bool comparator(int a, int b) {
    return strcmp(name[a], name[b]) < 0;
}

int main() {
    vector<int> courses[2501];
    int numOfStu, numOfCourse;
    scanf("%d %d", &numOfStu, &numOfCourse);
    for (int i = 0; i < numOfStu; i++) {
        int cnt;
        scanf("%s %d", name[i], &cnt);
        int cId;
        for (int j = 0; j < cnt; j++) {
            scanf("%d", &cId);
            courses[cId].push_back(i);
        }
    }
    for (int cId = 1; cId <= numOfCourse; cId++) {
        int size = courses[cId].size();
        sort(courses[cId].begin(), courses[cId].end(), comparator);
        printf("%d %d\n", cId, size);
        for (int i = 0; i < size; i++) {
            printf("%s\n", name[courses[cId][i]]);
        }
    }
    return 0;
}