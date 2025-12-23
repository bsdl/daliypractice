package medium._0380;

import java.util.*;

class RandomizedSet {

    // Set<Integer> set;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        // set = new HashSet<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (list.contains(val))
            return false;
        else {
            list.add(val);
            return true;
        }
            
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (list.contains(val)) {
            list.remove(val);
            return true;
        } else
            return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {     
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */