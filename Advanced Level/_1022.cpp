#include <iostream>
#include <set>
#include <map>

using namespace std;

map<string, set<int>> titles, authors, keywords, publishers, years;

void print(map<string, set<int>> &m, string &query) {
    if (m[query].begin() == m[query].end()) {
        printf("Not Found\n");
    } else {
        for (int id: m[query]) {
            printf("%07d\n", id);
        }
    }
}

int main() {
    int n, k;
    cin >> n;
    for (int i = 0; i < n; i++) {
        int id;
        string title, author, keyword, publisher, year;
        scanf("%d\n", &id);
        getline(cin, title);
        titles[title].insert(id);
        getline(cin, author);
        authors[author].insert(id);
        while (cin >> keyword) {
            keywords[keyword].insert(id);
            char ch = getchar();
            if (ch == '\n') {
                break;
            }
        }
        getline(cin, publisher);
        publishers[publisher].insert(id);
        getline(cin, year);
        years[year].insert(id);
    }
    cin >> k;
    for (int i = 0; i < k; i++) {
        int qid;
        scanf("%d: ", &qid);
        string query;
        getline(cin, query);
        cout << qid << ": " << query << endl;
        switch (qid) {
            case 1:
                print(titles, query);
                break;
            case 2:
                print(authors, query);
                break;
            case 3:
                print(keywords, query);
                break;
            case 4:
                print(publishers, query);
                break;
            case 5:
                print(years, query);
                break;
            default: break;
        }

    }
}

