//
// Created by bsdl on 2021/4/24.
//
#include <iostream>
#include <vector>
#include <list>
#include <map>
#include <unordered_map>
using namespace std;
class LRUCache {
public:
    LRUCache(int capacity) {
        _capacity = capacity;
    }

    int get(int key) {
        if (_cache.find(key) == _cache.end()) {
            return -1;
        } else {
            _dLinkedList.erase(_cache[key]);
            _dLinkedList.push_front(*_cache[key]);
            return _cache[key]->second;
        }
    }

    void put(int key, int value) {
        pair<int, int> node = make_pair(key, value);
        if (_cache.count(key) > 0) {
            _dLinkedList.erase(_cache[key]);
        } else {
            if (_dLinkedList.size() == _capacity) {
                _cache.erase(_dLinkedList.back().first);
                _dLinkedList.pop_back();
            }
        }
        _dLinkedList.push_front(node);
        _cache[key] = _dLinkedList.begin();
    }

private:
    list<pair<int, int>> _dLinkedList;
    map<int, list<pair<int, int>>:: iterator> _cache;
    int _capacity;
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */

int main() {
    auto* obj = new LRUCache(2);
    obj->put(1,1);
    obj->put(2,2);
    int param_1 = obj->get(1);
    cout << param_1 << endl;
    obj->put(3,3);
    cout << obj->get(2) << endl;
    obj->put(4,4);
    cout << obj->get(1) << endl;
    cout << obj->get(3) << endl;
    cout << obj->get(4) << endl;
    return 0;
}