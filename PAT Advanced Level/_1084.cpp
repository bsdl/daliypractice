//
// Created by bsdl on 2020/6/16.
//

#include <iostream>
#include <unordered_set>
#include <cctype>

using namespace std;

int main() {
    string og, typo;
    cin >> og;
    cin >> typo;
    unordered_set<char> set;
    int ogLen = og.length();
    int typoLen = typo.length();
    for (int i = 0; i < typoLen; i++) {
        set.insert(toupper(typo[i]));
    }
    unordered_set<char> occured;
    for (int i = 0; i < ogLen; i++) {
        char ch = toupper(og[i]);
        if (set.find(ch) == set.end()) {
            if (occured.find(ch) == occured.end()) {
                cout << ch;
            }
            occured.insert(ch);
        }
    }
    return 0;
}