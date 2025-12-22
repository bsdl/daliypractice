package com.bsdl.medium._0621;

import java.util.*;

public class Solution {
//    public int leastInterval(char[] tasks, int n) {
//        // 记录每个任务出现的次数
//        int[] taskOccTimes = new int[26];
//        for (char task : tasks) {
//            taskOccTimes[task - 'A']++;
//        }
//        // 采用最大堆的做法，即相同次数越多的任务与靠近堆顶
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//        for (int times : taskOccTimes) {
//            if (times > 0) {
//                pq.add(times);
//            }
//        }
//        int time = 0;
//        while (!pq.isEmpty()) {
//            List<Integer> list = new ArrayList<>();
//            // 索引每次从0开始，(n + 1)单位时间为一循环（出现次数最多的任务第二次出现为一循环）
//            int index = 0;
//            while (index <= n) {
//                if(!pq.isEmpty()) {
//                    // 每次都从堆顶取出最大值，减一后（相当于执行了一任务）放进临时数组，如果任务数只剩一次，那么直接丢弃
//                    if (pq.peek() > 1) {
//                        list.add(pq.poll() - 1);
//                    } else {
//                        pq.poll();
//                    }
//                }
//                time++;
//                // 当所有的任务都执行完毕但这一循环还没结束，直接退出循环
//                if(pq.isEmpty() && list.isEmpty()) {
//                    break;
//                }
//                index++;
//
//            }
//            // 将还有剩余执行次数的任务放回堆
//            pq.addAll(list);
//        }
//        return time;
//    }

    // 另一种做法
    // 首先找出次数最多的任务，然后分两种情况：
    // 1.当最多任务A的冷却时间(a - 1) * n大于其余任务数量时，所需的总时间为(a - 1) * n + a, a为任务A的数量
    // 2.当任务A的冷却时间小于等于其余任务数量时，总时间即为任务列表长度，所有任务都可以完美分配
    public int leastInterval(char[] tasks, int n) {
        int[] taskOcrTimes = new int[26];
        int maxTimes = 0;
        for (char task : tasks) {
            taskOcrTimes[task - 'A']++;
            maxTimes = Math.max(maxTimes, taskOcrTimes[task - 'A']);
        }
        int time = (maxTimes - 1) * n + maxTimes;
        for (int times : taskOcrTimes) {
            if (times == maxTimes) {
                time++;
            }
        }
        time--;
        return Math.max(time, tasks.length);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}
