#include <iostream>
#include <unordered_map>
#include <map>
#include <set>
#include <vector>
#include <algorithm>

using namespace std;

struct Node {
    string name;
    int weight;
};
struct Result {
    string name;
    int cnt;
};
int n, k;
map<string, vector<string>> graph;
unordered_map<string, bool> visit;
map<string, int> vertexWeights;
map<string, int> pathWeight;
set<string> component;
int totalWeight;

void dfs(string &name) {
    visit[name] = true;
    component.insert(name);
    for (string& next: graph[name]) {
        if (!visit[next]) {
            totalWeight += pathWeight[name + next];
            dfs(next);
        } else {
            totalWeight += pathWeight[name + next];
        }
    }
}


bool cmp(Node n1, Node n2) {
    if (n1.weight == n2.weight) {
        return n1.name < n2.name;
    }
    return n1.weight > n2.weight;
}

int main() {
    cin >> n >> k;
    for (int i = 0; i < n; i++) {
        string name1, name2;
        int weight;
        cin >> name1 >> name2 >> weight;
        graph[name1].push_back(name2);
        pathWeight[name1 + name2] = weight;
        vertexWeights[name1] += weight;
        vertexWeights[name2] += weight;
    }
    vector<Node> nodes;
    for (auto &it: vertexWeights) {
        nodes.push_back({it.first, it.second});
    }
    sort(nodes.begin(), nodes.end(), cmp);
    vector<Result> results;
    for (Node node: nodes) {
        if (!visit[node.name]) {
            component.clear();
            totalWeight = 0;
            dfs(node.name);
            if (component.size() > 2 && totalWeight > k) {
                int size = component.size();
                results.push_back({node.name, size});
            }
        }
    }
    printf("%d\n", results.size());
    for (Result res: results) {
        cout << res.name << " " << res.cnt << endl;
    }
    return 0;
}