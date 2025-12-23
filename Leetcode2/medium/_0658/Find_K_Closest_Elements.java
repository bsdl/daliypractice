package medium._0658;

import java.util.*;

class Find_K_Closest_Elements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new LinkedList<>();
        if(x <= arr[0]) {
            for(int num: Arrays.copyOfRange(arr, 0, k)) {
                list.add(num);
            }
        }else if(x >= arr[arr.length - 1]) {
            for(int num: Arrays.copyOfRange(arr, arr.length - k, arr.length)) {
                list.add(num);
            }
        }else {
            int left = 0, right = arr.length - 1;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(arr[mid] == x) {
                    break;
                }else if(arr[mid] > x) {
                    right = mid;
                }else {
                    left = mid + 1;
                }
            }
            int start = left;
            if(Math.abs(arr[left] - x) > Math.abs(arr[left - 1] - x)) {
                start = left - 1;
            }
            list.add(arr[start]);
            int fir = start - 1, sec = start + 1;
            k--;
            while(fir >= 0 && sec <= arr.length - 1 && k > 0) {
                int next = Math.min(x - arr[fir--], arr[sec++] - x);
                list.add(next);
                k--;
            }
            while(k > 0 && fir >= 0) {
                list.add(arr[fir--]);
                k--;
            }
            while(k > 0 && sec <= arr.length - 1) {
                list.add(arr[sec++]);
                k--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Find_K_Closest_Elements f = new Find_K_Closest_Elements();
        f.findClosestElements(new int[]{1,2,3,4,5}, 4, 3);
    }
}