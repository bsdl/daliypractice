package _904;


import java.util.*;

class Solution {
    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> baskets = new HashMap<>();
        int left, right, maxVal = 0, count = 0;
        for (left = right = 0; right < fruits.length; right++) {
            int type = fruits[right];
            if (baskets.get(type) == null) {
                if (baskets.size() == 2) {        
                    while (left < right) {
                        int oldType = fruits[left++];
                        baskets.put(oldType, baskets.get(oldType) - 1);
                        count--;                        
                        if (baskets.get(oldType) == 0) {
                            baskets.remove(oldType);
                            break;
                        }
                    }
                }
                baskets.put(type, 1);       
            } else {
                baskets.put(type, baskets.get(type) + 1);  
            }
            maxVal = Math.max(maxVal, ++count);
        }
        return maxVal;
    }


    public static void main(String[] args) {
        int [] fruits = {1,2,1};
        int val = Solution.totalFruit(fruits);
        System.out.println(val);
    }
}
