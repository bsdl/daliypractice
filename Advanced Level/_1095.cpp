#include <iostream>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

struct Record {
    string plate;
    int timestamp;
    int status;
    bool isValid = false;
} cars[10010];

map<string, int> timePeriods;

bool comparator1(Record r1, Record r2) {
    if (r1.plate == r2.plate) {
        return r1.timestamp < r2.timestamp;
    }
    return r1.plate < r2.plate;
}

bool comparator2(Record r1, Record r2) {
    return r1.timestamp < r2.timestamp;
}

int main() {
    int n, k;
    scanf("%d %d", &n, &k);
    int maxTimePeriod = 0;
    for (int i = 0; i < n; i++) {
        char plate[8];
        int hh, mm, ss;
        char status[4];
        scanf("%s %d:%d:%d %s", plate, &hh, &mm, &ss, status);
        int timestamp = hh * 3600 + mm * 60 + ss;
        cars[i].plate = plate;
        cars[i].timestamp = timestamp;
        cars[i].status = status[0] == 'i' ? 0 : 1;
    }
    sort(cars, cars + n, comparator1);
    for (int i = 0; i < n - 1; i++) {
        if (cars[i].plate == cars[i + 1].plate) {
            if (cars[i].status == 0 && cars[i + 1].status == 1) {
                cars[i].isValid = cars[i + 1].isValid = true;
                timePeriods[cars[i].plate] += cars[i + 1].timestamp - cars[i].timestamp;
                maxTimePeriod = max(timePeriods[cars[i].plate], maxTimePeriod);
            }
        }
    }
    sort(cars, cars + n, comparator2);
    int idx = 0, cnt = 0;
    for (int i = 0; i < k; i++) {
        int hh, mm, ss;
        scanf("%d:%d:%d", &hh, &mm, &ss);
        int now = hh * 3600 + mm * 60 + ss;
        while (idx < n && cars[idx].timestamp <= now) {
            if (cars[idx].isValid) {
                if (cars[idx].status == 0) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
            idx++;
        }
        printf("%d\n", cnt);
    }
    for (auto &it: timePeriods) {
        if (it.second == maxTimePeriod) {
            printf("%s ", it.first.c_str());
        }
    }
    printf("%02d:%02d:%02d", maxTimePeriod / 3600, maxTimePeriod % 3600 / 60, maxTimePeriod % 60);
    return 0;
}