#include <iostream>
#include <set>

using namespace std;

int main() {
    int m,n,s;
    cin>>m>>n>>s;
    bool hasWinner = false;
    int next = s;
    set<string> isVisited;
    for (int i = 1; i <= m;i++) {
        string nickname;
        cin>>nickname;
        if (i == next) {
            if (isVisited.count(nickname) > 0) {
                next++;
            } else {
                hasWinner = true;
                cout << nickname << endl;
                next += n;
                isVisited.insert(nickname);
            }
        }
    }
    if (!hasWinner) {
        printf("Keep going...\n");
    }
    return 0;
}

