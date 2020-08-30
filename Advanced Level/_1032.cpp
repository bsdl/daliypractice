#include <iostream>
#include <set>

using namespace std;

struct Node {
    char data;
    int next;
}linkedList[100000];

int main() {
    int head1, head2, n;
    scanf("%d %d %d", &head1, &head2, &n);
    set<int> addrs;
    for (int i = 0; i < n; i++) {
        int addr, next;
        char data;
        scanf("%d %c %d", &addr, &data, &next);
        linkedList[addr].data = data;
        linkedList[addr].next = next;
    }
    int node = head1;
    while (node != -1) {
        addrs.insert(node);
        node = linkedList[node].next;
    }
    node = head2;
    while (node != -1) {
        if (addrs.count(node) > 0) {
            printf("%05d", node);
            return 0;
        } else {
            node = linkedList[node].next;
        }
    }
    printf("-1");
    return 0;
}