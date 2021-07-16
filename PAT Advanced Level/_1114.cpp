#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Member {
    int id, fid, mid, mEstate, area;
    int cid[8];
} member[1020];

struct Node {
    int id, people;
    double sets, area;
    bool flag = false;
}res[10000];

int parents[10000];
bool isVisited[10000] = {false};

int find(int root) {
    int son = root, tmp;

    while (parents[root] != root) {
        root = parents[root];
    }
    while (son != root) {
        tmp = parents[son];
        parents[son] = root;
        son = tmp;
    }
    return root;
}

void join(int root1, int root2) {
    int x = find(root1);
    int y = find(root2);
    if (x > y) {
        parents[x] = y;
    } else if (x < y) {
        parents[y] = x;
    }
}

bool cmp(Node n1, Node n2) {
    if (n1.area == n2.area) {
        return n1.id < n2.id;
    }
    return n1.area > n2.area;
}

int main() {
    for (int i = 0; i < 10000; i++) {
        parents[i] = i;
    }
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        int k;
        scanf("%d %d %d %d", &member[i].id, &member[i].fid, &member[i].mid, &k);
        isVisited[member[i].id] = true;
        if (member[i].fid != -1) {
            isVisited[member[i].fid] = true;
            join(member[i].fid, member[i].id);
        }
        if (member[i].mid != -1) {
            isVisited[member[i].mid] = true;
            join(member[i].mid, member[i].id);
        }
        for (int j = 0; j < k; j++) {
            scanf("%d", &member[i].cid[j]);
            isVisited[member[i].cid[j]] = true;
            join(member[i].cid[j], member[i].id);
        }
        scanf("%d %d", &member[i].mEstate, &member[i].area);
    }
    for (int i = 0; i < n; i++) {
        int id = member[i].id;
        int root = find(id);
        res[root].id = root;
        res[root].sets += member[i].mEstate;
        res[root].area += member[i].area;
        res[root].flag = true;
    }
    int cnt = 0;
    for (int i = 0; i < 10000; i++) {
        if (isVisited[i]) {
            res[find(i)].people++;
        }
        if (res[i].flag) {
            cnt++;
        }
    }
    for (int i = 0; i < 10000; i++) {
        if (res[i].flag) {
            res[i].sets = res[i].sets / res[i].people;
            res[i].area = res[i].area / res[i].people;
        }
    }
    sort(res, res + 10000, cmp);
    printf("%d\n", cnt);
    for (int i = 0; i < cnt; i++) {
        printf("%04d %d %.3f %.3f\n", res[i].id, res[i].people, res[i].sets, res[i].area);
    }
    return 0;
}

