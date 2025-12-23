package hard._0312;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
//    int coins;
//    public int maxCoins(int[] nums) {
//        coins = 0;
//        if(nums.length == 0) {
//            return coins;
//        }
//        List<Integer> balloons = new LinkedList<>();
//        for(int num : nums) {
//            balloons.add(num);
//        }
//        dfs(balloons, 0);
//        return coins;
//    }
//
//    private void dfs(List<Integer> balloons, int _coins) {
//        if(balloons.size() == 0) {
//            coins = Math.max(coins, _coins);
//            return;
//        }
//        for(int i = 0; i < balloons.size(); i++) {
//            int left = i == 0? 1: balloons.get(i - 1);
//            int right = i == balloons.size() - 1? 1: balloons.get(i + 1);
//            _coins += left * balloons.get(i) * right;
//            List<Integer> list = new LinkedList<>(balloons);
//            list.remove(i);
//            dfs(list, _coins);
//            _coins -= left * balloons.get(i) * right;
//        }
//    }

//    public int maxCoins(int[] nums) {
//
//    }
}
