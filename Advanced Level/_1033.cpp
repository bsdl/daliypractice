#include <iostream>
#include <algorithm>
#include <vector>
#define INF 0x3fffffff

using namespace std;

struct Station {
    double price, dist;
};

bool cmp(Station s1, Station s2) {
    return s1.dist < s2.dist;
}


int main() {
    double cMax, d, dAvg;
    int n;
    scanf("%lf %lf %lf %d", &cMax, &d, &dAvg, &n);
    vector<Station> stations(n + 1);
    for (int i = 0; i < n; i++) {
        scanf("%lf %lf", &stations[i].price, &stations[i].dist);
    }
    stations[n].dist = d;
    sort(stations.begin(), stations.end(), cmp);
    double totalPrice = 0.0, curPrice;
    if (stations[0].dist > 0) {
        printf("The maximum travel distance = 0.00");
        return 0;
    } else {
        curPrice = stations[0].price;
    }
    double curDist = 0.0, remainDist = 0.0;
    while (curDist < d) {
        double minPrice = INF,  minPriceDist = 0;
        double maxRange = cMax * dAvg + curDist;
        bool flag = true;
        for (int i = 1; i <= n && stations[i].dist <= maxRange; i++) {
            if (stations[i].dist <= curDist) continue;
            if (stations[i].price < curPrice) {
                totalPrice += (stations[i].dist - curDist - remainDist) / dAvg * curPrice;
                remainDist = 0.0;
                curPrice = stations[i].price;
                curDist = stations[i].dist;
                flag = false;
                break;
            }
            if (stations[i].price < minPrice) {
                minPrice = stations[i].price;
                minPriceDist = stations[i].dist;
            }
        }
        if (flag && minPrice != INF) {
            totalPrice += (cMax - remainDist / dAvg) * curPrice;
            remainDist = cMax * dAvg - (minPriceDist - curDist);
            curPrice = minPrice;
            curDist = minPriceDist;
        } else if (flag && minPrice == INF) {
            double maxDist = curDist + cMax * dAvg;
            printf("The maximum travel distance = %.2lf", maxDist);
            return 0;
        }
    }
    printf("%.2lf", totalPrice);
    return 0;
}
