//
// Created by bsdl on 2020/6/18.
//


#include <map>

using namespace std;

int main() {
    int M, N;
    scanf("%d %d", &M, &N);
    int area = M * N;
    map<int, int> m;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            int num;
            scanf("%d", &num);
            m[num]++;
            if (m[num] > area / 2) {
                printf("%d", num);
                return 0;
            }
        }
    }
    return 0;
}