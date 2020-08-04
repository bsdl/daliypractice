#include <iostream>
#include <string>
#include <map>
#include <algorithm>
#include <vector>

using namespace std;

struct Node {
    string school;
    int scores[3] = {0};
    int cnt = 0;
    int tws = 0;
};

string toLower(string str) {
    string res ;
    int len = str.length();
    for (int i = 0; i < len; i++) {
        char ch = str[i];
        if(isupper(ch)) {
            ch += 'a' - 'A';
        }
        res += ch;
    }
    return res;
}

int getIdx(char ch) {
    if (ch == 'A') {
        return 0;
    } else if (ch == 'B') {
        return 1;
    } else {
        return 2;
    }
}

bool comparator(Node n1, Node n2) {
    if (n1.tws != n2.tws) {
        return n1.tws > n2.tws;
    } else if (n1.cnt != n2.cnt) {
        return n1.cnt < n2.cnt;
    } else {
        return n1.school < n2.school;
    }
}

int main() {
    int n;
    cin >> n;
    map<string, Node> m;
    for (int i = 0; i < n; i++) {
        string id, sc;
        int gr;
        cin >> id >> gr >> sc;
        sc = toLower(sc);
        char level = id[0];
        int idx = getIdx(level);
        m[sc].cnt++;
        m[sc].scores[idx] += gr;
        m[sc].school = sc;
    }
    vector<Node> nodes;
    for (auto & it : m) {
        it.second.tws = it.second.scores[0] + it.second.scores[1] / 1.5 + it.second.scores[2] * 1.5;
        nodes.push_back(it.second);
    }
    sort(nodes.begin(), nodes.end(), comparator);
    int size=  nodes.size();
    cout << size << endl;
    int lastRank = 1;
    for (int i = 0; i < size; i++) {
        int rank = -1;
        if (i > 0) {
            if (nodes[i].tws == nodes[i - 1].tws) {
                rank = lastRank;
            } else {
                rank = i + 1;
            }
        } else {
            rank = i + 1;
        }
        cout << rank << " " << nodes[i].school << " " << nodes[i].tws << " " << nodes[i].cnt << endl;
        lastRank = rank;
    }
    return 0;
}
