//
// Created by bsdl on 2021/3/20.
//

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int maxProfit(vector<int>& prices) {
    int currentMinPrices[prices.size()];
    int currentMinPrice = prices[0];
    for (int i =0 ; i < (int) prices.size(); i++) {
        currentMinPrice = min(currentMinPrice, prices[i]);
        currentMinPrices[i] = currentMinPrice;
    }
    int dp[prices.size()];
    dp[0] = 0;
    for (int i = 1; i < (int) prices.size(); i++) {
        dp[i] = max(dp[i - 1], prices[i] - currentMinPrices[i]);
    }
    return dp[prices.size() - 1];
}


int main() {
    vector<int> v{7,1,5,3,6,4};
    cout << maxProfit(v) << endl;
    return 0;
}