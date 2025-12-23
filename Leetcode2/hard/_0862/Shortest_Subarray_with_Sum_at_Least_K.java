package hard._0862;

import java.util.Deque;
import java.util.LinkedList;

class Shortest_Subarray_with_Sum_at_Least_K {
//    public int shortestSubarray(int[] A, int K) {
//        int len = A.length;
//        int shortest = len + 1;
//        int[] preSum = new int[len];
//        preSum[0] = A[0];
//        for (int i = 1; i < len; i++) {
//            preSum[i] = preSum[i - 1] + A[i];
//        }
//        for (int i = 0; i < len; i++) {
//            int sum = i == 0 ? preSum[len - 1] : preSum[len - 1] - preSum[i - 1];
//            for (int j = len - 1; j >= i; j--) {
//                if (sum >= K) {
//                    shortest = Math.min(shortest, j - i + 1);
//                }
//                sum -= A[j];
//            }
//        }
//        return shortest == len + 1 ? -1 : shortest;
//    }

//    public int shortestSubarray(int[] A, int K) {
//        int len = A.length;
//        int shortest = len + 1;
//        int[] preSum = new int[len];
//        preSum[0] = A[0];
//        for (int i = 1; i < len; i++) {
//            preSum[i] = preSum[i - 1] + A[i];
//        }
//        for (int i = 0; i < len; i++) {
//            for (int j = i; j < len; j++) {
//                if(preSum[j] - preSum[i] >= K) {
//                    shortest = Math.min(shortest, j - i + 1);
//                }
//            }
//        }
//        return shortest == len + 1 ? -1 : shortest;
//    }


    public int shortestSubarray(int[] A, int K) {
        int len = A.length;
        int shortest = len + 1;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + A[i];
        }
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < len + 1; i++) {
            while (!deque.isEmpty() && preSum[i] <= preSum[deque.getLast()]) {
                deque.pollLast();
            }
            while(!deque.isEmpty() && preSum[i] - preSum[deque.getFirst()] >= K) {
                shortest = Math.min(shortest, i - deque.pollFirst());
            }
            deque.addLast(i);
        }
        return shortest == len + 1 ? -1 : shortest;
    }

//    public int shortestSubarray(int[] A, int K) {
//        int subLen = A.length + 1;
//        for (int i = 0; i < A.length; i++) {
//            for (int j = i; j < A.length; j++) {
//                int sum = 0;
//                for (int k = i; k <= j; k++) {
//                    sum += A[k];
//                }
//                if (sum >= K) {
//                    subLen = Math.min(subLen, j - i + 1);
//                }
//            }
//        }
//        return subLen == A.length + 1 ? -1 : subLen;
//    }

    public static void main(String[] args) {
        Shortest_Subarray_with_Sum_at_Least_K s = new Shortest_Subarray_with_Sum_at_Least_K();
        System.out.println(s.shortestSubarray(new int[]{2,-1,2}, 3));
    }
}