#include <iostream>
#include <cmath>
#include <cstring>
#include <cctype>
#include <vector>
#include <algorithm>
#include <stack>
#include <queue>
#include <set>
#include <map>

using namespace std;


int main() {
    int n, m ,c;
    cin >> n >> m >> c;
    vector<vector<int>> stringOfPearls(n);
    vector<int> colors(c + 1, 0);
    set<int> illegals;
    for (int i = 0; i < n; i++) {
        int colorNum;
        cin >> colorNum;
        stringOfPearls[i].resize(colorNum);
        for (int j = 0; j < colorNum; j++) {
            cin >> stringOfPearls[i][j];
        }
    }
    queue<vector<int>> que;
    int idx = 0, cnt = 0;
    while (idx < m) {
        vector<int> pearl = stringOfPearls[idx];
        for (int colorId: pearl) {
            if (colors[colorId] >= 1) {
                illegals.insert(colorId);
            }
            colors[colorId]++;
        }
        que.push(pearl);
        idx++;
    }
    cnt++;
    while (cnt <= n) {
        vector<int> pearl = que.front();
        que.pop();
        for (int colorId: pearl) {
            colors[colorId]--;
        }
        pearl = stringOfPearls[idx];
        for (int colorId: pearl) {
            if (colors[colorId] >= 1) {
                illegals.insert(colorId);
            }
            colors[colorId]++;
        }
        que.push(pearl);
        idx++;
        if (idx == n) {
            idx = 0;
        }
        cnt++;
    }
    cout << illegals.size();
    return 0;
}

// 4
//int main() {
//    int n;
//    cin >> n;
//    while(n > 0) {
//        n--;
//        int m;
//        cin >> m;
//        int maxFeatureMotion = 0;
//        map<vector<int>, int> motionCounts;
//        set<vector<int>> lastFrame;
//        set<vector<int>> tmpLastFrame;
//        for (int i = 0; i < m; i++) {
//            tmpLastFrame.clear();
//            int frameNum;
//            cin >> frameNum;
//            for (int j = 0; j < frameNum; j++) {
//                vector<int> motion(2);
//                int l, r;
//                scanf("%d %d", &l, &r);
//                motion[0] = l, motion[1] = r;
//                if (lastFrame.count(motion) == 0) {
//                    motionCounts[motion] = 1;
//                } else {
//                    motionCounts[motion] += 1;
//                }
//                tmpLastFrame.insert(motion);
//                maxFeatureMotion = max(motionCounts[motion], maxFeatureMotion);
//            }
//            lastFrame = tmpLastFrame;
//        }
//        cout << maxFeatureMotion << endl;
//    }
//    return 0;
//}

