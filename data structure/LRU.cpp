#include <iostream>
#include <unordered_map>

using namespace std;

class LRUCache {
public:

    LRUCache(int capacity) {
        this->capacity = capacity;
        this->size = 0;
        head = new DLinkedListNode(-1, -1);
        tail = new DLinkedListNode(-1, -1);
        head->next = tail;
        tail->pre = head;
        head->pre = nullptr;
        tail->next = nullptr;
    }

    int get(int key) {
        DLinkedListNode *node = mp[key];
        if (node == nullptr) {
            return -1;
        } else {
            moveToHead(node);
            return node->value;
        }
    }

    void put(int key, int value) {
        if (mp[key] != nullptr) {
            mp[key]->value = value;
            moveToHead(mp[key]);
        } else {
            auto *node = new DLinkedListNode(key, value);
            addNodeToHead(node);
            mp[key] = node;
            size++;
            if (size > capacity) {
                DLinkedListNode *poppedNode = popTail();
                mp.erase(poppedNode->key);
                size--;
            }
        }
    }

private:

    struct DLinkedListNode {
        int key, value;
        DLinkedListNode *next = nullptr;
        DLinkedListNode *pre = nullptr;

        DLinkedListNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    };

    int capacity;
    int size;
    unordered_map<int, DLinkedListNode *> mp;
    DLinkedListNode *head;
    DLinkedListNode *tail;

    void moveToHead(DLinkedListNode *node) {
        deleteNode(node);
        addNodeToHead(node);
    }

    void addNodeToHead(DLinkedListNode *node) {
        node->next = head->next;
        head->next->pre = node;
        head->next = node;
        node->pre = head;
    }

    void deleteNode(DLinkedListNode *node) {
        DLinkedListNode *preNode = node->pre;
        DLinkedListNode *nextNode = node->next;
        preNode->next = node->next;
        nextNode->pre = node->pre;
    }

    DLinkedListNode *popTail() {
        DLinkedListNode *lastNode = tail->pre;
        deleteNode(lastNode);
        return lastNode;
    }
};


int main() {
    auto *obj = new LRUCache(2);
    obj->put(1, 1);
    obj->put(2, 2);
    int pa1 = obj->get(1);
    obj->put(3, 3);
    int pa2 = obj->get(2);
    obj->put(4, 4);
    int pa3 = obj->get(1);
    int pa4 = obj->get(3);
    int pa5 = obj->get(4);
    printf("%d %d %d %d %d", pa1, pa2, pa3, pa4, pa5);
    return 0;
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */