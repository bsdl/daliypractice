#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

struct People {
    string name;
    int height;
};

bool comparator (People p1, People p2) {
    return p1.height != p2.height ? p1.height > p2.height : p1.name < p2.name;
}

int main() {
    int n, k;
    cin >> n >> k;
    vector<People> v;
    vector<vector<string>> group;
    for (int i = 0; i < n; i++) {
        string name;
        int height;
        cin >> name >> height;
        v.push_back({name, height});
    }
    sort(v.begin(), v.end(), comparator);
    int rowNum = round(n * 1.0 / k);
    int extraPeople = n - rowNum * k;
    int idx = 0;
    int insertedPeople = 0;
    for (int i = 0; i < k; i++) {
        vector<string> row;
        int rowPeopleNum;
        if (i == 0) {
            rowPeopleNum = extraPeople + rowNum;
        } else {
            rowPeopleNum = rowNum;
        }
        row.resize(rowPeopleNum);
        insertedPeople += rowPeopleNum;
        int pos = rowPeopleNum / 2;
        int increment = 1;
        row[pos] = v[idx++].name;
        bool isLeft = true;
        while (idx < insertedPeople) {
            People people = v[idx++];
            pos += isLeft ? (-increment) : increment;
            row[pos] = people.name;
            increment++;
            isLeft = !isLeft;
        }
        group.push_back(row);
    }
    for (vector<string> row: group) {
        bool isFirst = true;
        for (string name: row) {
            if (isFirst) {
                isFirst = false;
                cout << name;
            } else {
                cout << " " << name;
            }
        }
        puts("");
    }
    return 0;
}
