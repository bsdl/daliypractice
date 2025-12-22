package com.bsdl.medium._0381;

import java.util.*;

class RandomizedSet {
    Set<Integer> set;
    List<Integer> indexes;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        set = new HashSet<>();
        indexes = new ArrayList<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }else {
            set.add(val);
            indexes.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (set.contains(val)) {
            set.remove(val);
            indexes.set(indexes.indexOf(val), indexes.get(indexes.size() - 1));
            indexes.remove(indexes.size() - 1);
            return true;
        } else {
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return indexes.get(random.nextInt(indexes.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */


// Duplicates allowed version
class RandomizedCollection {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        boolean isNotContained = false;
        if(map.containsKey(val)) {
            map.put(val, map.get(val) + 1);
        }else {
            map.put(val, 1);
            isNotContained = true;
        }
        return isNotContained;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean isContained = true;
        if(map.containsKey(val)) {
            if(map.get(val) == 1) {
                map.remove(val);
            }else {
                map.put(val, map.get(val) - 1);
            }
            list.set(list.indexOf(val), list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }else {
            isContained = false;
        } 
        return isContained;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */