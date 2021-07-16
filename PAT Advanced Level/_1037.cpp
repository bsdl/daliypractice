#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> nev_coupons;
vector<int> pos_coupons;
vector<int> nev_prod;
vector<int> pos_prod;

bool cmp(int n1, int n2) {
    return n1 > n2;
}

int main() {
    int nc, np;
    cin >> nc;
    for (int i = 0; i < nc; i++) {
        int coupons;
        scanf("%d", &coupons);
        if (coupons > 0) {
            pos_coupons.push_back(coupons);
        } else if (coupons < 0) {
            nev_coupons.push_back(coupons);
        }
    }
    cin >> np;
    for (int i = 0; i < np; i++) {
        int product;
        scanf("%d", &product);
        if (product > 0) {
            pos_prod.push_back(product);
        } else if(product < 0) {
            nev_prod.push_back(product);
        }
    }
    sort(nev_coupons.begin(), nev_coupons.end());
    sort(pos_coupons.begin(), pos_coupons.end(), cmp);
    sort(nev_prod.begin(), nev_prod.end());
    sort(pos_prod.begin(), pos_prod.end(), cmp);
    int pos_coup_size = pos_coupons.size(), pos_prod_size = pos_prod.size();
    int idx = 0;
    int ans = 0;
    while (idx < pos_coup_size && idx < pos_prod_size) {
        ans += pos_prod[idx] * pos_coupons[idx];
        idx++;
    }
    int nev_coup_size = nev_coupons.size(), nev_prod_size = nev_prod.size();
    idx = 0;
    while (idx < nev_coup_size && idx < nev_prod_size) {
        ans += nev_prod[idx] * nev_coupons[idx];
        idx++;
    }
//    while (idx < nev_prod_size) {
//        ans -= nev_prod[idx];
//        idx++;
//    }
    printf("%d", ans);
    return 0;
}

