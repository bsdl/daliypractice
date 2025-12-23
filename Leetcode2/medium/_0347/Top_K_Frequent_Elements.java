package medium._0347;

import java.util.*;


// 需要一个能够根据出现频率快速获取元素的数据结构,即优先队列
class Top_K_Frequent_Elements {
//    public List<Integer> topKFrequent(int[] nums, int k) {
//        if (k == 0) {
//            return new ArrayList<>();
//        }
//        List<Integer> list = new ArrayList<>();
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
//        for(int key: map.keySet()) {
//            if(pq.size() < k) {
//                pq.add(key);
//            }else if(map.get(key) > map.get(pq.peek())) {
//                pq.remove();
//                pq.add(key);
//            }
//        }
//        while(!pq.isEmpty()) {
//            list.add(pq.remove());
//        }
//        return list;
//    }


    public List<Integer> topKFrequent(int[] nums, int k) {
        if (k == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] sortedOccur = new List[nums.length + 1];
        for(int key: map.keySet()) {
            int index = map.get(key);
            if(sortedOccur[index] == null) {
                sortedOccur[index] = new ArrayList<>();
            }
            sortedOccur[index].add(key);
        }
        for(int i = sortedOccur.length - 1; i >= 0; i--) {
            if(sortedOccur[i] != null && result.size() < k) {
                result.addAll(sortedOccur[i]);
            }
        }
        return result;
    }
}