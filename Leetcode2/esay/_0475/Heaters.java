package com.bsdl.esay._0475;

import java.util.Arrays;

class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        if (heaters.length == 1) {
            return Math.max(heaters[0] - houses[0], houses[houses.length - 1] - heaters[0]);
        }
        int maxRadius = 0;
        for (int house: houses) {
            int left = 0;
            int right = heaters.length - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (heaters[mid] < house) {
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }
            int dist = 0;
            if (heaters[left] == house) {
                dist = 0;
            } else if (heaters[left] < house) {
                dist = house - heaters[left];
            } else if (heaters[left] > house && left != 0) {
                dist = Math.min(heaters[left] - house, house - heaters[left - 1]);
            } else {
                dist = heaters[left] - house;
            }
            maxRadius = Math.max(dist, maxRadius);
        }
        return maxRadius;
    }

    public static void main(String[] args) {
        // int[] arr1 = {1,2,3,4};
        // int[] arr2 = {1,4};
        // Heaters h = new Heaters();
        // int res = h.findRadius(arr1, arr2);

    }
}