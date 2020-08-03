//
// Created by bsdl on 2020/6/17.
//

#include <iostream>
#include <set>

using namespace std;

//struct node {
//    int addr;
//    bool isVisited;
//    int next;
//};
//
//int main() {
//    node linkedList[100000];
//    int addr1, addr2, n;
//    scanf("%d %d %d", &addr1, &addr2, &n);
//    for (int i = 0; i < n; i++) {
//        int addr, letter, next;
//        scanf("%d %c %d", &addr, &letter, &next);
//        linkedList[addr] = {addr, false, next};
//    }
//    for (int a = addr1; a != -1; a = linkedList[a].next) {
//        linkedList[a].isVisited = true;
//    }
//    int start = addr2;
//    while (!linkedList[start].isVisited) {
//        start = linkedList[start].next;
//    }
//    if (start == -1) {
//        cout << -1;
//    } else {
//        printf("%05d", linkedList[start].addr);
//    }
//    return 0;
//}

int main() {
    set<int> s;
    int addr1, addr2, n;
    scanf("%d %d %d", &addr1, &addr2, &n);
    for (int i = 0; i < n; i++) {
        int addr, letter, next;
        scanf("%d %c %d", &addr, &letter, &next);
        if (next != -1 && s.find(next) == s.end()) {
            s.insert(next);
        } else if (next != -1) {
            printf("%05d", next);
            return 0;
        }
    }
    cout << -1;
    return 0;
}